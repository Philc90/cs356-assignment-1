package com.plchiang.cs356;

public class TextAnswer extends Answer{
	private String answer;
	public TextAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
//	specifies how to display answer
	public void displayAnswer() {
		System.out.println(answer);
	}
	
	@Override
	public String toString() {
		return answer;
	}
}
