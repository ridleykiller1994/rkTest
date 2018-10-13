
package rkDayTools;


/**
 * @author	Sean Harris ridleykiller1994@gmail.com
 * @version	1.0
 * @since	1.0
 */
public class DayOfWeek {
	/**
	 * enumerates valid days of the week
	 */
	private enum DayOfWeekEnum {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
	}
	
	/**
	 * holds the day value
	 */
	private DayOfWeekEnum day;
	
	/**
	 * constructs internally with DayOfWeek
	 * @param day	the day of the week to be stored
	 */
	private DayOfWeek(DayOfWeekEnum day) {
		this.day = day;
	}
	
	/**
	 * constructs with String
	 * @param day	the String name for the day to be stored
	 */
	DayOfWeek(String day) {
		this.day = DayOfWeekEnum.valueOf(day);
	}
	
	/**
	 * constructs with int, checks for valid argument and throws relevant error
	 * @param day	the index for the day to be stored
	 * @throws IllegalArgumentException		for out of bounds index
	 */
	DayOfWeek(int day) throws IllegalArgumentException {
		if (day < 0 || 6 < day)
			throw new IllegalArgumentException("Out of bounds");
		this.day = DayOfWeekEnum.values()[day];
	}
	
	/**
	 * sets day with String
	 * @param day	the String name for the day to be stored
	 */
	public void setDay(String day) {
		this.day = DayOfWeekEnum.valueOf(day);
	}
	
	/**
	 * sets day with int, checks for valid argument and throws relevant error
	 * @param day	the index for the day to be stored
	 * @throws IllegalArgumentException		for out of bounds index
	 */
	public void setDay(int day) throws IllegalArgumentException {
		if (day < 0 || 6 < day)
			throw new IllegalArgumentException("Out of bounds");
		this.day = DayOfWeekEnum.values()[day];
	}
	
	
	/**
	 * advances by a specified value to return a new instance of Day_Sean
	 * @param n		the value to advance by
	 * @return		a new Day_SeanHarris for the requested date
	 */
	public DayOfWeek advanceDay(int n) {
		return new DayOfWeek(DayOfWeekEnum.values()[(((day.ordinal() + n) % 7) + 7) % 7]);
	}
	
	/**
	 * uses advanceDay() to return previous day
	 * @return		a new Day_SeanHarris for the previous day
	 */
	public DayOfWeek getPreviousDay() {
		return advanceDay(-1);
	}
	
	/**
	 * uses advanceDay() to return next day
	 * @return		a new Day_SeanHarris for the next day
	 */
	public DayOfWeek getNextDay() {
		return advanceDay(1);
	}
	
	/**
	 * prints the day
	 */
	public void printDay() {
		System.out.println(day);
	}
	
	/**
	 * returns a string for the current day
	 */
	@Override
	public String toString() {
		return day.toString();
	}
	
	/**
	 * test driver
	 * @param args	system arguments
	 */
	public static void main(String[] args) {
		DayOfWeek day1 = new DayOfWeek("Monday");
		DayOfWeek day2 = new DayOfWeek(4);
		
		day1.setDay(2);
		day2.setDay("Friday");
		
		day1.advanceDay(3).printDay();
		day2.advanceDay(-9).printDay();
		
		day1.getNextDay().printDay();
		day2.getPreviousDay().printDay();
		
		day1.printDay();
		day2.printDay();
		
		System.out.println(day1 + "\n" + day2);
		
	}
}
