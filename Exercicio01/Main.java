import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Files.TasksList;
import java.awt.Color;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//  javac .\Main.java   para atualizar o Main.class
//  java Main           para rodar

public class Main {
    public static void main(String[] args) {

        // Painel para todas as tarefas
        JPanel pnAllTasks = new JPanel();
        pnAllTasks.setLayout(new BoxLayout(pnAllTasks, BoxLayout.Y_AXIS));

        // Configuração do frame
        JFrame frame = new JFrame();
        TasksList tasksList = new TasksList(frame, pnAllTasks);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o frame e encerra a aplicação

        // Botão para adicionar tarefas
        JButton btAdd = new JButton("Adicionar");
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                tasksList.setLocationRelativeTo(null);
                tasksList.setVisible(true);
            }
        });

        JLabel lbTasks = new JLabel("Lista de Tarefas:");
        lbTasks.setForeground(Color.BLUE);

        // Painel para o botão
        JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnButton.add(btAdd);

        // Adiciona o label ao painel de todas as tarefas
        pnAllTasks.add(lbTasks);

        // Painel para as tarefas
        JPanel pnTask = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnTask.add(pnAllTasks);

        // Painel principal com BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(pnButton);
        mainPanel.add(pnTask);

        // Adiciona o painel principal ao frame
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza o frame na tela
        frame.setVisible(true);
    }
}