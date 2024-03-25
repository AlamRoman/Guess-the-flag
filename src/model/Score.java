package model;

public class Score {
	
	private int correctAnswer;
	private int wrongAnswer;
	
	public Score() {
		correctAnswer = 0;
		wrongAnswer = 0;
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
	
}
