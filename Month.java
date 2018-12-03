import java.text.DecimalFormat;

//an object of this class will represent each month
public class Month {
	
	//declares all enscapulated variables
	private String month;
	private int year;
	private double spending;
	private double earning;
	private static DecimalFormat df = new DecimalFormat();
	
	//creates object with basic $100 allowance
	public Month(String month, int year, double spending) {
		
		this.year = year;
		this.month = month;
		this.spending = spending;
		this.earning = 100.01;
		
	}
	
	//creates object with any allowance other than $100
	public Month(String month, int year, double spending, double earning) {
		
		this.month = month;
		this.year = year;
		this.spending = spending;
		this.earning = earning;
		
		
	}
	
	//returns the object's year
	public int getYear() {
		return year;
	}

	//returns the object's spending
	public double getSpending() {
		return Double.parseDouble(df.format(spending));
	}

	//returns the object's earnings
	public double getEarning() {
		return Double.parseDouble(df.format(earning));
	}
	
	//returns the object's spending
	public String getMonth() {
		return month;
	}


	
	
	

}


