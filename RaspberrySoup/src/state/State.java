package state;

import input.Input;

public interface State {
	public void elaborate(Input event, StateMachine fsm);
}