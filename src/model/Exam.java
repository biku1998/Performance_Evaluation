package model;

public class Exam {

	String email;
	String lang;
	String grade;
	String name;

	String gender;
	String city;
	String contact;
	String education;
	String passout;

	public Exam(String email, String lang, String grade, String name, String gender, String city, String contact,
			String education, String passout) {

		this.email = email;
		this.lang = lang;
		this.grade = grade;
		this.name = name;

		this.gender = gender;
		this.city = city;
		this.contact = contact;
		this.education = education;
		this.passout = passout;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
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
