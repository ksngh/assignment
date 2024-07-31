package question;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class solving_question {

	Scanner scanner;
	question question;
	ArrayList<Integer> answers = new ArrayList<>();


	// 문제 생성하기
	public question generateQuestion(int num) throws IOException, ParseException {

		// JSON 파싱하기
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader("./src/contents/questions.json");
		Object jsonObj = parser.parse(reader);
		JSONArray jsonArray = (JSONArray) jsonObj;
		JSONObject jsonObject = (JSONObject) jsonArray.get(num);

		// Question 객체 생성 및 반환
		String content = (String)jsonObject.get("question");

		String strCorrectAnswer = (String)jsonObject.get("correctAnswer");
		int correctAnswer = Integer.parseInt(strCorrectAnswer);

		String strScore = (String)jsonObject.get("score");
		int score = Integer.parseInt(strScore);

		ArrayList<String> choices = (ArrayList<String>)jsonObject.get("choices");

		question question = new question(content, num, correctAnswer,score,choices);

		return question;
	}

	public void solvingQuestion() throws IOException, ParseException {

		int totalScore = 0;

		// 문제 수 만큼 반복
		for (int i = 0; i < 4; i++) {
			question = generateQuestion(i);
			ArrayList<String> choices = question.getChoices();

			System.out.println(question.getQuestion());
			System.out.println(
				" 1) " + choices.get(0) +
				" 2) " + choices.get(1) +
				" 3) " + choices.get(2) +
				" 4) " + choices.get(3));
			System.out.println("-정답 :");

			scanner = new Scanner(System.in);
			int answer = scanner.nextInt();
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
	private int validation(question question){
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
