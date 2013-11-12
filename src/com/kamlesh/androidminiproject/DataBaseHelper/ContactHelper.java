package com.kamlesh.androidminiproject.DataBaseHelper;

public class ContactHelper 
{
	private int id;
	private String name;
	private String phoneNumber;

	public ContactHelper(){}
	
	public ContactHelper(int id,String name,String ph)
	{
		this.id=id;
		this.name=name;
		this.phoneNumber=ph;
	}
	
	public ContactHelper(String name,String ph)
	{
		this.name=name;
		this.phoneNumber=ph;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
