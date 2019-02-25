package model;

public class Student {

	String email;
	String name;
	String password;
	String gender;
	String city;
	String contact;
	String education;
	String passout;

	public Student(String email, String name, String password, String gender, String city, String contact,
			String education, String passout) {

		this.email = email;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.city = city;
		this.contact = contact;
		this.education = education;
		this.passout = passout;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public String getCity() {
		return city;
	}

	public String getContact() {
		return contact;
	}

	public String getEducation() {
		return education;
	}

	public String getPassout() {
		return passout;
	}
	
	

}
