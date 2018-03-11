package timeout;

public class TimeoutFirer extends Thread {
	
	private int _seconds = 0;
	private TimeoutListener _listener;
	
	private static TimeoutFirer instance = null;
	private static TimeoutListener stol = null;
	
	private TimeoutFirer() {}
	
	private void setTime(int seconds) {
		_seconds = seconds;
	}
	
	private void setListener(TimeoutListener listener) {
		_listener = listener;
	}
	
	@Override
	public void run() {
		try{ 
			sleep(1000*_seconds);
		} catch (InterruptedException e) {
			return;
		}
		TimeoutEvent e = new TimeoutEvent(this);
		if(_listener != null) {
			_listener.onTimeoutCatched(e);
		}
	}
	
	public static void addTimeoutListener(TimeoutListener tol) {
		if(instance != null && instance.isAlive()) { 
			return; 
		}
		stol = tol;
	}
	
	public static void startTimeout(int sec) {
		instance = new TimeoutFirer();
		instance.setTime(sec);
		instance.setListener(stol);
		instance.start();
	}
	
	public static void stopTimeout() {
		if(instance == null) {
			return;
		}
		instance.setListener(null);
		instance.interrupt();
		instance = null;
	}
	
}
