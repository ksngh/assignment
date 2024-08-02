package question;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Solving {

	BufferedReader bufferedReader;
	Question question;
	ArrayList<Integer> answers = new ArrayList<>();

	private final QuestionUtil questionUtil;

	public Solving(QuestionUtil questionUtil) {
		this.questionUtil = questionUtil;
	}

	// 문제 생성하기
	public Question generateQuestion(int num , JSONArray jsonArray) {

		JSONObject jsonObject = (JSONObject) jsonArray.get(num);

		// Question 객체 생성 및 반환
		String content = (String)jsonObject.get("question");

		String strCorrectAnswer = (String)jsonObject.get("correctAnswer");
		int correctAnswer = Integer.parseInt(strCorrectAnswer);

		String strScore = (String)jsonObject.get("score");
		int score = Integer.parseInt(strScore);

		ArrayList<String> choices = (ArrayList<String>)jsonObject.get("choices");

		Question question = new Question(content, num, correctAnswer,score,choices);

		return question;
	}

	public void solvingQuestion() throws IOException, ParseException {

		int totalScore = 0;

		// 문제 파싱
		JSONArray jsonArray = questionUtil.extractQuestions();

		// 문제 수 만큼 반복
		for (int i = 0; i < jsonArray.size(); i++) {
			question = generateQuestion(i,jsonArray);
			ArrayList<String> choices = question.getChoices();

			System.out.println(question.getQuestion());
			System.out.println(
				" 1) " + choices.get(0) +
				" 2) " + choices.get(1) +
				" 3) " + choices.get(2) +
				" 4) " + choices.get(3));
			System.out.println("-정답 :");

			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			int answer = Integer.parseInt(bufferedReader.readLine());

			System.out.println(answer);

			answers.add(answer);

			question.setUserAnswer(answer);

			totalScore += validation(question);

		}

		// 결과 값 프린트
		System.out.println("—----- 결과 —-------------");
		System.out.println(
			"응답한 내용 : 1번 " + answers.get(0) +
				", 2번 " + answers.get(1)+
				", 3번 " + answers.get(2)+
				", 4번 " + answers.get(3));
		System.out.println("당신 응답 합계 : " + totalScore);
		System.out.println("학점은 " + evaluation(totalScore) + "입니다.");
	}

	// 문제 채점 후 점수 반환
	private int validation(Question question){
		if(question.getUserAnswer()== question.getCorrectAnswer()){
			return question.getScore();
		}else{
			return 0;
		}
	}

	// 학점 평가
	private String evaluation(int score){
		if(score>=30){
			return "A";
		} else if (score>=20) {
			return "B";
		} else {
			return "F";
		}
	}

}
