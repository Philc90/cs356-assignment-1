package com.plchiang.cs356;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class IVoteServiceMultipleChoice implements IVoteService{
	private Question question;
	private HashMap<String, ArrayList<Answer>> submissions;
	private HashMap<String, Integer> results;
	
	public IVoteServiceMultipleChoice() {
		question = null;
		submissions = new HashMap<>();
		results = new HashMap<>();
	}
	
	public IVoteServiceMultipleChoice(Question question) {
		this.question = question;
		submissions = new HashMap<>();
		results = new HashMap<>();
	}
	
	@Override
	public void receiveAnswer(ArrayList<Answer> answers, String identifier) {
		HashSet<Answer> selectedOptions = new HashSet<>();
		ArrayList<Answer> answersNoDuplicates = new ArrayList<>();
//		if the user has already submitted, then only the last submission counts
		if(submissions.get(identifier) != null) {
			submissions.remove(identifier);
		}
//		add counts for options that no user picked
		ArrayList<Answer> possibilities = question.answerList();
		for(int i = 0; i < possibilities.size(); i++) {
			Answer possibility = possibilities.get(i);
			if(!results.containsKey(possibility.toString())) {
				results.put(possibility.toString(), 0);
			}
		}
//		user can't choose an option more than once
		for(int i = 0; i<answers.size(); i++) {
			Answer checkMe = answers.get(i);
			if(!selectedOptions.contains(checkMe)) {
				answersNoDuplicates.add(checkMe);
				selectedOptions.add(checkMe);
			}
		}
		submissions.put(identifier, answersNoDuplicates);
	}
	
	@Override
	public void displayResults() {
		Iterator<String> keyIter = submissions.keySet().iterator();
		results.clear();
//		total up the votes for each answer
		while(keyIter.hasNext()) {
			ArrayList<Answer> answers = submissions.get(keyIter.next());
			for(int i = 0; i<answers.size(); i++) {
				String key = answers.get(i).toString();
				if(!results.containsKey(key)) {
					results.put(key, 1);
				}
				else {
					results.put(key, results.get(key) + 1);
				}
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
