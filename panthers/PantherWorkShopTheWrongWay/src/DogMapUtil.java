import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class DogMapUtil {
	
	
	public static Map<String, Dog> getDogsFromPropertiesFile(String propertiesFile) {
		Map<String, Dog> tempMap = new HashMap<String, Dog>();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] names = prop.getProperty("names").split(",");
		String[] breeds = prop.getProperty("breeds").split(",");
		String[] ages = prop.getProperty("ages").split(",");
		
		for (int i = 0; i < names.length ; i++){
			tempMap.put(names[i], new Dog(names[i], breeds[i], Integer.parseInt(ages[i])));
		}
		
		
		return tempMap;
	}

}
