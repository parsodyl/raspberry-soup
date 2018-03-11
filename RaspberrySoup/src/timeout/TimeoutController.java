package timeout;

public class TimeoutController {
	
	public void addTimeoutListener(TimeoutListener timeoutListener) {
		TimeoutFirer.addTimeoutListener(timeoutListener);
	}
	
	public void startTimeout(int seconds) {
		TimeoutFirer.startTimeout(seconds);
	}
	
	public void stopTimeout() {
		TimeoutFirer.stopTimeout();
	}
}
