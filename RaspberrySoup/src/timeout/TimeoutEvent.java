package timeout;

import java.util.EventObject;

public class TimeoutEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public TimeoutEvent(Object src) {
		super(src);
	}

}
