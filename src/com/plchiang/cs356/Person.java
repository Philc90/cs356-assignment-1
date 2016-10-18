package com.plchiang.cs356;

import java.util.ArrayList;

public abstract class Person {
//	submits answers to the iVote system
	abstract void submitAnswer(ArrayList<Answer> answers, IVoteService iVoteService);
//	each person has unique ID
	abstract String identifier();
}
