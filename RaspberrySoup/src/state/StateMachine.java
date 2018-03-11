package state;

import input.Input;
import logic.GameContext;
import logic.QuestionsList;
import logic.Vegetable;

public class StateMachine {
	
	private State _currentState;
	private GameContext _gameContext;
	
	private static StateMachine instance;
	
	public static StateMachine getInstance() {
		if(instance == null)
			instance = new StateMachine();
		return instance;
	}
	
	private StateMachine() {
		_currentState = new IdleState();
		_gameContext = new GameContext();
	}
	
	public State getCurrentState() {
		return _currentState;
	}

	public void setCurrentState(State currentState) {
		_currentState = currentState;
	}
	
	public GameContext getContext() {
		return _gameContext;
	}
	
	public void initGameContext() {
		this.getContext().initGame();
	}
	
	public int getCurrentQuestionIndex() {
		return this.getContext().getCurrentQuestionIndex();
	}
	
	public String getCurrentQuestionText() {
		return this.getContext().getCurrentQuestionText();
	}
	
	public boolean checkAnswer(Vegetable answer) {
		return this.getContext().giveAnswer(answer);
	}
	
	public boolean isGameOver() {
		return this.getContext().isLastQuestion();
	}
	
	public int getScore() {
		return this.getContext().getScore();
	}

	public static void manageInput(Input input) {
		StateMachine fsm = getInstance();
		fsm.getCurrentState().elaborate(input, fsm);
	}
	
	public static void loadQuestionList(QuestionsList questionList) {
		StateMachine fsm = getInstance();
		fsm.getContext().setQuestionList(questionList);
	}

}
