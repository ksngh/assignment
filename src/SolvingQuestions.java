import java.io.IOException;

import org.json.simple.parser.ParseException;

import question.QuestionUtil;
import question.Solving;

public class SolvingQuestions {


	public static void main(String[] args) throws IOException, ParseException {

		QuestionUtil questionUtil = new QuestionUtil();

		Solving solvingquestion = new Solving(questionUtil);
		solvingquestion.solvingQuestion();

	}
}