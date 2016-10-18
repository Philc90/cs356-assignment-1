/* iVoteService - interface
 * iVoteService behaves differently depending on multiple choice or single choice,
 * so it is defined as an interface, and IVoteServiceMultipleChoice and IVoteServiceSingleChoice
 * implement it in different ways.
 */

package com.plchiang.cs356;

import java.util.ArrayList;

public interface IVoteService {
//	receives answer from person identified by identifier
	public void receiveAnswer(ArrayList<Answer> answers, String identifier);
//	displays results
	public void displayResults();
}
