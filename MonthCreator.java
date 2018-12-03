import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public abstract class MonthCreator {
	
		static DecimalFormat df = new DecimalFormat("#.00");
	
		//adds new objects of months, first parameter is month, then year, then spending, then earnings
	    public static Month[] createObjects() {
			
			List<Month> months = new LinkedList();
			months.add(new Month("March", 2017, 7.88, 0.06 + 181.33 + 25));
			months.add(new Month("April", 2017, 9.86 + 11.55 + 7.89 + 2.19 + 6.57 + 11.96, 25 + 40 + 103.62));
			months.add(new Month("May", 2017, 14.18, 25 + 51.80 + 0.02));
			months.add(new Month("June", 2017, 6.30 + 21.99 + 1.08 + 21.99 + 20.88, 25 + 0.02));
			months.add(new Month("July", 2017, 5.04 + 5.23 + 3.78 + 5.23 + 6.55 + 4.40 + 8.40 + 5.23, 25.01));
			months.add(new Month("August", 2017, 0.01, 25.01));
			months.add(new Month("September", 2017, 17.88 + 5.23 + 65.99 + 7.03 + 9.05 + 13.20 + 5.49 + 14.28 + 6.60, 25.01));
			months.add(new Month("October", 2017, 8.76 + 52.01 + 9.86 + 1.5 + 32.99 + 8.79));
			months.add(new Month("November", 2017, 52 + 12.74 + 46.19));
			months.add(new Month("December", 2017, 1.10 + 14.29 + 2.00 + 52));
			months.add(new Month("January", 2018, 54 + 15.39 + 7.90 + 18.43 + 3.58 + 21.79 + 7.69 + 11.54));
			months.add(new Month("February", 2018, 5.05 + 10.96 + 54 + 10.43 + 45.09 + 14.85 + 18.68, 75 + 25 + 95 + 100.01));
			months.add(new Month("March", 2018, 1.09 + 5.93 + 10.95 + 66 + 10.93 + 7.70 + 6.81 + 15.39));
			months.add(new Month("April", 2018, 4.35 + 14.29 + 8.69));
			months.add(new Month("May", 2018, 15.39 + 11.89 + 12.93 + 10.85));
			months.add(new Month("June", 2018, 19.62 + 43.99 + 22.73 + 6.59 + 7.02 + 8.76));
			months.add(new Month("July", 2018, 12.09));
			months.add(new Month("August", 2018, 8.79 + 12.65 + 1.60 + 28.35 + 6.60 + 50, 240.01));
			months.add(new Month("September", 2018, 5.34 + 17.71 + 8.79 + 6.12 + 1 + 15.49));
			months.add(new Month("October", 2018, 3.30 + 2.05 + 5.27 + 15 + 4.35 + 11.84 + 5.92));
			months.add(new Month("November", 2018, 36 + 12.09 + 6.04 + 2 + 8.27 + 5.49 + 9.24 + 10.85 + 11 + 8.79 + 5.99 + 3.2, 140.03));
			
			return months.toArray(new Month[months.size()]);
		}
	    
	    static Month[] months = createObjects();
		
		//returns the total spending of all the months thus far
		public static double getTotalSpending() {
			
			double totalSpending = 0;
			for(Month m : months) {
				totalSpending += m.getSpending();
			}
			
			return Double.parseDouble(df.format(totalSpending));
			
		}
		
		//returns the total earning of all the months thus far
		public static double getTotalEarning() {
			
			double totalEarning = 0;
			for(Month m : months) {
				totalEarning += m.getEarning();
			}
			
			return Double.parseDouble(df.format(totalEarning));
			
		}
		
		//returns the average spending per month
		public static String getAverageSpending() {
			
			double avg = getTotalSpending() / months.length;
			return df.format(avg);
			
		}
		
		//returns the average earning per month
		public static String getAverageEarning() {
			
			double avg = getTotalEarning() / months.length;
			return df.format(avg);
			
		}
		
		//returns the average saving per month
		public static String getAverageSaving() {
			
			double average = (getTotalEarning() - getTotalSpending()) / getTotalEarning();
			return (df.format(average) + "%").substring(1);
			
			
		}
		
		//returns the three month saving requirement
		public static double getThreeMonthRequirement() {
			
			double threeMonth = Double.parseDouble(getAverageSpending()) * 3;
			return Double.parseDouble(df.format(threeMonth));
			
		}
		
		//returns the change in account balance for this month
		public static String getChangeInAccount(int index) {
			
			Month lastMonth = months[index];
			if(lastMonth.getEarning() >= lastMonth.getSpending()) {
				return "+$" + df.format((lastMonth.getEarning() - lastMonth.getSpending()));
			} else {
				return "-$" + df.format(Math.abs((lastMonth.getEarning() - lastMonth.getSpending())));
			}
			
		}

}