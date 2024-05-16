package Files;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Forma extends JComponent {

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(new Color(0, 0, 50));
    g.fillRect(0, 0, 600, 600);

    int N = 1000;
    int[] x = new int[N];
    int[] y = new int[N];

    Point center = new Point(300, 300);
   
    double dTheta = 2 * Math.PI / N;  // (2 * Math.PI) = 360° dividido pela quantidade de pontos pra saber quantos angulos 
                                      //vai ter que ser deslocado pra ele completar o "circilo" para a estrela ficar completa
    double theta = 0;

    for (int i = 0; i < N; i++) {
      double vx = 0, vy = 0;
      double dist = 150 + 30 * Math.cos(5 * theta);


      vx = dist * Math.cos(theta);
      vy = dist * Math.sin(theta);
      theta += dTheta;

      x[i] = (int) (center.getX() + vx);
      y[i] = (int) (center.getY() + vy);
    }

    g.setColor(Color.yellow);
    g.fillPolygon(x, y, N);
  }
}