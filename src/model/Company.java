package model;

public class Company {
	
	String company_name;
	String password;
	public Company(String company_name, String password) {
		this.company_name = company_name;
		this.password = password;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
