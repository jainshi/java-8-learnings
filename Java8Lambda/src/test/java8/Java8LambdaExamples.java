package test.java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java8LambdaExamples {

	public static void main(String[] args) {
		List<Person> persons = createPersonList();
		
		printPersons(persons, (Person p) -> p.getGender() == Person.Gender.MALE
				&& p.getAge() >= 18 && p.getAge() <= 45);
		
		System.out.println("\nAscending sort (by first name)");
		Collections.sort(persons, (Person p1, Person p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		printPersons(persons, (Person p) -> 1==1);
		
		System.out.println("\nDescending sort (by first name)");
		
		Collections.sort(persons, (Person p1, Person p2) -> p2.getFirstName().compareTo(p1.getFirstName()));
		printPersons(persons, (Person p) -> 1==1);
		
		System.out.println("\nDescending sort (by date of birth)");
		
		Collections.sort(persons, (Person p1, Person p2) -> p2.getBirthDate().compareTo(p1.getBirthDate()));
		printPersons(persons, (Person p) -> 1==1);
		
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	private static List<Person> createPersonList() {
		List<Person> persons = new ArrayList();

		persons.add(new Person("Shishir", "Jain", Person.Gender.MALE, 35, LocalDate
				.of(1978, 12, 25), new PhoneNumber(9860024501L)));

		persons.add(new Person("Anuja", "Jain", Person.Gender.FEMALE, 34, LocalDate
				.of(1979, 12, 3), new PhoneNumber(8237837954L)));

		persons.add(new Person("Kashvi", "Jain", Person.Gender.FEMALE, 5,
				LocalDate.of(2008, 7, 29), new PhoneNumber(9860024503L)));

		persons.add(new Person("Milind", "Nirve", Person.Gender.MALE, 37, LocalDate
				.of(1977, 6, 25), new PhoneNumber(9860024501L)));

		return persons;
	}
}

interface CheckPerson {
	boolean test(Person p);
}

class Person {
	enum Gender {
		MALE, FEMALE;
	}

	private String firstName;
	private String lastName;
	private int age;
	private LocalDate birthDate;
	private PhoneNumber phoneNumber;
	private Gender gender;

	public Person() {

	}

	public Person(String firstName, String lastName, Gender gender, int age,
			LocalDate birthDate, PhoneNumber phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void printPerson() {
		System.out.println(firstName + " " + lastName + " " + "is a " + gender
				+ " having date of birth is " + birthDate);
	}
}

class PhoneNumber {
	private long number;

	public PhoneNumber() {

	}

	public PhoneNumber(long number) {
		setNumber(number);
	}

	public void call() {

	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
}