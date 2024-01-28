package model;

public class Score {
	
	//singleton
	private static final Score instance = new Score();
	
	private int correctAnswer;
	private int wrongAnswer;
	
	private Score() {
		correctAnswer = 0;
		wrongAnswer = 0;
	}
	
	public static Score getInstance() {
		return instance;
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
