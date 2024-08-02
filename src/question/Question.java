package question;

import java.util.ArrayList;

public class Question {
	private String question;
	private int num;
	private int userAnswer;
	private int correctAnswer;

	private ArrayList<String> choices;
	private int score;

	public int getScore() {
		return score;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public String getQuestion() {
		return question;
	}


	public int getUserAnswer() {
		return userAnswer;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Question(String question, int num, int correctAnswer,int score,ArrayList<String> choices) {
		this.question = question;
		this.num = num;
		this.correctAnswer = correctAnswer;
		this.score = score;
		this.choices = choices;
	}
}
