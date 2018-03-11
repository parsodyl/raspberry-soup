package runtime;

import java.io.File;

public class CommonMessages {
	
	private final static String commonAudioPath = System.getProperty("user.dir")
			+ System.getProperty("file.separator")
			+ "audioFiles"
			+ System.getProperty("file.separator")
			+ "common";
	
	private static File searchFileByName(String name) {
		String idstr = "" + name + ".au";
		File path = new File(commonAudioPath);
		File[] contents = path.listFiles();
		for(File f : contents) {
			if(f.getName().equals(idstr))
				return f;
		}
		return null;
	}
	
	public static File getIntroAudioFile() {
		String name = "intro";
		return searchFileByName(name);
	}
	
	public static File getOutroAudioFile() {
		String name = "outro";
		return searchFileByName(name);
	}
	
	public static File getCorrectAudioFile() {
		String name = "correct";
		return searchFileByName(name);
	}
	
	public static File getWrongAudioFile() {
		String name = "wrong";
		return searchFileByName(name);
	}
	
	public static File getTimeAudioFile() {
		String name = "time";
		return searchFileByName(name);
	}

}
