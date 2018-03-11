package state;

import input.StopSpeakInput;
import input.Input;
import main.GraphicController;
import main.IOController;
import main.WaitingController;

public class AskingState implements State {

	@Override
	public void elaborate(Input event, StateMachine fsm) {
		if(event instanceof StopSpeakInput) {
			// elaboration
			// [nothing]
			// change state
			State nextState = new WaitingAnswerState();
			fsm.setCurrentState(nextState);
			// outputs
			this.enableTouch();
			String text = "In attesa di una risposta... (Hai 10 secondi per rispondere).";
			this.writeMessage(text, false);
			this.waitTenSeconds();
		}
	}
	
	// output controller
	
	private void writeMessage(String text, boolean clear) {
		GraphicController.writeMessage(text, clear);
	}
	
	private void waitTenSeconds() {
		WaitingController.waitTenSeconds();
	}
	
	private void enableTouch() {
		IOController.getInstance().enableTouch();
	}
}
