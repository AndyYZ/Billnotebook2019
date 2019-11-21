package service;
 
import java.util.List;
 
import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DBUtil;
import util.DateUtil;
 
public class SpendService {
 
    public SpendPage getSpendPage() {
        RecordDAO dao = new RecordDAO();
        // Current month data
        List<Record> thisMonthRecords = dao.listThisMonth();
        // Today's data
        List<Record> toDayRecords = dao.listToday();
        // #days of this month
       int thisMonthTotalDay = DateUtil.thisMonthTotalDay();
 
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;
 
        // budget
        int monthBudget = new ConfigService().getIntBudget();
 
        // Expense till today
        for(Record record : thisMonthRecords){
        	monthSpend += record.getSpend();
        }
 
        // Today's expense
        for(Record record : toDayRecords){
        	todaySpend += record.getSpend();
        }
        
        //  average daily expense
        avgSpendPerDay = monthSpend / thisMonthTotalDay;
        
        // left budget of the month
        monthAvailable = monthBudget - monthSpend;
 
        // left days of the month
        monthLeftDay = DateUtil.thisMonthLeftDay();
 
        // average available for the rest of the day
        dayAvgAvailable = monthAvailable / monthLeftDay;
 
        // percentage
       usagePercentage = monthSpend*100 / monthBudget;
 
 
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
                usagePercentage);
    }
}