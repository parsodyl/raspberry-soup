package persistence;

import java.io.BufferedReader;
import java.io.FileReader;

import logic.QuestionsList;
import logic.SingleAnswerQuestion;

public class QuestionsReader {

	public static QuestionsList loadQuestionsList(String fileName) {
		QuestionsList result = null;
		try {
			BufferedReader CSVFile = new BufferedReader(
					new FileReader(fileName));
			String dataRow = CSVFile.readLine(); // Read first line.
			result = new QuestionsList();
			while (dataRow != null) {
				String[] dataArray = dataRow.split(";");
				if(dataArray.length == 3) {
					SingleAnswerQuestion element = SingleAnswerQuestion
							.questionFactoryByStrings(dataArray[0], dataArray[1],
									dataArray[2]);
					result.addQuestion(element);
				}
				dataRow = CSVFile.readLine(); // Read next line of data.
			}
			CSVFile.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
}
