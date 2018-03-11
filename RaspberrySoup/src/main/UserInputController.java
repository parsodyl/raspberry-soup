package main;

public class UserInputController {
	
	private UserInputController() {}
	
	public static void enableTouch() {
		IOController.getInstance().enableTouch();
	}
	
	public static void disableTouch() {
		IOController.getInstance().disableTouch();
	}
}
