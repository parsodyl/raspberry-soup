package logic;

public class SingleAnswerQuestion implements Question {
	
	private MessageText _questionText;
	private Vegetable _answerVeg;
	private int _audioId;
	
	private SingleAnswerQuestion(MessageText questionText, Vegetable answerVeg, int audioId) {
		_questionText = questionText;
		_answerVeg = answerVeg;
		_audioId = audioId;
	}

	public MessageText getQuestionText() {
		return _questionText;
	}

	public Vegetable getAnswer() {
		return _answerVeg;
	}
	
	public int getAudioId() {
		return _audioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _audioId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleAnswerQuestion other = (SingleAnswerQuestion) obj;
		if (_audioId != other._audioId)
			return false;
		return true;
	}

	public static SingleAnswerQuestion questionFactoryByStrings(String textMessage, String vegAnswer, String audioId) {
		Vegetable answer = new Vegetable(vegAnswer);
		MessageText txt = new MessageText(textMessage);
		SingleAnswerQuestion resultQuestion = new SingleAnswerQuestion(txt, answer,Integer.parseInt(audioId));
		System.out.println(resultQuestion);
		return resultQuestion;
	}

	@Override
	public String toString() {
		return "SingleAnswerQuestion [questionText=" + _questionText
				+ ", answerVeg=" + _answerVeg + ", audioId=" + _audioId + "]";
	}
	
}
