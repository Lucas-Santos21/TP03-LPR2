import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Form extends Frame implements ActionListener{

    TextField tfNumero = new TextField();
    TextField tfNome = new TextField();
    TextField tfSexo = new TextField();
    TextField tfIdade = new TextField();
    Button btnOk = new Button("OK");
    Button btnLimpar = new Button("Limpar");
    Button btnMostrar = new Button("Mostrar");
    Button btnSair = new Button("Sair");
    
    
    List<Aluno> listAlunos = new ArrayList<>();

    public Form(){

        setTitle("Semana 06 - Exercício 01");
        setSize(400, 180);
        setLocation(300, 200);
        setBackground(Color.lightGray);
        addWindowListener(new FechaJanela());
        setLayout(new BorderLayout());

        //Painel Superior
        
        Panel painelSuperior = new Panel();
        painelSuperior.setLayout(new GridLayout(4, 2, 10, 10));
        Label lblNumero = new Label("Número");
        Label lblNome = new Label("Nome");
        Label lblSexo = new Label("Sexo");
        Label lblIdade = new Label("Idade");

        painelSuperior.add(lblNumero); painelSuperior.add(tfNumero);
        painelSuperior.add(lblNome); painelSuperior.add(tfNome);
        painelSuperior.add(lblSexo); painelSuperior.add(tfSexo);
        painelSuperior.add(lblIdade); painelSuperior.add(tfIdade);

        //painelInferior

        Panel painelinferior = new Panel();
        painelinferior.setLayout(new GridLayout(1, 4, 5, 5));

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

            listAlunos.add(new Aluno(tfNome.getText(), Integer.parseInt(tfIdade.getText()), tfEndereco.getText()));

        }

        if(src == btnLimpar){

            tfNome.setText("");
            tfIdade.setText("");
            tfEndereco.setText("");

        }

        if(src == btnMostrar){

            String saida = "Resultado: \n";

            for(Aluno a : listAlunos){

                saida += "ID: " + a.getUuid() + " Nome: " + a.getNome() + "\n";

            }

            JOptionPane.showMessageDialog(this, saida);

        }
        
        if(src == btnSair){

            System.exit(0);

        }

    }

}
