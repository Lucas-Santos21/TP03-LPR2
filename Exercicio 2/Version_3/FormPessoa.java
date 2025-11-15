import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormPessoa extends Frame implements ActionListener{

    TextField tfNumero = new TextField();
    TextField tfNome = new TextField();
    JRadioButton rbMasculino = new JRadioButton("M");
    JRadioButton rbFeminino = new JRadioButton("F");
    ButtonGroup grupoSexo = new ButtonGroup();
    TextField tfIdade = new TextField();
    Button btnOk = new Button("OK");
    Button btnLimpar = new Button("Limpar");
    Button btnMostrar = new Button("Mostrar");
    Button btnSair = new Button("Sair");
    Pessoa UmaPessoa;

    public FormPessoa(){

        setTitle("Semana 06 - Exercicio 01");
        setSize(400, 180);
        setLocation(300, 200);
        setBackground(Color.lightGray);
        addWindowListener(new FechaJanela());
        setLayout(new BorderLayout());

        tfNumero.setEditable(false);

        //Painel Superior
        
        Panel painelSuperior = new Panel();
        painelSuperior.setLayout(new GridLayout(4, 2, 10, 1));
        Label lblNumero = new Label("Numero");
        Label lblNome = new Label("Nome");
        Label lblSexo = new Label("Sexo");
        Label lblIdade = new Label("Idade");

        Panel painelSexo = new Panel();
        painelSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);
        
        grupoSexo.add(rbMasculino);
        grupoSexo.add(rbFeminino);

        painelSuperior.add(lblNumero); painelSuperior.add(tfNumero);
        painelSuperior.add(lblNome); painelSuperior.add(tfNome);
        painelSuperior.add(lblSexo); painelSuperior.add(painelSexo);
        painelSuperior.add(lblIdade); painelSuperior.add(tfIdade);

        //painelInferior

        Panel painelinferior = new Panel();
        painelinferior.setLayout(new GridLayout(1, 4, 2, 10));

        painelinferior.add(btnOk); painelinferior.add(btnLimpar);
        painelinferior.add(btnMostrar); painelinferior.add(btnSair);

        add(painelSuperior, BorderLayout.CENTER);
        add(painelinferior, BorderLayout.SOUTH);

        //eventos nos botoes

        btnOk.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);

    }

     @Override
     public void actionPerformed(ActionEvent e){

        Object src = e.getSource();

        if(src == btnOk){

            try {
                
                if(tfNome.getText().trim().isEmpty() || rbMasculino.isSelected() == false && rbFeminino.isSelected() == false || tfIdade.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Os campos Nome, Sexo, e Idade devem ser prechidos");
                return;
                }

                int idade;

                try {

                    idade = Integer.parseInt(tfIdade.getText());

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(this, "O campo Idade deve ser preenchido com numero.");
                    return;
                }

                char sexo = rbMasculino.isSelected() ? 'M' : 'F';

                UmaPessoa = new Pessoa(tfNome.getText(), sexo, idade);

            } catch (Exception ex) {
                return;
            }

        }

        if(src == btnLimpar){

            tfNumero.setText("");
            tfNome.setText("");
            grupoSexo.clearSelection();
            tfIdade.setText("");

        }

        if(src == btnMostrar){

            if (UmaPessoa == null) {
             
                JOptionPane.showMessageDialog(this, "Nenhuma pessoa cadastrada.");
                return;
            }

            tfNumero.setText(String.valueOf(Pessoa.getKp()));
            tfNome.setText(UmaPessoa.getNome());
            
            if (UmaPessoa.getSexo() == 'M') {
             
                rbMasculino.setSelected(true);
            
            } else {
                rbFeminino.setSelected(true);
            }

            tfIdade.setText(Integer.toString(UmaPessoa.getIdade()));

        }
        
        if(src == btnSair){

            System.exit(0);

        }

     }

}
