package bishi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test9 {

	public Test9() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		System.out.println("aaa8888c".matches(".*"));
		System.out.println("aaa8888c".matches(".*88c"));
		System.out.println("11".matches("(\\d)\\1"));
		Pattern pattern  = Pattern.compile("abc(?=d)");
		Matcher matcher = pattern.matcher("abcd");
		while (matcher.find()) {
			System.out.println(matcher.group());
			
		}
	}

}
