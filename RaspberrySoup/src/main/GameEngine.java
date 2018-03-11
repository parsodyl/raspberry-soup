package main;

import input.GiveAnswerInput;
import input.StopSpeakInput;
import input.StartGameInput;
import input.TimeoutInput;
import logic.QuestionsList;
import persistence.QuestionsReader;
import state.StateMachine;

public class GameEngine {
	
	private GameEngine() {}
	
	public static void init(String fileName) {
		QuestionsList questionList = QuestionsReader.loadQuestionsList(fileName);
		StateMachine.loadQuestionList(questionList);
	}
	
	public static void onGameStarted() {
		StateMachine.manageInput(new StartGameInput());
	}
	
	public static void onTimeoutExpired() {
		StateMachine.manageInput(new TimeoutInput());
	}
	
	public static void onAudioStopped() {
		StateMachine.manageInput(new StopSpeakInput());
	}
	
	public static void onAnswerGiven(int answerKey) {
		StateMachine.manageInput(new GiveAnswerInput(answerKey));
	}
}

