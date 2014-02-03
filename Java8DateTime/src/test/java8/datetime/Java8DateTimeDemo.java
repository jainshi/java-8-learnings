package test.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Java8DateTimeDemo {

	
	public static void main(String[] args) {
		System.out.println("Date Time demo...");
		dateTimeDemo();
		
		/*System.out.println();
		System.out.println("LocalDate demo..");
		demoLocalDate2();*/
		
	}
	
	private static void dateTimeDemo() {
		System.out.println(String.format("%-30s : ", "The date now") + LocalDate.now());
		System.out.println(String.format("%-30s : %-11s", "The time now", " ") + LocalTime.now());
		System.out.println(String.format("%-30s : ", "The date and time now") + LocalDateTime.now());
		System.out.println(String.format("%-30s : ", "The zoned date time now") + ZonedDateTime.now());
	}
	
	private static void dateTimeDemo2() {
		System.out.println("The date now - " + LocalDate.now());
		System.out.println("The time now - " + LocalTime.now());
		System.out.println("The date and time now - " + LocalDateTime.now());
		System.out.println("The zoned date time now - " + ZonedDateTime.now());
	}
	
	private static void demoLocalDate() {
		LocalDate then = LocalDate.of(1978, 12, 25);
		LocalDate now = LocalDate.now();
		LocalDate aLeapYearDate = LocalDate.of(2012, 7, 29);
		
		System.out.println(String.format("%-70s : ", "My birth date") + then);
		System.out.println(String.format("%-70s : ", "Was my birth day a leap year ? ") + then.isLeapYear());
		System.out.println(String.format("%-70s : ", "is aLeapYearDate after my date of birth ? ") + aLeapYearDate.isAfter(then));
		System.out.println(String.format("%-70s : ", "is aLeapYearDate really a leap year ? ") + aLeapYearDate.isLeapYear());
		System.out.println(String.format("%-70s : ", "is now before aLeapYearDate ? ") + now.isBefore(aLeapYearDate));
		System.out.println(String.format("%-70s : ", "Do you think year 1900 was a leap year ? Lets check") + LocalDate.of(1900, 12, 1).isLeapYear());
		System.out.println(String.format("%-70s : ", "No of days in Feb 2000") + LocalDate.of(2000, Month.FEBRUARY, 1).lengthOfMonth());
		
		System.out.println(String.format("%-70s : ", "Date after 3 months") + now.plusMonths(3));
		System.out.println(String.format("%-70s : ", "Date after 2 months but 3 days less") + now.plusMonths(2).minusDays(3));
		System.out.println(String.format("%-70s : ", "Date same as today but in the month of December of the same year") + now.withMonth(Month.DECEMBER.getValue()));
		
		
	}
	
	private static void demoLocalDate2() {
		//LocalDate.of(year, month, day)
		LocalDate then = LocalDate.of(1978, 12, 25); // notice month starts from 1, so December means 12, not 11
		LocalDate now = LocalDate.now(); // the date as of now
		LocalDate aLeapYearDate = LocalDate.of(2012, 7, 29); // 2012 is a leap year
		
		System.out.println("My birth date : " + then);
		System.out.println("Was my birth day a leap year ? " + then.isLeapYear());
		System.out.println("Is aLeapYearDate after my date of birth ? " + aLeapYearDate.isAfter(then));
		System.out.println("Is aLeapYearDate really a leap year ? " + aLeapYearDate.isLeapYear());
		System.out.println("Is now before aLeapYearDate ? " + now.isBefore(aLeapYearDate));
		System.out.println("Do you think year 1900 was a leap year ? Lets check : " + LocalDate.of(1900, 12, 1).isLeapYear());
		System.out.println("No of days in Feb 2000 : " + LocalDate.of(2000, Month.FEBRUARY, 1).lengthOfMonth());
		
		System.out.println("Date after 3 months : " + now.plusMonths(3));
		System.out.println("Date after 2 months but 3 days less : " + now.plusMonths(2).minusDays(3));
		System.out.println("Date same as today but in the month of December of the same year : " + now.withMonth(Month.DECEMBER.getValue()));
		
		
	}
	
	private static void demoPeriod() {
		/*LocalDate aDate = Instant.of(2015, 3, 1);
		Duration duration = Duration.of(12, ChronoUnit.MONTHS);*/
		LocalDate birthDate = LocalDate.of(1978,  12, 25);
		LocalDate today = LocalDate.now();
		
		Period p = Period.between(birthDate, today);
		System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + " months, and " + p.getDays() + " days old, as of today.");
		
		long p2 = ChronoUnit.DAYS.between(birthDate, today);
		System.out.println("Total days : " + p2);
		
		p2 = ChronoUnit.MONTHS.between(birthDate, today);
		System.out.println("Total months : " + p2);
		
		p2 = ChronoUnit.WEEKS.between(birthDate, today);
		System.out.println("Total weeks : " + p2);
	}
}
