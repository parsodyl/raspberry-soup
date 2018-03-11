package logic;

public class MessageText {

	private String _text;
	
	public MessageText(String text) {
		_text = text;
	}
	
	public String getText() {
		return _text;
	}

	@Override
	public String toString() {
		return this.getText();
	}

}
