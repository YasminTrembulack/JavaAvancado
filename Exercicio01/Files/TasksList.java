package Files;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TasksList extends JFrame{
    private ArrayList<String> tasks = new ArrayList<>();

    public TasksList(JFrame frame){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbAddTasks = new JLabel();
        lbAddTasks.setText("Qual tarefa deseja adicionar:");

        JTextField tfAddTask = new JTextField("", 30);

        TasksList self = this;
        JButton btSalvar = new JButton("Salvar");
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tasks.add(tfAddTask.getText());
                JOptionPane.showMessageDialog(null,"Tarefa adicionada com sucesso!");
                self.setVisible(false);
                frame.setVisible(true);
            }
        });

        JPanel pnAddTask = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 5, 5)
        );
        pnAddTask.add(lbAddTasks);
        pnAddTask.add(tfAddTask);
      
        JPanel pnButton = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 5, 5)
        );
        pnButton.add(btSalvar);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.X_AXIS)
        );
        mainPanel.add(pnAddTask);
        mainPanel.add(pnButton);
       

        this.add(mainPanel);
        this.pack();
    }

    public String getTasks(int index){
        return tasks.get(index);
    }

    public int getSizeTask() {
        return tasks.size();
    }
}
