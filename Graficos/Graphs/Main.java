import javax.swing.*;
import java.awt.*;
import Files.Graph;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        Graph graph = new Graph();

        graph.add(150f, Color.blue);

        JTextField tfValue = new JTextField("", 20);
        JLabel lbValue = new JLabel();
        lbValue.setText("Digite o valor:");
        JButton btValue = new JButton();
        btValue.setText("Adicionar");

        btValue.addActionListener(e -> {
            graph.add(200f, Color.red);
            frame.repaint();
        });

        JPanel pnValue = new JPanel();
        pnValue.setLayout(
            new FlowLayout(FlowLayout.CENTER)
        );
        pnValue.setSize(600, 200);
        pnValue.add(lbValue);
        pnValue.add(tfValue);
        pnValue.add(btValue);

        JPanel pnMain = new JPanel();
        pnMain.setSize(600, 800);
        pnMain.setLayout(
            new BoxLayout(pnMain, BoxLayout.Y_AXIS)
        );
        pnMain.add(pnValue);
        pnMain.add(graph);
        graph.setSize(600, 600);
        
        frame.add(pnMain);
        frame.setVisible(true);
    }
}