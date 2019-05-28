package com.project.entity;

public class Question {
	private int question_id;
	private String question_name;
	private String question_content;
	private String question_evaluation;
	private String question_result;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getQuestion_evaluation() {
		return question_evaluation;
	}
	public void setQuestion_evaluation(String question_evaluation) {
		this.question_evaluation = question_evaluation;
	}
	public String getQuestion_result() {
		return question_result;
	}
	public void setQuestion_result(String question_result) {
		this.question_result = question_result;
	}
	
}
