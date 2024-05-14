
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        
        //PAINEL 1
        JPanel pnTasks = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 5, 5)
        );
        //PAINEL 1
        JPanel pnLogin = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 5, 5)
        );
   
      
       //MAIN PAINEL
       JPanel mainPanel = new JPanel();
       mainPanel.setLayout(
           new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
       );
        
    }
    
}