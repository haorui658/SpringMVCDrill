package com.jd.risktest.Controller;

/**
 * @author cdhaorui
 *
 */
public class Employee {

	public Employee(String id, String name, String gender) {
		Id = id;
		Name = name;
		Gender = gender;
	}
	private String Id;
	private String Name;
	private String Gender;
	
	
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
