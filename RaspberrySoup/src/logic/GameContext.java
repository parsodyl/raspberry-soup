package logic;

import util.DateUtils;

public class GameContext {
	
	private Quiz _currentQuiz;
	private int _currentQuestionIndex;
	private StringBuffer _gameLog;
	private int _score;
	private boolean _lastQuestion;
	private QuestionsList _notAnsweredYetQuestions;
	
	public void setQuestionList(QuestionsList notAnsweredYetQuestions) {
		_notAnsweredYetQuestions = notAnsweredYetQuestions;
	}
	
	public int getCurrentQuestionIndex() {
		return _currentQuestionIndex;
	}
	
	public int getScore() {
		return _score;
	}
	
	public String getCurrentQuestionText() {
		return _currentQuiz.getQuestionText();
	}
	
	public int getCurrentQuestionAudioID() {
		return _currentQuiz.getQuestionAudioId();
	}
	
	public boolean initGame() {
		if(_notAnsweredYetQuestions == null || _notAnsweredYetQuestions.size() == 0) {
			return false;
		} else {
			this.clearContex();
			this.moveToNextQuestion();
			return true;
		}
	}
	
	public boolean isLastQuestion() {
		return _lastQuestion;
	}
	
	public boolean giveAnswer(Vegetable answer) {
		if(this.checkAnswer(answer)){
			this.applyRightAnswer();
			return true;
		} else {
			this.applyWrongAnswer(answer);
			return false;
		}
	}
	
	private void clearContex() {
		_score = 0;
		_currentQuiz = null;
		_currentQuestionIndex = 0;
		_lastQuestion = false;
		_gameLog = null;
	}
	
	private void addLineToLog(Vegetable yourAnswer){
		if(_gameLog == null) {
			_gameLog = new StringBuffer();
		}
		final String nl = System.getProperty("line.separator");
		final String tab = "\t";
		_gameLog.append(DateUtils.now() + tab);
		_gameLog.append(_currentQuiz.getQuestionText() + tab);
		_gameLog.append(yourAnswer + tab);
		_gameLog.append(checkAnswer(yourAnswer) + nl);
	}
	
	private boolean checkAnswer(Vegetable yourAnswer) {
		return _currentQuiz.isRight(yourAnswer);
	}
	
	private void applyRightAnswer(){
		this.addLineToLog(_currentQuiz.getAnswer());
		this.incrementScore();
		this.removeLastQuestionAndMoveOn();
	}
	
	private void applyWrongAnswer(Vegetable answer){
		this.addLineToLog(answer);
		this.removeLastQuestionAndMoveOn();
	}
	
	private void incrementScore() {
		_score++;
	}
	
	private void removeLastQuestionAndMoveOn() {
		if(_currentQuiz != null) { // why?
			Question question = _currentQuiz.getQuestion();
			_notAnsweredYetQuestions.removeQuestion(question);
		}
		this.moveToNextQuestion();
	}
	
	private void moveToNextQuestion() {
		if(_notAnsweredYetQuestions.size() > 0) {
			_currentQuiz = this.makeNewQuiz();
			_currentQuestionIndex++;
		} else {
			_lastQuestion = true;
		}
	}
	
	private Quiz makeNewQuiz() {
		SingleAnswerQuestion nextQuestion = _notAnsweredYetQuestions.drawQuestion();
		return Quiz.makeQuizFromQuestion(nextQuestion);
	}

}
