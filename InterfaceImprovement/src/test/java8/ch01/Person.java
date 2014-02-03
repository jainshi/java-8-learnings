package test.java8.ch01;

import java.time.LocalDate;
import java.util.Comparator;

public interface Person extends Comparable<Person> {
	
	// the implementation of these properties/behaviors, each implementation
	// class has to provide
	
	String getFirstName();
	
	String getLastName();
	
	LocalDate getBirthDate();
	
	// This is the default implementation for Comparable::compareTo(Person p)
	// implementation class can also override
	public default int compareTo(Person p) {
		return getBirthDate().compareTo(p.getBirthDate());
	}

	// This is the default implementation of a method, which implementor class
	// can override
	public default String printName() {
	    return getFirstName() + " " + getLastName();
	}
	
	// This is a static method which gives a comparator to provide natural
	// ordering for Person
	public static Comparator<Person> naturalOrderComparator() {
		return new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.compareTo(p2);
			}
		};
	}
	
	public static Comparator<Person> byFirstNameComparator() {
		return new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getFirstName().compareTo(p2.getFirstName());
			}
		};
	}
	
	
}
