package state;

import input.GiveAnswerInput;
import input.Input;
import input.TimeoutInput;
import logic.Vegetable;
import main.GraphicController;
import main.SpeakerController;
import main.UserInputController;
import runtime.KeyToVegMap;

public class WaitingAnswerState implements State {

	@Override
	public void elaborate(Input event, StateMachine fsm) {
		
		if(event instanceof TimeoutInput) {
			// elaboration
			// [nothing]
			// change state
			State nextState = new ConcludingState();
			fsm.setCurrentState(nextState);
			// outputs
			this.disableTouch();
			String text = "Tempo scaduto!";
			this.writeMessage(text, false);
			this.speakTime();
		}
		
		if(event instanceof GiveAnswerInput) {
			// elaboration
			int answerKey = ((GiveAnswerInput) event).getKeyAnswer();
			Vegetable answer = getVegetableByKey(answerKey);
			boolean outcome = fsm.checkAnswer(answer);
			boolean isGameOver = fsm.isGameOver();
			// change state
			State nextState;
			if(isGameOver) {
				nextState = new ConcludingState();
			} else {
				nextState = new IntroducingState();
			}
			fsm.setCurrentState(nextState);
			// outputs
			this.disableTouch();
			if(outcome) {
				// right
				String text = answer + "? " + "Risposta Esatta!";
				this.writeMessage(text, false);
				this.speakCorrect();
			} else {
				// wrong
				String text = answer + "? " + "Risposta Sbagliata!";
				this.writeMessage(text, false);
				this.speakWrong();
			}
		}
	}
	
	// output controller
	
	private void writeMessage(String text, boolean clear) {
		GraphicController.writeMessage(text, clear);
	}
	
	private void speakTime() {
		SpeakerController.speakTimeOver();
	}
	
	private void speakCorrect() {
		SpeakerController.speakRightAnswer();
	}
	
	private void speakWrong() {
		SpeakerController.speakWrongAnswer();
	}
	
	private void disableTouch() {
		UserInputController.disableTouch();
	}
	
	// utilities
	
	private static Vegetable getVegetableByKey(int answerKey) {
		return KeyToVegMap.getVegByKey(answerKey);
	}

}
