package main;

public class WaitingController {
	
	private WaitingController() {}
	
	public static void waitTenSeconds() {
		IOController.getInstance().launchTimeout(10);
	}
}
