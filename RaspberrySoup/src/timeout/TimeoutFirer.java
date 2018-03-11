package timeout;

public class TimeoutFirer extends Thread {
	
	private int seconds = 0;
	private TimeoutListener listener;
	
	private static TimeoutFirer instance = null;
	private static TimeoutListener stol = null;
	
	private TimeoutFirer() {}
	
	private void setTime(int seconds) {
		this.seconds = seconds;
	}
	
	private void setListener(TimeoutListener tol) {
		listener = tol;
	}
	
	@Override
	public void run() {
		try{ 
			sleep(1000*this.seconds);
		} catch (InterruptedException e) {
			return;
		}
		TimeoutEvent e = new TimeoutEvent(this);
		if(listener != null) {
			listener.onTimeoutCatched(e);
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
