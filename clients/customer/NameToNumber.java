package clients.customer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NameToNumber extends HashMap<String,String> { //creating a hashmap to convert names to number

	NameToNumber(){
		put("0001", "TV");
		put("0002", "Radio");
		put("0003", "Toaster");
		put("0004", "Watch");
		put("0005", "Camera");
		put("0006", "Music player");
		put("0007", "USB");
	}
	
	public String getNumberFromName(Map<String, String> map, String name) {
		for (Entry<String, String> entry : map.entrySet()) { //checks to see if any name matches the hashmap
			if (entry.getValue().equals(name))
				return entry.getKey(); //will return the key that is equivalent to the name
		}
		return null;
	}
}
