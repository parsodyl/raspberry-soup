package logic;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class QuestionsList {
	
	List<SingleAnswerQuestion> _singleAnswerQuestionList;

	public QuestionsList() {
		_singleAnswerQuestionList = new Vector<SingleAnswerQuestion>();
	}
	
	public SingleAnswerQuestion drawQuestion() {
		SingleAnswerQuestion result = null;
		int listSize = _singleAnswerQuestionList.size();
		int index = drawIndex(listSize)-1;
		result = _singleAnswerQuestionList.get(index);
		return result;
	}
	
	public void addQuestion(SingleAnswerQuestion q) {
		_singleAnswerQuestionList.add(q);
	}
	
	public void removeQuestion(Question q) {
		_singleAnswerQuestionList.remove(q);
	}
	
	public int size() {
		return _singleAnswerQuestionList.size();
	}
	
	public List<Question> filterByAnswer(Vegetable answer) {
		return this.filterQuestionListByAnswer(answer);
	}
	
	private List<Question> filterQuestionListByAnswer(Vegetable answer) {
		List<Question> resultList = new Vector<Question>();
		for(SingleAnswerQuestion question : _singleAnswerQuestionList) {
			if(question.getAnswer().equals(answer)) {
				resultList.add(question);
			}
		}
		return resultList;
	}
	
	private static int drawIndex(int size) {
		Random randomer = new Random();
		int modNNumber = randomer.nextInt(100*size) % size;
		return modNNumber + 1;
	}

}
