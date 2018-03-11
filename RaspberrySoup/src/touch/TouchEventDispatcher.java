package touch;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import runtime.KeyToVegMap;

public class TouchEventDispatcher implements KeyEventDispatcher {
	
	private TouchListener _touchListener;
		
	public TouchEventDispatcher() {
		super();
	}

	public void addOnlyOneTouchListener(TouchListener touchListener) {
		_touchListener = touchListener;
	}

	public boolean isAdmittedKey(int k) {
		return KeyToVegMap.isAdmittedKey(k);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getID() == KeyEvent.KEY_PRESSED) {
			int k = event.getKeyCode();
			if(isAdmittedKey(k)) {
				fireTouchEvent(k);
			}
		}
		return true;
	}
	
	public void fireTouchEvent(int key){
	      TouchEvent touchEvent = new TouchEvent(key);
	      _touchListener.onTouch(touchEvent);
	}

}
