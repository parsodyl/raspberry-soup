package state;

import input.StopSpeakInput;
import input.Input;
import main.GraphicController;
import main.SpeakerController;

public class IntroducingState implements State {

	@Override
	public void elaborate(Input event, StateMachine fsm) {
		if(event instanceof StopSpeakInput) {
			// elaboration
			int index = fsm.getCurrentQuestionIndex();
			String questionText = fsm.getCurrentQuestionText();
			// change state
			State nextState = new AskingState();
			fsm.setCurrentState(nextState);
			// outputs
			this.speakQuestion(fsm);
			this.writeMessage("Ascolta la domanda", false);
			String text = "Domanda numero " + index + ": " + questionText;
			this.writeQuestion(text);
		}
	}
	
	// output controller
	
	private void speakQuestion(StateMachine fsm) {
		SpeakerController.speakQuestion(fsm);
	}
	
	private void writeMessage(String text, boolean clear) {
		GraphicController.writeMessage(text, clear);
	}
	
	private void writeQuestion(String text) {
		GraphicController.writeQuestion(text);
	}

}
