/**
 *
 * @author NAME
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.ArrayList;

public class MineGame implements ActionListener, KeyListener {
javax.swing.Timer timer;
    JFrame frame;
    JPanel display;
    Person bob;
    ArrayList<Block> blocks;
    Coins coin;

    public static void main(String[] args) throws Exception {
        new MineGame();
    }

    public MineGame() {
        frame = new JFrame("MineGame");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new DisplayPanel();
        frame.add(display);
        //put constructor code here
        bob = new Person();
        blocks = new ArrayList<Block>();

        for (int y = 0; y < 500; y += 100) {
            for (int x = 0; x < 500; x += 25) {
                if (Math.random() > .25) {
                    blocks.add(new Block(x, y));
                }
            }
        }

        //end your constructor code
        timer = new javax.swing.Timer(10, this);
        timer.start();
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        bob.move(blocks);
        if (blocks.get(blocks.size() - 1).y < 401) {
            for (int x = 0; x < 500; x += 25) {
                if (Math.random() > .10) {
                    blocks.add(new Block(x, 500));
                }
            }
        }
        
        display.repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) 
            bob.setDown(true);
        
        if (e.getKeyCode() == KeyEvent.VK_UP) 
            bob.setUp(true);
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
            bob.setRight(true);
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            bob.setLeft(true);
            
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            System.exit(0);
        
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bob.setDown(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bob.setUp(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bob.setRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bob.setLeft(false);
        }
    }

    class DisplayPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //draw your graphics here
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 500);
            bob.draw(g);
            for (Block block : blocks) {
                block.draw(g);
            }
           
    }
}
}