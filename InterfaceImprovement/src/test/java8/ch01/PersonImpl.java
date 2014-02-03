package test.java8.ch01;

import java.time.LocalDate;

public class PersonImpl implements Person {

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	public PersonImpl(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	@Override
	public String printName() {
		return getLastName() + " " + getFirstName();
	}
}
