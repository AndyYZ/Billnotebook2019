package test;
  
import javax.swing.JButton;
import javax.swing.JPanel;
  
import util.GUIUtil;
  
public class Test_GUIUtil {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        JPanel p = new JPanel();
        p.add(new JButton("Button1"));
        p.add(new JButton("Button2"));
        GUIUtil.showPanel(p);
    }
}