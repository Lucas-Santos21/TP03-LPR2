import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class FormPessoa extends Frame implements ActionListener{

    TextField tfNumero = new TextField();
    TextField tfNome = new TextField();
    TextField tfSexo = new TextField();
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

        painelSuperior.add(lblNumero); painelSuperior.add(tfNumero);
        painelSuperior.add(lblNome); painelSuperior.add(tfNome);
        painelSuperior.add(lblSexo); painelSuperior.add(tfSexo);
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

            if(tfNome.getText().trim().isEmpty() || tfSexo.getText().trim().isEmpty() || tfIdade.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Os campos Nome, Sexo, e Idade devem ser prechidos");
                return;
            } 

            if(!tfSexo.getText().equalsIgnoreCase("M") && !tfSexo.getText().equalsIgnoreCase("F")){
                
                JOptionPane.showMessageDialog(this, "O campo Sexo deve ser preenchido com \"F\" ou \"M\"");
                return;
            }

            int idade;
                try {
                    
                    idade = Integer.parseInt(tfIdade.getText());
                } 
                
                catch (NumberFormatException ex) {
                 
                    JOptionPane.showMessageDialog(this, "O campo Idade deve ser preenchido com número.");
                    return;
                }

            char sexo = tfSexo.getText().toUpperCase().charAt(0);
            

            UmaPessoa = new Pessoa(tfNome.getText(), sexo, idade);

        }

        if(src == btnLimpar){

            tfNome.setText("");
            tfSexo.setText("");
            tfIdade.setText("");

        }

        if(src == btnMostrar){

            tfNome.setText(UmaPessoa.getNome());
            tfSexo.setText("");
            tfIdade.setText("");

        }
        
        if(src == btnSair){

            System.exit(0);

        }

     }

}
