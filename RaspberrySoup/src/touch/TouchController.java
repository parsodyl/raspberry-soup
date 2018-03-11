package touch;

import java.awt.KeyboardFocusManager;

public class TouchController {

	private TouchEventDispatcher _dispatcher;

	public TouchController() {
		_dispatcher = new TouchEventDispatcher();
		this.enableTouchDispatcher();
	}
	
	public void addTouchListener(TouchListener touchListener) {
		_dispatcher.addOnlyOneTouchListener(touchListener);
	}
	
	public void disableTouchDispatcher() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(_dispatcher);
	}
	
	public void enableTouchDispatcher() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(_dispatcher);
	}

}
