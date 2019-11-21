package gui.page;
 
public class SpendPage {
	
    public String monthSpend;
    
    public String todaySpend;
    //average spent per day
    public String avgSpendPerDay;
    //left for the month
    public String monthAvailable;
    //daily available
    public String dayAvgAvailable;
    //days left
    public String monthLeftDay;
    //expense spent in percentage
    public int usagePercentage;
    //over spend?
    public boolean isOverSpend = false;
    
    public  SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
            int monthLeftDay, int usagePercentage){
    	
    	this.monthSpend = "$"+monthSpend;
    	this.todaySpend = "$"+todaySpend;
    	this.avgSpendPerDay = "$"+avgSpendPerDay;
    	
    	if(monthAvailable<0){
    		isOverSpend = true;
    	}
    	
    	if(!isOverSpend){
    		this.monthAvailable = "$"+monthAvailable;
    		this.dayAvgAvailable = "$"+dayAvgAvailable;
    	}else {
    		this.monthAvailable = "$"+(0-monthAvailable);
    		this.dayAvgAvailable = "$0";
    	}
    	
    	this.monthLeftDay = monthLeftDay+" days";
    	this.usagePercentage = usagePercentage;

	}
}