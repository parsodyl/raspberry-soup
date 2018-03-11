package state;

import input.Input;
import input.StartGameInput;
import main.GraphicController;
import main.SpeakerController;
import main.UserInputController;

public class IdleState implements State {

	@Override
	public void elaborate(Input event, StateMachine fsm) {
		if(event instanceof StartGameInput) {
			// elaboration
			this.initGame();
			fsm.initGameContext();
			// change state
			State nextState = new IntroducingState();
			fsm.setCurrentState(nextState);
			// outputs
			this.speakIntro();
			String text = "Inizio di una nuova partita";
			this.writeMessage(text, true);
			this.disableStartButton();
			this.disableTouch();
		}
	}
	
	// output controller
	
	private void initGame() {
		GraphicController.initGame();
	}
	
	private void speakIntro() {
		SpeakerController.speakIntro();
	}
	
	private void writeMessage(String text, boolean clear) {
		GraphicController.writeMessage(text, clear);
	}
	
	private void disableStartButton() {
		GraphicController.disableStartButton();
	}
	
	private void disableTouch() {
		UserInputController.disableTouch();
	}

}
