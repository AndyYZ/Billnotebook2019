package startup;
 
import javax.swing.SwingUtilities;
 
import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;
 
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
 
        SwingUtilities.invokeAndWait(new Runnable() { //invokeAndWait to start 
            @Override
            public void run() {
                MainFrame.instance.setVisible(true); //Show main frame
                MainPanel.instance.workingPanel.show(SpendPanel.instance);//show spendpanel in the beginning
            }
        });
    }
}

 