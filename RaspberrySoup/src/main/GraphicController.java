package main;

import java.awt.EventQueue;

import gui.GameFrame;

public class GraphicController {
	
	final private static String QUESTION_LIST_FILE_NAME = "list.txt";
	
	private static GameFrame mainFrame = new GameFrame(IOController.getInstance());
	
	private GraphicController() {}
	
	public static void writeStartMessage() {
		mainFrame.setMessageLabel("Clicca su start per una nuova partita.");
	}
	
	public static void writeMessage(String mess, boolean clearQuestion) {
		if(clearQuestion) {
			mainFrame.setQuestionPane("");
		}
		mainFrame.setMessageLabel(mess);
	}
	
	public static void writeQuestion(String mess) {
		mainFrame.setQuestionPane(mess);
	}
	
	public static void disableStartButton() {
		mainFrame.setEnableOfStartButton(false);
	}
	
	public static void enableStartButton() {
		mainFrame.setEnableOfStartButton(true);
	}
	
	public static void showMainFrame() {
		mainFrame.setVisible(true);
	}
	
	public static void initGame() {
		GameEngine.init(QUESTION_LIST_FILE_NAME);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showMainFrame();
					writeStartMessage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
