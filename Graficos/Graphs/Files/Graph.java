package Files;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
 
import javax.swing.JComponent;

public class Graph extends JComponent
{
    private ArrayList<Float> values = new ArrayList<Float>();
    private ArrayList<Color> colors = new ArrayList<Color>();

    public void add(Float value, Color color) {
        values.add(value);
        colors.add(color);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        int x = getX();
        int y = 0;
        int width = 600;
        int height = 600;
        
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);

        Float sum = 0f;
        for (Float value : values)
            sum += value;

        Float crrAngle = 0f;
        for (int i = 0; i < colors.size(); i++)
        {
            Float value = values.get(i);
            Color color = colors.get(i);
            Float arc = 360 * value / sum;

            g.setColor(color);
            g.fillArc(x, y, width, height, 
                Math.round(crrAngle), 
                Math.round(arc)
            );
            crrAngle += arc;
        }
    }
}