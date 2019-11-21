package gui.panel;
 
import static util.GUIUtil.setColor;
import static util.GUIUtil.showPanel;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
 
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;
 
public class SpendPanel extends WorkingPanel {
	 static{
		 GUIUtil.useLNF();
	 }
	SpendPage spendPage = new SpendService().getSpendPage(); //Diff
	
	
	public static SpendPanel instance = new SpendPanel();
 
    JLabel lMonthSpend = new JLabel("Montly");
    JLabel lTodaySpend = new JLabel("Daily");
    JLabel lAvgSpendPerDay = new JLabel("DailyAvg");
    JLabel lMonthLeft = new JLabel("MonLeft");
    JLabel lDayAvgAvailable = new JLabel("DailyAvbl");
    JLabel lMonthLeftDay = new JLabel("DayLeft");
 
    JLabel vMonthSpend = new JLabel("");
    JLabel vTodaySpend = new JLabel("");
    JLabel vAvgSpendPerDay = new JLabel("");
    JLabel vMonthAvailable = new JLabel("");
    JLabel vDayAvgAvailable = new JLabel("");
    JLabel vMonthLeftDay = new JLabel("1");
    
//    for test only
//    JLabel vMonthSpend = new JLabel("$400");
//    JLabel vTodaySpend = new JLabel("$8");
//    JLabel vAvgSpendPerDay = new JLabel("$15");
//    JLabel vMonthAvailable = new JLabel("$301");
//    JLabel vDayAvgAvailable = new JLabel("$327");
//    JLabel vMonthLeftDay = new JLabel("15 days");
    
    
 
    CircleProgressBar bar;
 
    public SpendPanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);
        
        //set montlyspend and today spend value to blue, and all others to gray
        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
 
        vMonthSpend.setFont(new Font("TimesRoman", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("TimesRoman", Font.BOLD, 23));
 
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
 
    }
 
    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(east());
 
        return p;
    }
 
    private Component east() { 
 
        return bar;
    }
 
    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend); //Monthly Spend
        p.add(vMonthSpend);
        p.add(lTodaySpend); //Daily Spend
        p.add(vTodaySpend);
        return p;
    }
 
    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
 
        p.add(lAvgSpendPerDay); // 2 x 4 
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
 
        return p;
    }
 
//    @Override
    public void updateData() {
        SpendPage spend = new SpendService().getSpendPage();
         vMonthSpend.setText(spend.monthSpend);
         vTodaySpend.setText(spend.todaySpend);
         vAvgSpendPerDay.setText(spend.avgSpendPerDay);
         vMonthAvailable.setText(spend.monthAvailable);
         vDayAvgAvailable.setText(spend.dayAvgAvailable);
         vMonthLeftDay.setText(spend.monthLeftDay);
 
         bar.setProgress(spend.usagePercentage);
         if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);
  
         } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
         }
         bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
         addListener();  
 
    }
// 
//    @Override
    public void addListener() {
        // TODO Auto-generated method stub
// 
    }
    
    public static void main(String[] args) {
        showPanel(SpendPanel.instance);
    }
}

 