package service;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import com.birosoft.liquid.LiquidSplitPaneUI;

import dao.RecordDAO;
//import entity.Category;
import entity.Record;
import util.DateUtil;
 
public class ReportService {
 
    /**
     *To get the expense of a specific date
     * @param d
     * @param monthRawData
     * @return
     */
	public int getDaySpend(Date d,List<Record> monthRawData){
	   int daySpend = 0;
	   for(Record record : monthRawData){
		   if(record.date.equals(d)){
			   daySpend += record.spend;
			}
	   }
	   return daySpend;
   }
         
    /**
     * To get this month's expense
     * @return
     */
    public List<Record> listThisMonthRecords() {
        RecordDAO dao= new RecordDAO();
        List<Record> monthRawData= dao.listThisMonth();
        List<Record> result= new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth=c.getTime() ;
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.spend=daySpend;
            result.add(r);
        }
        return result;
 
    }
 
}

 