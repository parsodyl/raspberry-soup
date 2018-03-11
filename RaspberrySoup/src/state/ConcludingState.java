package state;

import input.StopSpeakInput;
import input.Input;
import main.GraphicController;
import main.SpeakerController;

public class ConcludingState implements State {

	@Override
	public void elaborate(Input event, StateMachine fsm) {
		if(event instanceof StopSpeakInput) {
			/**********/
			//SAVE LOG
			/**********/
			// elaboration
			int score = fsm.getScore();
			// change state
			State nextState = new IdleState();
			fsm.setCurrentState(nextState);
			// outputs
			this.speakOutro();
			String text = "Gioco concluso: hai risposto correttamente a " 
					+ score + " domande. Clicca su start per una nuova partita.";
			this.writeMessage(text,true);
			this.enableStartButton();
		}
	}
	
	// output controller
	
	private void speakOutro() {
		SpeakerController.speakOutro();
	}
	
	private void writeMessage(String text, boolean clear) {
		GraphicController.writeMessage(text, clear);
	}
	
	private void enableStartButton() {
		GraphicController.enableStartButton();
	}

}
