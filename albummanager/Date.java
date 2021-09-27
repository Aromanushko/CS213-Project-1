package albummanager;
import java.util.Calendar;
/**
 * 
 * @author Robert Reid, Anthony Romanushko
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
	public static final int Jan = 1;
	public static final int Feb = 2;
	public static final int Mar = 3;
	public static final int Apr = 4;
	public static final int May = 5;
	public static final int Jun = 6;
	public static final int Jul = 7;
	public static final int Aug = 8;
	public static final int Sep = 9;
	public static final int Oct = 10;
	public static final int Nov = 11;
	public static final int Dec = 12;
	
	/**
	 * Test bed main for Date class to test the isValid() method
	 * @param args
	 */
	public static void main(String args[]) {

		boolean expectedResult = true;
		Date d = new Date("6/4/2011");
		if(d.isValid() == expectedResult) {
			System.out.println(d.toString() + " is Valid Date");
		}

	}
	
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
		this.day = Calendar.getInstance().DAY_OF_MONTH;
		this.month = Calendar.getInstance().MONTH + 1;
		this.year = Calendar.getInstance().YEAR;
		
	}
	
	/**
	 * method for checking if date is valid, no dates past 1980 and correct days per month
	 * @return true if the date is valid, false if not
	 */
	public boolean isValid() {
		//Check if the year is a leap year
		//Check the easy invalid dates, year < 1980; year > currentYear; day > 31; month > 12
		if(year < THE_EIGHTYS || year > Calendar.getInstance().YEAR || day > 31 || day < 1|| month > 12 || month < 1) {
			return false;
		}else{
			if(day == 31) {
				if(month == Jan || month == Mar || month == May || month == Jul || month == Aug || month == Oct 
						|| month == Dec) {
					return true;
				}else {
					return false;
				}
			}else
			if(day == 30) {
				if(month != Feb) {
					return true;
				}else {
					return false;
				}
			}else
			if(day == 29) {
				if(month != Feb || leapYear(year)) {
					return true;
				}else {
					return false;
				}
			}else{
				//If the day is <29 we know were good for all months
				return true;
			}
		}
	}
	
	/**
	 * 
	 * @param year integer year
	 * @return if the year is a leap year
	 */
	private boolean leapYear(int year){
	if(year % QUADRENNIAL == 0)
    {
        if( year % CENTENNIAL == 0)
        {
            if (year % QUARTERCENTENNIAL == 0) {
                return true;
            }else {
                return false;
            }
        }else{
            return true;
        	}
    	}else{
        	return false;
    	}
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
	
	/**
	 * 
	 * @param date
	 * @return string representation of the date
	 */
	@Override
	public String toString() {
		return month + "/" + day +"/" + year;
	}
	
}
