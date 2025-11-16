import java.awt.*;
import java.awt.event.*;

public class FormCalculadora extends Frame implements ActionListener{

    TextField tfDigitar = new TextField();
    Button btnClear = new Button("C");
    Button btn1 =  new Button("1");
    Button btn2 =  new Button("2");
    Button btn3 =  new Button("3");
    Button btn4 =  new Button("4");
    Button btn5 =  new Button("5");
    Button btn6 =  new Button("6");
    Button btn7 =  new Button("7");
    Button btn8 =  new Button("8");
    Button btn9 =  new Button("9");
    Button btn0 =  new Button("0");
    Button btnDividir =  new Button("/");
    Button btnMultiplicar =  new Button("*");
    Button btnSubtrair =  new Button("-");
    Button btnSomar =  new Button("+");
    Button btnPonto =  new Button(".");
    Button btnIgual =  new Button("=");

    public FormCalculadora(){

        setTitle("Calculadora");
        setSize(230, 280);
        setLocation(300, 200);
        setBackground(Color.lightGray);
        addWindowListener(new FechaJanela());
        setLayout(new BorderLayout());

        //Painel Digitacao
        Panel painelDigitacao = new Panel();
        painelDigitacao.setLayout(new BorderLayout());

        tfDigitar.setPreferredSize(new Dimension(0, 40));
        painelDigitacao.add(tfDigitar, BorderLayout.CENTER);

        //Painel Botoes
        
        Panel painelBotoes = new Panel();
        painelBotoes.setLayout(new GridLayout(4, 4, 0, 0));
        
        painelBotoes.add(btn7); painelBotoes.add(btn8); painelBotoes.add(btn9); painelBotoes.add(btnDividir);
        painelBotoes.add(btn4); painelBotoes.add(btn5); painelBotoes.add(btn6); painelBotoes.add(btnMultiplicar);
        painelBotoes.add(btn1); painelBotoes.add(btn2); painelBotoes.add(btn3); painelBotoes.add(btnSubtrair);
        painelBotoes.add(btn0); painelBotoes.add(btnPonto); painelBotoes.add(btnIgual); painelBotoes.add(btnSomar);

        
        //painelInferior

        Panel painelinferior = new Panel();
        painelinferior.setLayout(new GridLayout(1, 4, 0, 0));

        painelinferior.add(btnClear); painelinferior.add(new Label("")); painelinferior.add(new Label("")); painelinferior.add(new Label(""));

        //adicionando paineis aos formularios

        add(painelDigitacao, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(painelinferior, BorderLayout.SOUTH);

        //eventos nos botoes

        btnClear.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnDividir.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnSubtrair.addActionListener(this);
        btnSomar.addActionListener(this);
        btnPonto.addActionListener(this);
        btnIgual.addActionListener(this);

    }

     @Override
     public void actionPerformed(ActionEvent e){

        Object src = e.getSource();

        if (src == btn0) { tfDigitar.setText(tfDigitar.getText() + "0"); }
        if (src == btn1) { tfDigitar.setText(tfDigitar.getText() + "1"); }
        if (src == btn2) { tfDigitar.setText(tfDigitar.getText() + "2"); }
        if (src == btn3) { tfDigitar.setText(tfDigitar.getText() + "3"); }
        if (src == btn4) { tfDigitar.setText(tfDigitar.getText() + "4"); }
        if (src == btn5) { tfDigitar.setText(tfDigitar.getText() + "5"); }
        if (src == btn6) { tfDigitar.setText(tfDigitar.getText() + "6"); }
        if (src == btn7) { tfDigitar.setText(tfDigitar.getText() + "7"); }
        if (src == btn8) { tfDigitar.setText(tfDigitar.getText() + "8"); }
        if (src == btn9) { tfDigitar.setText(tfDigitar.getText() + "9"); }

        if(src == btnClear){

            tfDigitar.setText("");

        }

        if(src == btnDividir){

            String txt = tfDigitar.getText();

            if (txt.isEmpty()) return;
            if (ultimoEhOperador(txt)) return;

            tfDigitar.setText(txt + "/");   

        }

        if(src == btnMultiplicar){

            String txt = tfDigitar.getText();

            if (txt.isEmpty()){
                return;
            }

            if (ultimoEhOperador(txt)){
                return;
            }

            tfDigitar.setText(txt + "*");

        }

        if(src == btnSubtrair){

            String txt = tfDigitar.getText();
    
            if (txt.isEmpty()) {

                tfDigitar.setText("-");
                return;
            }

            if (ultimoEhOperador(txt)){
                return;
            };

            tfDigitar.setText(txt + "-");

        }

        if(src == btnSomar){

            String txt = tfDigitar.getText();

            if (txt.isEmpty()){
                return;
            }          

            if (ultimoEhOperador(txt)){
                return;
            }    

            tfDigitar.setText(txt + "+");

        }

        if(src == btnPonto){

            String txt = tfDigitar.getText();

    
    if (txt.isEmpty()) return;

    
    int ultimoOp = Math.max(
        Math.max(txt.lastIndexOf('+'), txt.lastIndexOf('-')),
        Math.max(txt.lastIndexOf('*'), txt.lastIndexOf('/'))
    );

    String ultimoNumero = txt.substring(ultimoOp + 1);

    if (ultimoNumero.contains(".")) return;

    tfDigitar.setText(txt + ".");

        }

        if(src == btnIgual){

            try {

                String exp = tfDigitar.getText().trim();

                if (exp.isEmpty()) {
                    tfDigitar.setText("Erro");
                    return;
                }

                String numeroAnterior = "";
                String numeroPosterior = "";
                char operadorAtual = 0;
                boolean achouOperador = false;

                for (int i = 0; i < exp.length(); i++) {
                    char c = exp.charAt(i);

                    if (Character.isDigit(c) || c == '.') {
                        if (!achouOperador)
                            numeroAnterior += c;
                        else
                            numeroPosterior += c;
                    } else if (c == '+' || c == '-' || c == '*' || c == '/') {

                        if (i == 0 && c == '-') {
                            numeroAnterior += "-";
                            continue;
                        }
                        
                        if (!achouOperador) {
                            achouOperador = true;
                            operadorAtual = c;
                        } else {

                            double n1 = Double.parseDouble(numeroAnterior);
                            double n2 = Double.parseDouble(numeroPosterior);

                            if (operadorAtual == '/' && n2 == 0) {
                                tfDigitar.setText("Erro");
                                return;
                            }

                            double parcial = calcular(n1, n2, operadorAtual);

                            numeroAnterior = String.valueOf(parcial);

                            numeroPosterior = "";
                            operadorAtual = c;
                        }
                    } else {
                        tfDigitar.setText("Erro");
                        return;
                    }
                }

                double final1 = Double.parseDouble(numeroAnterior);
                double final2 = Double.parseDouble(numeroPosterior);

                if (operadorAtual == '/' && final2 == 0) {
                    tfDigitar.setText("Erro");
                    return;
                }

                double resultado = calcular(final1, final2, operadorAtual);

                tfDigitar.setText(String.valueOf(resultado));

            } catch (Exception ex) {

                    tfDigitar.setText("Erro");
                    return;

            }

        }

     }

    public double calcular(double a, double b, char op) {
        switch (op) {

            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }

        return 0;
    }

    public boolean ultimoEhOperador(String s) {
    if (s.isEmpty()) return true;
    char c = s.charAt(s.length() - 1);
    return (c == '+' || c == '-' || c == '*' || c == '/');
}

}
