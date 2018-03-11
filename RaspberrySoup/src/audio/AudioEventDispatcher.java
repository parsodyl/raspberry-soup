package audio;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class AudioEventDispatcher implements LineListener {
	
	private final int START = LineEvent.Type.START.hashCode();
	private final int STOP = LineEvent.Type.STOP.hashCode();
	
	private AudioListener _audioListener;
	
	public AudioEventDispatcher() {
		super();
	}

	public void addOnlyOneAudioListener(AudioListener audioListener) {
		_audioListener = audioListener;
	}
	
	@Override
	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.STOP) {
			event.getLine().close();
			fireAudioEvent(this.STOP);
		}
		if (event.getType() == LineEvent.Type.START) {
			fireAudioEvent(this.START);
		}
		
	}
	
	public void fireAudioEvent(int audioTypeEvent){
	      AudioEvent audioEvent = new AudioEvent(audioTypeEvent);
	      if(audioTypeEvent == this.STOP) {
	    	  _audioListener.onAudioStopped(audioEvent);
	      } else if(audioTypeEvent == this.START) {
	    	  _audioListener.onAudioStarted(audioEvent);
	      }

	}

}
