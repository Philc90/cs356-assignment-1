package com.plchiang.cs356;

import java.util.ArrayList;

public class Student extends Person{
	String studentID;
	
	public Student(String studentID) {
		this.studentID = studentID;
	}

//	Submit a list of answers to the iVote system
	@Override
	public void submitAnswer(ArrayList<Answer> answers, IVoteService iVoteService) {
		iVoteService.receiveAnswer(answers, studentID);
	}
	
//	each Student should have a unique student ID
	@Override
	public String identifier() {
		return studentID;
	}
	
	@Override
	public String toString() {
		return studentID;
	}
	
	@Override
	public boolean equals(Object other) {
		return other.toString().equals(studentID);
	}
}
