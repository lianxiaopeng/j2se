package old_demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	//匹配电子邮箱
	public static void matchEmail(String mail){
		
		String reg = "\\w+([_\\-\\.]\\w+)*@\\w+([_\\-\\.]\\w+)*[a-zA-Z]{2,5}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(mail);
		System.out.println(m.matches());
		
	}
	
	public static void main(String[] args) {
		matchEmail("123456@jb51.net");
		matchEmail("web.blue@jb51.net");
		matchEmail("web_blue@jb51.net");
		matchEmail("web-blue@jb51.net");
		System.out.println("abc".matches("..."));
		System.out.println("abc".matches("[a-z]{3}"));
		Pattern p = Pattern.compile("[a-z]{3}");
	    Matcher m = p.matcher("aaa");
	    System.out.println(m.matches());
		/*
		 *  "*":0或多个
		 *  "+":1或多个
		 *  "?":0或1
		 *  ".":代表一个字符
		 *  "[]":代表范围
		 * */
	    System.out.println("11".matches("\\d+"));
	    System.out.println("1".matches("\\d*"));
	    System.out.println("".matches("\\d*"));
		System.out.println("11".matches("\\d?"));
		System.out.println("".matches("\\d?"));
		System.out.println("1".matches("\\d?"));
		System.out.println("1".matches("[0-9]?"));
		System.out.println("1111".matches("[0-9]{1,3}"));
		System.out.println("192.168.1.101".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		
		/*
		 * 范围
		 * */
		
		System.out.println("a".matches("[abc]"));
		System.out.println("a".matches("[^abc]"));
		System.out.println("a".matches("[a-z]"));
		System.out.println("A".matches("[a-zA-Z]"));
		System.out.println("A".matches("[a-z[A-Z]]"));
		System.out.println("a".matches("[a-z&&[abc]]"));
		System.out.println(" a".matches(" [a-z&&[abc]]"));
		
		/*
		 *  s w d
		 * */
		
		System.out.println(" \n\t\r".matches("\\s{4}"));
		System.out.println(" \n\t".matches("\\S+"));
		System.out.println("user_name1".matches("\\w+"));
		System.out.println("user_name1".matches("\\W+"));
		System.out.println("\\".matches("\\\\"));
		
		
	}
}
