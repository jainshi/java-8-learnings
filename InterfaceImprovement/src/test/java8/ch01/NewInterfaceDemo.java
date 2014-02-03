package test.java8.ch01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NewInterfaceDemo {

	public static void main(String[] args) {
		Person p1 = new PersonImpl("Shishir", "Jain", LocalDate.of(1978, 12, 25));
		Person p2 = new PersonImpl("Sachin", "Surve", LocalDate.of(1981, 1, 8));
		Person p3 = new PersonImpl("Kashvi", "Jain", LocalDate.of(2008, 7, 29));
		Person p4 = new PersonImpl("Milind", "Nirve", LocalDate.of(1976, 10, 16));
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);

		Collections.sort(persons, Person.naturalOrderComparator());
		printPersons(persons);
	}
	
	private static void printPersons(Collection<Person> persons) {
		persons.forEach(p -> System.out.println(p.printName()));
	}
}
