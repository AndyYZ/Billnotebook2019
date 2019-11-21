package gui.frame;

import gui.panel.MainPanel;

import javax.swing.JFrame;
import util.GUIUtil;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    public MainFrame(){
        this.setSize(500,450);
        this.setTitle("Accout Notebook");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        instance.setVisible(true);
    }


}