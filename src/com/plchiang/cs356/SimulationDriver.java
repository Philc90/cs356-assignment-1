package com.plchiang.cs356;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SimulationDriver {

	public static void main(String[] args) {
		demo();
//		ArrayList<Answer> options = new ArrayList<>();
//		Answer a = new TextAnswer("A. Los Angeles");
//		Answer b = new TextAnswer("B. Boise");
//		Answer c = new TextAnswer("C. New York City");
//		Answer d = new TextAnswer("D. Austin");
//		Answer e = new TextAnswer("E. None of the above");
//		options.add(a);
//		options.add(b);
//		options.add(c);
//		options.add(d);
//		options.add(e);
//		
//		Question mcQuestion = new Question("Which of these cities "
//				+ "are state capitals? Select all answers that apply.", options);
//		
//		IVoteService iVoteService = new IVoteServiceMultipleChoice(mcQuestion);
		
//		Student student1 = new Student("001111");
//		ArrayList<Answer> answers = new ArrayList<>();
//		answers.add(a);
//		answers.add(b);
//		answers.add(e);
//		answers.add(a);
//		student1.submitAnswer(answers, iVoteService);
//
//		iVoteService.displayResults();
//		System.out.println("student1 changed their mind.");
//		answers.clear();
//		answers.add(a);
//		answers.add(c);
//		student1.submitAnswer(answers, iVoteService);
//		answers.clear();
//		iVoteService.displayResults();
//		
//		Answer one = new TextAnswer("1. True");
//		Answer two = new TextAnswer("2. False");
//		options.clear();
//		options.add(one);
//		options.add(two);
//		Question scQuestion = new Question("Houston is the capital of "
//				+ "Texas.", options);
//		iVoteService = new IVoteServiceSingleChoice(mcQuestion);
//		Student student2 = new Student("002222");
//		answers.clear();
//		answers.add(one);
//		student2.submitAnswer(answers, iVoteService);
//		iVoteService.displayResults();
//		System.out.println("student2 changed mind.");	
//		answers.clear();
//		answers.add(two);
//		student2.submitAnswer(answers, iVoteService);
//		iVoteService.displayResults();
		
		
	}
	
//	returns a HashSet of random students with random student IDs
	static HashSet<Student> randStudentList(int number) {
		HashSet<Student> randStudents = new HashSet<>();
		for(int i=0; i<number; i++) {
	//		ASCII: '0' -> '9' = 48 -> 57
			String studentID = "";
			for(int j = 0; j<6; j++) {
				studentID += (char)randNum(48,57);
			}
			if(!randStudents.contains(studentID)) {
				randStudents.add(new Student(studentID));
			}
			else {
//				want a unique student, so try again
				i--;
			}
		}
		return randStudents;
	}
	
//	returns a random integer in range [min, max]
	static int randNum(int min, int max) {
		return (int) (Math.random() * ((max-min) + 1) + min);
	}
	
	static void submitRandAnswers(Question question, ArrayList<Student> students, 
			IVoteService iVoteService) {
		ArrayList<Answer> possibilities = question.answerList();
		ArrayList<Answer> chosen = new ArrayList<>();
		for(int i = 0; i<students.size(); i++) {
			int numChosen = randNum(1, possibilities.size());
//			System.out.println("numchosen " + numChosen);
			for(int j = 0; j<numChosen; j++) {
				chosen.add(possibilities.get(randNum(0,possibilities.size()-1)));
			}
//			System.out.println("chosen: " + chosen);
			students.get(i).submitAnswer(chosen, iVoteService);
			chosen.clear();
		}
	}
	
	static void demo() {
		int numStudents = 30;
		HashSet<Student> students = randStudentList(numStudents);
		System.out.println("Testing Multiple Choice Question with " + 
				numStudents + " students.");
		ArrayList<Answer> options = new ArrayList<>();
		Answer a = new TextAnswer("A. Los Angeles");
		Answer b = new TextAnswer("B. Boise");
		Answer c = new TextAnswer("C. New York City");
		Answer d = new TextAnswer("D. Austin");
		Answer e = new TextAnswer("E. None of the above");
		options.add(a);
		options.add(b);
		options.add(c);
		options.add(d);
		options.add(e);
		
		Question mcQuestion = new Question("Which of these cities "
				+ "are state capitals? Select all answers that apply.", options);
		
		IVoteService iVoteService = new IVoteServiceMultipleChoice(mcQuestion);
		submitRandAnswers(mcQuestion, new ArrayList<Student>(students), iVoteService);
		iVoteService.displayResults();
		
		System.out.println("\nTesting Single Choice Question with " + 
				numStudents + " students.");
		Answer one = new TextAnswer("1. True");
		Answer two = new TextAnswer("2. False");
		options.clear();
		options.add(one);
		options.add(two);
		Question scQuestion = new Question("Houston is the capital of "
				+ "Texas.", options);
		iVoteService = new IVoteServiceSingleChoice(scQuestion);
		students = randStudentList(numStudents);
		submitRandAnswers(scQuestion, new ArrayList<Student>(students), iVoteService);
		iVoteService.displayResults();
		
		iVoteService = new IVoteServiceSingleChoice(scQuestion);
		Student student = new Student("001111");
		System.out.println("\nTest student " + student.toString() 
			+ " resubmitting their answer: ");
		ArrayList<Answer> studentAnswer = new ArrayList<>();
		studentAnswer.add(new TextAnswer("1. True"));
		student.submitAnswer(studentAnswer, iVoteService);
		iVoteService.displayResults();
		System.out.println("Student " + student.toString() + " changed their mind.");
		studentAnswer.clear();
		studentAnswer.add(new TextAnswer("2. False"));
		student.submitAnswer(studentAnswer, iVoteService);
		iVoteService.displayResults();
	}
}
