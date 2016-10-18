package com.plchiang.cs356;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IVoteServiceSingleChoice implements IVoteService{
	private Question question;
	private HashMap<String, Answer> submissions;
	private HashMap<String, Integer> results;
	
	public IVoteServiceSingleChoice() {
		question = null;
		submissions = new HashMap<>();
		results = new HashMap<>();
	}
	
	public IVoteServiceSingleChoice(Question question) {
		this.question = question;
		submissions = new HashMap<>();
		results = new HashMap<>();
	}
	
	@Override
	public void receiveAnswer(ArrayList<Answer> answers, String identifier) {
		HashSet<Answer> selectedOptions = new HashSet<>();
//		if the user has already submitted, then only the last submission counts
		if(submissions.get(identifier) != null) {
			submissions.remove(identifier);
		}
		
//		System.out.println("put " + answers.get(answers.size()-1));
//		record answer for person
		if(!answers.isEmpty()) {
			submissions.put(identifier, answers.get(answers.size()-1));
		}
		
	}
	
	@Override
	public void displayResults() {
		Iterator<String> keyIter = submissions.keySet().iterator();
		results.clear();
//		total up votes for each answer
		while(keyIter.hasNext()) {
			String key = submissions.get(keyIter.next()).toString();
			if(!results.containsKey(key)) {
				results.put(key, 1);
			}
			else {
				results.put(key, results.get(key) + 1);
			}
		}
//		add counts for options that no user picked
		ArrayList<Answer> possibilities = question.answerList();
		for(int i = 0; i < possibilities.size(); i++) {
			Answer possibility = possibilities.get(i);
			if(!results.containsKey(possibility.toString())) {
				results.put(possibility.toString(), 0);
			}
		}
//		print results
		keyIter = results.keySet().iterator();
		System.out.println("Results for \"" + question + "\": ");
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			System.out.print(key + ": ");
			System.out.println(results.get(key));
		}
	}
}
