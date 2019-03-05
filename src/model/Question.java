package model;

public class Question {

	String subject;
	String ques_id;
	String ques;
	String option1;
	String option2;
	String option3;
	String correct_ans;

	public Question(String subject, String ques_id, String ques, String option1, String option2, String option3,
			String correct_ans) {

		this.subject = subject;
		this.ques_id = ques_id;
		this.ques = ques;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.correct_ans = correct_ans;
	}

	public String getSubject() {
		return subject;
	}

	public String getQues_id() {
		return ques_id;
	}

	public String getQues() {
		return ques;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getCorrect_ans() {
		return correct_ans;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		String op = String.format("question : %s", this.getQues());
//		return op;
//	}
	

}
