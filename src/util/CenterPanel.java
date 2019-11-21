package util;
  
import java.awt.Component;
 
import java.awt.Dimension;
 
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;
  
public class CenterPanel extends JPanel {
  
    private double rate;//Stretch ratio
    private JComponent c; //shown component
    private boolean strech; //stretch or not
  
    public CenterPanel(double rate,boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }
      
    public CenterPanel(double rate) {
        this(rate,true);
    }   
  
    public void repaint() {
        if (c != null) {
            Dimension containerSize = this.getSize();
            Dimension componentSize= c.getPreferredSize();
              
            if(strech)
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                c.setSize(componentSize);
  
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        super.repaint();
    }
  
    public void show(JComponent p) {
        this.c = p;
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
        
        if (p instanceof WorkingPanel)
            ((WorkingPanel) p).updateData();//Need this. when the passed comp is instance of working panel, we can updatedata
        this.updateUI(); //redraw, which will call repaint
    }
      
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b  =new JButton("abc");
        cp.show(b);
        System.out.println(cp.getSize());
        System.out.println(b.getSize());
        System.out.println(b.getPreferredSize());
//        cp.repaint();
          
    }
  
}