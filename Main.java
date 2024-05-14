
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Files.TasksList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//  javac .\Main.java   para atualizar o Main.class
//  java Main           para rodar

public class Main
{
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        TasksList tasksList = new TasksList(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quando fecha o freme ele encerra
        
        JButton btAdd = new JButton("Adicionar");
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                frame.setVisible(false);
                tasksList.setVisible(true);

            }
        });

        JLabel lbTasks = new JLabel();
        lbTasks.setText("Lista de Tarefas:");
        
        //PAINEL Button
        JPanel pnButton = new JPanel(
            new FlowLayout(FlowLayout.RIGHT, 5, 5)
        );
        pnButton.add(btAdd);

        //PAINEL Tasks
        JPanel pnTasks = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 5, 5)
        );
        pnTasks.add(lbTasks);


        //Colocar isso dentro do botao salvar do tesk list
        if (tasksList.getSizeTask() == 0) {
            System.out.println("LISTA VAZIA");
        }
        else{
            for(int i = 0;i < tasksList.getSizeTask(); i++ ){
                System.out.println(tasksList.getTasks(i));
            }
        }
    
      
        //MAIN PAINEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.X_AXIS)
        );
        mainPanel.add(pnTasks);
        mainPanel.add(pnButton);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }
    
    
}