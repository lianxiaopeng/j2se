package bishi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Test5 {

	public Test5() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		/*Map<String, String> map = new HashMap<String, String>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("four", "4");
		map.put("five", "5");
		map.put("six", "6");
	
		for(String value:map.keySet()){
			System.out.println(map.get(value));
		}*/
		

		
		HashSet<String> set = new HashSet<String>();
		set.add("val1");
		set.add("val2");
		set.add("val3");
		for(String string : set){
			System.out.println(string);
			if (string.equals("val2")) {
				set.add("new");
				
				System.out.println("found");
				
			}
		}
		System.out.println(set);
		
	}
	
	

}
