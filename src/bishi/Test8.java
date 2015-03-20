package bishi;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;










public class Test8 {
	
	
	public Test8() {
		// TODO Auto-generated constructor stub
	}
	
	public static String build(String config,Info info) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
	  
	   for (int i = 0; i < config.length(); i++) {
		  boolean sign = true;
		  if( config.charAt(i) == '$'&&config.charAt(i+1)=='{'){
			    
			 for (int j = i+1; j < config.length()&&sign; j++) {
				 
				 if(config.charAt(j)=='}'){
					 
					 String string = config.substring(i+2, j);
					String string3 = string;
					 string = "get"+Character.toUpperCase(string.charAt(0))+string.substring(1);
					 System.out.println(string);
					for(Method m : info.getClass().getMethods()){
						if (m.getName().equals(string)) {
							 String string2 = (String) m.invoke(info);
							
							
							 return config.substring(0,i) + string2 + config.substring(j+1);
						}
						
					}
										
					 sign = false;
					 
				 }
				
			}
		  }
		
	}
		return "";
	}
	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		
		Info info = new Info("习总","2013-09-04");
		
		System.out.println(build("${username}你好，你离开微博很久了，上次登录时间为${lastTime}", info));
		
		System.out.println("${username}你好，你离开微博很久了".matches("\\$\\{\\w+\\}.*"));
		
		String buildString = "${username}你好，你离开微博很久了${lastTime}hihi";
		
		Pattern pattern  = Pattern.compile("\\$\\{\\w+\\}");
		
		Matcher matcher = pattern.matcher(buildString);
		System.out.println("${username}你好，你离开微博很久了".replaceAll("\\$\\{\\w+\\}", "xx"));
		Map<String, String> map = new HashMap<String, String>();
		
		while(matcher.find()){
			System.out.println(matcher.group());
			
			String string  = matcher.group().substring(2,matcher.group().length()-1);
			String string1 = "get" + Character.toUpperCase(string.charAt(0)) + string.substring(1);
			System.out.println("get" + Character.toUpperCase(string.charAt(0)) + string.substring(1));
			for(Method value : info.getClass().getMethods()){
				if(value.getName().equals(string1)){
					System.out.println(value.invoke(info));
					map.put(matcher.group(), (String) value.invoke(info));
					
				}
			}		
		}
		System.out.println(map);
		for(String str:map.keySet()){
			
			matcher.usePattern(Pattern.compile(str));
			buildString = matcher.replaceAll(map.get(str));
		}
		System.out.println(buildString);
		
		
	
	//	System.out.println(matcher.region(start, end));
		
		//System.out.println(matcher.replaceAll(matcher.regionStart()));
		
	}

}
