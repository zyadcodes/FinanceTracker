import java.io.PrintWriter;

public class NewClass extends MonthCreator {
	
	
	public static void main(String[] args) {
		
		writeToFile();
		
	}
	
	//method that formats and writes in the file
	public static void writeToFile() {
			
		Month[] months = createObjects();
		String filename = "Zyad's Finances.txt";
		//accesses the files
		try {
			PrintWriter fw = new PrintWriter(filename);
			//formats the spacing between the month and the spending so 
			//they are all lined up
			writeHeader(fw);
			for(Month x : months) {
				printMonthName(fw, x);
				printMonthSheet(fw, x);
				printChangeInAccount(fw, x, months);
			}
			writeOtherInfo(fw);
			fw.close();
		//if something goes wrong, it will print the 
	    //error to the console
		} catch(Exception e) {
			System.out.println("Something went wrong, here's the error...\n" + e.getMessage());
		}
			
	}
	
	//writes the top header of the table
	public static void writeHeader(PrintWriter fw) {
		
		fw.write("|Month");
		for(int i = 1; i <= 31 - "Month".length(); i++) {
			fw.write(" ");
		}
		fw.write("Spending");
		for(int i = 1; i <= 31 - "Month".length(); i++) {
			fw.write(" ");
		}
		fw.write("Earning");
		for(int i = 1; i <= 20 - "Month".length(); i++) {
			fw.write(" ");
		}
		fw.write("Change in Account|\n");
	}
	
	//prints out the month name and spaces
	public static void printMonthName(PrintWriter fw, Month x) {
		fw.write("|" + x.getMonth() + " " + x.getYear() + " : ");
		for(int z = 1; z <= 20 - x.getMonth().length(); z++) {
			fw.write(" ");
		}
		for(int z = 1; z <= (10 - Double.toString(x.getSpending()).length()); z++) {
			fw.write(" ");
		}
	}
	
	//prints out the monthly spending and earning and its spaces
	public static void printMonthSheet(PrintWriter fw, Month x) { 
		fw.write("$" + x.getSpending());
		for(int z = 1; z <= 32 - Double.toString(x.getEarning()).length(); z++) {
			fw.write(" ");
		}
		fw.write("$" + x.getEarning());
	}
	
	//prints out the change in account and its spaces
	public static void printChangeInAccount(PrintWriter fw, Month x, Month[] months) {
		int theIndex = -1;
		for(int i = 0; i < months.length; i++) {
			if(months[i].getMonth().equals(x.getMonth()) && months[i].getYear() == x.getYear()) {
				theIndex = i;
			}
		}
		for(int z = 1; z <= 32 - getChangeInAccount(theIndex).length(); z++) {
			fw.write(" ");
		}
		fw.write(getChangeInAccount(theIndex) + "|");
		fw.write("\n");
	}
	
	//writes all of the other extra information
	public static void writeOtherInfo(PrintWriter fw) {
		
		String totalSpending = "Total Spending:";
		String totalEarning = "Total Earning:";
		String averageSpending = "Average Spending:";
		String averageEarning = "Average Earning:";
		String threeMonthSaving = "Three Month Saving Requirement:";
		String averageSaving = "Average Saving:";
		
		fw.write("\n" + totalSpending);
		writeSpaces(fw, totalSpending);
		fw.write("$" + getTotalSpending() + "");
		fw.write("\n" + totalEarning);
		writeSpaces(fw, totalEarning);
		fw.write("$" + getTotalEarning() + "");
		fw.write("\n" + averageSpending);
		writeSpaces(fw, averageSpending);
		fw.write("$" + getAverageSpending() + "");
		fw.write("\n" + averageSaving);
		writeSpaces(fw, averageSaving);
		fw.write(getAverageSaving() + "");
		fw.write("\n" + averageEarning);
		writeSpaces(fw, averageEarning);
		fw.write("$" + getAverageEarning() + "");
		fw.write("\n" + threeMonthSaving);
		writeSpaces(fw, threeMonthSaving);
		fw.write("$" + getThreeMonthRequirement() + "");
		
	}
	
	public static void writeSpaces(PrintWriter fw, String x) {
		for(int i = 1; i <= 40 - x.length(); i++) {
			fw.write(" ");
		}
		
	}
	
	
	
	
	

}
