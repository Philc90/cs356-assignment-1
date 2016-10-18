package com.plchiang.cs356;

import java.util.ArrayList;

public class Question {
	protected String question;
	protected ArrayList<Answer> answerList;
	
	public Question() {
		question = "";
		answerList = new ArrayList<>();
	}
	
	public Question(String question, ArrayList<Answer> answerList) {
		this.question = question;
		this.answerList = new ArrayList<>();
		for(int i = 0; i<answerList.size(); i++) {
			this.answerList.add(answerList.get(i));
		}
	}
	
	public ArrayList<Answer> answerList() {
		return answerList;
	}
	
	public void setAnswers(ArrayList<Answer> answerList) {
		for(int i = 0; i<answerList.size(); i++) {
			this.answerList.add(answerList.get(i));
		}
	}
	
	public void setQuestion(String question) {
		this.question = question;	
	}
	
	public String question() {
		return question;
	}

	public void displayAnswers() {
		for(int i = 0; i<answerList.size(); i++) {
			answerList.get(i).displayAnswer();
		}
	}
	
	@Override 
	public String toString() {
		return this.question;
	}

}
