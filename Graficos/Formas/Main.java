import javax.swing.JFrame;
import Files.Star;
import Files.Forma;
// import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        // Timer timer;
        // timer = new Timer(25, e -> {
        //     System.out.println("ola");
        // });
        // timer.start();

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