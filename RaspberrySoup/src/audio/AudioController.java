package audio;

import java.awt.HeadlessException;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class AudioController {

	private Clip _clip;
	private AudioEventDispatcher _dispatcher;

	public AudioController() {
		try {
			_clip = AudioSystem.getClip();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		_dispatcher = new AudioEventDispatcher();
		this.enableAudioDispatcher();
	}
	
	public void addAudioListener(AudioListener audioListener) {
		_dispatcher.addOnlyOneAudioListener(audioListener);
	}
	
	public void enableAudioDispatcher() {
		_clip.addLineListener(_dispatcher);
	}
	
	public void disableAudioDispatcher() {
		_clip.removeLineListener(_dispatcher);
	}

	public void playAudio(File soundFile) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			_clip.open(audioIn);
			_clip.start();
		} catch (Exception e) {
			System.out.println("playAudio() problems:");
			e.printStackTrace();
		}
	}
	
}
