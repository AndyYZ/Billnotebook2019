package gui.listener;
 
import java.awt.event.ActionEvent;
 
import java.awt.event.ActionListener;
import java.io.File;
 
import javax.swing.JOptionPane;
 
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;
 
public class ConfigListener implements ActionListener{
 
    @Override
    public void actionPerformed(ActionEvent e) {
      ConfigPanel p = ConfigPanel.instance;
      if (!GUIUtil.checkEmpty(p.tfBudget, "MonBdgt")) {
		return;
     	}
      
      String mysqlPath = p.tfMysqlPath.getText();
      if(0!=mysqlPath.length()){
    	  File commandFile = new File(mysqlPath,"bin/mysql.exe");
    	  if(!commandFile.exists()){
    		  JOptionPane.showMessageDialog(p, "Wrong Mysql path");
    		  p.tfMysqlPath.grabFocus();
    		  return;
    	  }
      }
    
      ConfigService cs = new ConfigService();
      cs.update(ConfigService.budget, p.tfBudget.getText());
      cs.update(ConfigService.mysqlPath, mysqlPath);
      JOptionPane.showMessageDialog(p, "Submit success");
 
    }
    
    
    public static void main(String[] args) { 
    	//System.out.println(mysqlPath);
    }
 
}