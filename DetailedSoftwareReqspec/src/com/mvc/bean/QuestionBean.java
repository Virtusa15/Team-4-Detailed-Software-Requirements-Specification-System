package com.mvc.bean;

import javax.print.attribute.standard.DateTimeAtCreation;

public class QuestionBean {
	private String empid;
	private String Design;
	private String question;
	private String answer;
	private DateTimeAtCreation createdat;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getDesign() {
		return Design;
	}
	public void setDesign(String design) {
		Design = design;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public DateTimeAtCreation getCreatedat() {
		return createdat;
	}
	public void setCreatedat(DateTimeAtCreation createdat) {
		this.createdat = createdat;
	}
	
	

}
