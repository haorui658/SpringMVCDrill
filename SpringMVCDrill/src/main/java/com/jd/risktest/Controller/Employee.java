package com.jd.risktest.Controller;

/**
 * @author cdhaorui
 *
 */
public class Employee {

	public Employee() {

	}

	public Employee(String id, String name, String ln,String gender) {
		Id = id;
		Name = name;
		lastName=ln ;
		Gender = gender;
	}

	private String Id;
	private String Name;
	private String lastName;
	private String Gender;
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

}
