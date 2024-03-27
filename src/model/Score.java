package model;

public class Score {
	
	private int correctAnswer;
	private int wrongAnswer;
	
	public Score() {
		reset();
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public int getWrongAnswer() {
		return wrongAnswer;
	}
	
	public void increaseCorrectAnswer() {
		correctAnswer++;
	}
	
	public void increaseWrongAnswer() {
		wrongAnswer++;
	}
	
	public void reset() {
		correctAnswer = 0;
		wrongAnswer = 0;
	}
}
