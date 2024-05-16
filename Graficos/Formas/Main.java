import javax.swing.JFrame;
import Files.Star;
import Files.Forma;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 600);

        Star star = new Star();
        Forma forma = new Forma();

        frame.add(star);
        // frame.add(forma);
    }
}