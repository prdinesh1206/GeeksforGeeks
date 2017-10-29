import java.util.HashMap;
import java.util.Map;

public class Atlassian {

	Map<Integer, Integer> hashmap;
	public Atlassian(){
		hashmap = new HashMap<Integer, Integer>();
		hashmap.put(1, 2);
		Integer i = hashmap.get(2);
		System.out.println((i));
	}
	
	static {
		new Atlassian();
	}
	public static void main(String[] args){
		
	}
}
