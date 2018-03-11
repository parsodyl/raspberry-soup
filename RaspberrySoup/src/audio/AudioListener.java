package audio;

public interface AudioListener {
	public void onAudioStopped(AudioEvent audioEvent);
	public void onAudioStarted(AudioEvent audioEvent);
}
