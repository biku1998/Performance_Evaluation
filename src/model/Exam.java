package model;

public class Exam {

	String email;
	String lang;
	String grade;

	public Exam(String email, String lang, String grade) {

		this.email = email;
		this.lang = lang;
		this.grade = grade;
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

}
