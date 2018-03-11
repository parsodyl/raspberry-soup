package input;

public class GiveAnswerInput implements Input {

	private int keyAnswer = 0;
	
	public GiveAnswerInput(int keyAnswer) {
		this.keyAnswer = keyAnswer;
	}

	public int getKeyAnswer() {
		return keyAnswer;
	}
	
}
