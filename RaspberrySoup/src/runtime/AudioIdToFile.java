package runtime;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class AudioIdToFile {
	
	private final static String audioFolderPath = System.getProperty("user.dir")
											+ System.getProperty("file.separator")
											+ "audioFiles";
	private static Map<Integer,File> fileMap = new HashMap<Integer,File>();
	
	private static void cacheFileMap(int id) {
		String idstr = "" + id + ".au";
		File path = new File(audioFolderPath);
		File[] contents = path.listFiles();
		for(File f : contents) {
			if(f.getName().equals(idstr))
				fileMap.put(id, f);
		}
	}
	
	public static File getAudioFileById(Integer id) {
		File result = null;
		if(fileMap.containsKey(id))
			return fileMap.get(id);
		else {
			cacheFileMap(id);
			result = fileMap.get(id);
		}
		return result;
	}

}
