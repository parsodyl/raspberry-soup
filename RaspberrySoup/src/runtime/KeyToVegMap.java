package runtime;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import logic.Vegetable;

public class KeyToVegMap {
	
	private static Map<Integer,Vegetable> vegMap = new HashMap<Integer,Vegetable>();
	private static boolean initYet = false;
	
	private static void makeQuestionMap() {
		/*vegMap.put(KeyEvent.VK_SPACE, new Vegetable("Peperone"));
		vegMap.put(KeyEvent.VK_CONTROL, new Vegetable("Carota"));
		vegMap.put(KeyEvent.VK_UP, new Vegetable("Scalogno"));
		vegMap.put(KeyEvent.VK_DOWN, new Vegetable("Finocchio"));
		vegMap.put(KeyEvent.VK_LEFT, new Vegetable("Broccolo"));
		vegMap.put(KeyEvent.VK_RIGHT, new Vegetable("Patata"));*/
	}
	
	public static void setSpace(String veg) {
		vegMap.put(KeyEvent.VK_SPACE, new Vegetable(veg));
	}
	
	public static void setControl(String veg) {
		vegMap.put(KeyEvent.VK_CONTROL, new Vegetable(veg));
	}
	
	public static void setUp(String veg) {
		vegMap.put(KeyEvent.VK_UP, new Vegetable(veg));
	}
	
	public static void setDown(String veg) {
		vegMap.put(KeyEvent.VK_DOWN, new Vegetable(veg));
	}
	
	public static void setLeft(String veg) {
		vegMap.put(KeyEvent.VK_LEFT, new Vegetable(veg));
	}
	
	public static void setRight(String veg) {
		vegMap.put(KeyEvent.VK_RIGHT, new Vegetable(veg));
	}
	
	
	public static void init(){
		if(!initYet) {
			makeQuestionMap();
			initYet = true;
		}
	}
	
	public static Vegetable getVegByKey(Integer k) {
		init();
		Vegetable result = null;
		if(vegMap.containsKey(k))
			return vegMap.get(k);
		return result;
	}
	
	public static boolean isAdmittedKey(int k) {
		init();
		return vegMap.containsKey(k);
	}

}
