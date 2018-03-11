package main;

public class WaitingController {
	
	public static void waitTenSeconds() {
		IOController.getInstance().launchTimeout(10);
	}
}
