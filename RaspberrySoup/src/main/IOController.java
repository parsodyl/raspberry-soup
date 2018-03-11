package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import audio.AudioController;
import audio.AudioEvent;
import audio.AudioListener;
import timeout.TimeoutController;
import timeout.TimeoutEvent;
import timeout.TimeoutListener;
import touch.TouchController;
import touch.TouchEvent;
import touch.TouchListener;

public class IOController implements TouchListener, AudioListener, TimeoutListener, ActionListener {

	private TouchController _touchController;
	private AudioController _audioController;
	private TimeoutController _timeoutController;
	
	private static IOController instance = null;	
	
	public static IOController getInstance() {
		if(instance == null) {
			instance = new IOController();
		}
		return instance;
	}

	private IOController() {
		_touchController = new TouchController();
		_touchController.addTouchListener(this);
		_audioController = new AudioController();
		_audioController.addAudioListener(this);
		_timeoutController = new TimeoutController();
		_timeoutController.addTimeoutListener(this);
	}
	
	public void playAudioInBackground(File audioFile) {
		if(audioFile == null) {
			System.out.println("File not found!");
		}
		_audioController.playAudio(audioFile);
	}
	
	public void launchTimeout(int sec) {
		_timeoutController.startTimeout(sec);
	}
	
	public void enableTouch() {
		_touchController.enableTouchDispatcher();
	}
	
	public void disableTouch() {
		_touchController.disableTouchDispatcher();
	}

	@Override
	public synchronized void onTouch(TouchEvent touchEvent) {
		_touchController.disableTouchDispatcher();
		_timeoutController.stopTimeout();
		int key = (Integer) touchEvent.getSource();
		GameEngine.onAnswerGiven(key);
	}
	
	@Override
	public synchronized void onAudioStopped(AudioEvent audioEvent) {
		_audioController.disableAudioDispatcher();
		GameEngine.onAudioStopped();
		_audioController.enableAudioDispatcher();
	}

	@Override
	public synchronized void onAudioStarted(AudioEvent audioEvent) {
		_audioController.disableAudioDispatcher();
		this.disableTouch();
		_audioController.enableAudioDispatcher();
	}

	@Override
	public synchronized void onTimeoutCatched(TimeoutEvent timeoutEvent) {
		GameEngine.onTimeoutExpired();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameEngine.onGameStarted();
	}
	
}
