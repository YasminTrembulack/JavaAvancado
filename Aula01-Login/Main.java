import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Files.MainFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//  javac .\Main.java   para atualizar o Main.class
//  java Main           para rodar

public class Main
{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quando fecha o freme ele encerra

        //LOGIN
        JLabel lbLogin = new JLabel();
        lbLogin.setText("Login:");
        JTextField tfLogin = new JTextField("", 20);

        //SENHA
        JLabel lbPass = new JLabel();
        lbPass.setText("Senha:");
        JPasswordField pfPass = new JPasswordField("",20);
        pfPass.setEchoChar('*');

        //PAINEL LOGIN
        JPanel pnLogin = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 5, 5)
        );
        //Conteiver /Div, é como ele vai organizar essa div, tipo um flex box.
        pnLogin.add(lbLogin);
        pnLogin.add(tfLogin);

        //PAINEL SENHA
        JPanel pnPass = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 5, 5)
        );
        pnPass.add(lbPass);
        pnPass.add(pfPass);

        //BOTAO
        JButton btLogin = new JButton("Entrar");

        //BOTAOACTION RUIM HORRIVEL Antigo
        //      btLogin.addActionListener(new MyButtonActionListener());//Action do botao
        
        //BOTAOACTION
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if(!tfLogin.getText().equals("don"))
                { 
                    JOptionPane.showMessageDialog(null, "NAO, voce nao :)");
                    return;
                }

                String correctPass = "verstapi";
                char[] password = pfPass.getPassword();
                String userPass = new String(password);

                if (correctPass.length() != password.length) 
                {
                    JOptionPane.showMessageDialog(null,"NAO, voce nao :)");
                    return;
                }

                if(!userPass.equals(correctPass))
                {
                    JOptionPane.showMessageDialog(null,"NAO, voce nao :)");
                    return;
                }

                JOptionPane.showMessageDialog(null,"Sim, voce sim!!!");

                frame.setVisible(false);
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });

        //MAIN PAINEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );
        mainPanel.add(pnLogin);
        mainPanel.add(pnPass);
        mainPanel.add(btLogin);


        //ADD NO FRAME
        frame.add(mainPanel);
        frame.pack(); //Ajuste a tela para o tamanho do frame quando abrir
        frame.setVisible(true);
        
    }
    
}