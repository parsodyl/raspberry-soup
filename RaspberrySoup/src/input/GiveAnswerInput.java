package input;

public class GiveAnswerInput implements Input {

	private int _keyAnswer = 0;
	
	public GiveAnswerInput(int keyAnswer) {
		_keyAnswer = keyAnswer;
	}

	public int getKeyAnswer() {
		return _keyAnswer;
	}
	
}
