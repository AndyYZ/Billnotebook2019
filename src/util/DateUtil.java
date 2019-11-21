package util;
 
import java.util.Calendar;
import java.util.Date;
 
public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;   
 
    public static java.sql.Date util2sql(java.util.Date d){
        return  new java.sql.Date(d.getTime());
    }
     
    /**
     * Get today date
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c.getTime();
         
    }
 
    /**
     * beginning of month
     * @return
     */
 
    public static Date monthBegin() {
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	c.set(Calendar.DATE, 1);
    	
    	c.set(Calendar.HOUR_OF_DAY, 0);
    	c.set(Calendar.MINUTE, 0);
    	c.set(Calendar.SECOND, 0);
    	c.set(Calendar.MILLISECOND, 0);
    	return c.getTime();
    	
    }
     
    /**
     * end of month
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND,0); //from Yeenjie
         
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONDAY, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }
 
    /**
     * #days in a month
     * @return
     */
    public static int thisMonthTotalDay(){
         
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
        
 
//        System.out.println((int)((lastDayMilliSeconds-firstDayMilliSeconds)*1.0/lastDayMilliSeconds)+1);
 
        return (int) ((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay) +1;
    }
     
    /**
     *Days left in a month 
     * @return
     */
     
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfOneDay) +1;
    }   
     
    public static void main(String[] args) {
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(thisMonthLeftDay());
        System.out.println(thisMonthTotalDay());
    }
}