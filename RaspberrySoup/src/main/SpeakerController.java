package main;

import runtime.AudioIdToFile;
import runtime.CommonMessages;
import state.StateMachine;

public class SpeakerController {
	
	private SpeakerController() {}
	
	public static void speakIntro() {
		IOController.getInstance().playAudioInBackground(CommonMessages.getIntroAudioFile());
	}
	
	public static void speakOutro() {
		IOController.getInstance().playAudioInBackground(CommonMessages.getOutroAudioFile());
	}
	
	public static void speakQuestion(StateMachine fsm) {
		int id = fsm.getContext().getCurrentQuestionAudioID();
		IOController.getInstance().playAudioInBackground(AudioIdToFile.getAudioFileById(id));
	}
	
	public static void speakRightAnswer() {
		IOController.getInstance().playAudioInBackground(CommonMessages.getCorrectAudioFile());
	}
	
	public static void speakWrongAnswer() {
		IOController.getInstance().playAudioInBackground(CommonMessages.getWrongAudioFile());
	}
	
	public static void speakTimeOver() {
		IOController.getInstance().playAudioInBackground(CommonMessages.getTimeAudioFile());
	}
}
