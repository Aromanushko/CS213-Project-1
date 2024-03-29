package albummanager;
import java.util.Calendar;
/**
 * 
 * @author Robert Reid
 * Date object class
 */
public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	public static final int QUADRENNIAL = 4;
	public static final int CENTENNIAL = 10;
	public static final int QUARTERCENTENNIAL = 400;
	public static final int THE_EIGHTYS = 1980;
	
	/**
	 * Date constructor class that takes a string date of format "mm/dd/yyyy" and create a date object
	 * @param date string to be parsed and date object to be created
	 */
	public Date(String date) {
		String[] arr = (date.split("/"));
		this.month = Integer.parseInt(arr[0]);
		this.day = Integer.parseInt(arr[1]);
		this.year = Integer.parseInt(arr[2]);
	}
	
	/**
	 * Date constructor with no arguments will create date corresponding to today's date
	 */
	public Date() {
		this.day = Calendar.getInstance().getTime().getDay();
		this.month = Calendar.getInstance().getTime().getMonth();
		this.year = Calendar.getInstance().getTime().getYear();
		
	}
	
	/**
	 * method for checking if date is valid, no dates past 1980 and correct days per month
	 * @return true if the date is valid, false if not
	 */
	public boolean isValid() {
		//NEEDS TO BE FINISHED
		return false;	
	}
	
	/**
	 * Helper method for returning the year of the date object
	 * @return year of the date object
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Helper method for returning the month of the date object
	 * @return month of the date object
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Helper method for returning the day of the date object
	 * @return day of the date object
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * method for comparing dates, assumed both dates are valid
	 * @return returns 1 if the argument date comes BEFORE this date, -1 if after this date
	 */
	@Override
	public int compareTo(Date date) {
		if(date instanceof Date) {
			return -1;
		}
		if(date.getYear() < year) {
			return 1;
		}else if(date.getYear() > year) {
			return -1;
		}else {
			//This is the case if years are equal
			if(date.getMonth() < month) {
				return 1;
			}else if(date.getMonth() > month) {
				return -1;
			}else {
				//This is the case if the months are equal
				if(date.getDay() < day) {
					return 1;
				}else if(date.getDay() > day) {
					return -1;
				}else {
					return 1;
					//This means it we dont care if they switch spots.
				}
				
			}
			
		}
		
	}
	
	
}
