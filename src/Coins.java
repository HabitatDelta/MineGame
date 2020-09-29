/**
 *
 * @author J. Barrett
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

public class Coins {
    
public class Coin extends Rectangle{
    int value;
    boolean available;
    public Coin(int x1, int y1) {
        super(x1, y1, 8, 20);
        value = 1;
        available = true;
    }
    
    public void draw(Graphics g){
        g.setColor(new Color(100,100,100));
        g.fillOval(x+3, y+3, width, height);
        g.setColor(new Color(216,192,24));
        g.fillOval(x, y, width, height);
        g.setColor(Color.black);
        g.drawString("|", x+3, y+14); 
        g.drawOval(x, y, width, height);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
}

}