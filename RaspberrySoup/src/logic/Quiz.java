package logic;

public class Quiz {
	
	private Question _question;

	private Quiz(Question question) {
		_question = question;
	}

	public static Quiz makeQuizFromQuestion(SingleAnswerQuestion question) {
		return new Quiz(question);
	}
	
	public int getQuestionAudioId() {
		return _question.getAudioId();
	}

	public String getQuestionText() {
		return _question.getQuestionText().toString();
	}
	
	public boolean isRight(Vegetable vegetable) {
		return _question.getAnswer().equals(vegetable);
	}
	
	public Question getQuestion() {
		return _question;
	}

	public Vegetable getAnswer() {
		return _question.getAnswer();
	}

}
