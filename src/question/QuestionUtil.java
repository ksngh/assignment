package question;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuestionUtil {

	public JSONArray extractQuestions() throws IOException, ParseException {
		// JSON 파싱하기
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader("./src/contents/questions.json");
		Object jsonObj = parser.parse(reader);
		JSONArray jsonArray = (JSONArray) jsonObj;
		return jsonArray;
	}

}
