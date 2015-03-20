package old_demo;

import java.util.Date;

public class StringDemo {

	public static void main(String[] args) {
		
		System.out.println(Long.MAX_VALUE);
		Long long1 = Long.MAX_VALUE;
		
		//测试数据类型的范围
		System.out.println(Integer.valueOf(Integer.MAX_VALUE).toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		Date date = new Date(Long.MAX_VALUE);
		System.out.println(new Date());
		System.out.println(date);
		test01();
		
		test02();
		
		/*
		 * 编写一个方法，输出在一个字符串中，指定字符串出现的次数
		 * 
		 * */
		String str = "helo world world;";
		String toStrFind = "1wor";
		int count1 = 0;
		int index = -1;
		while((index=str.indexOf(toStrFind))!=-1){
			
			count1++;
			str = str.substring(index+toStrFind.length());
		}
		System.out.println(count1);
	}
	public static void test02() {
		/*
		 * 编写一个方法，输出在一个字符串中，指定字符串出现的次数
		 * 
		 * */
		
		String str = "helo world world;";
		String replace = "1wor";
		if(str.contains(replace)){
			if(replace.equals("")){
				System.out.println("0");
			}else{
				String[] strArray = str.split(replace);
				System.out.println(strArray.length-1);
			}
			
		
		}else{
			System.out.println(0);
		}
	}
	/*
	 * 编写一个程序，输出一个字符串中的大写英文字母数，小写英文字母数以及非英文字母数
	 * 
	 * */
	public static void test01() {
		String str = "sf32FSALKFL838zx@f38klKKa";
		char[] chars = str.toCharArray();
	
		int notLetter = 0,upperLetter = 0,lowerLetter = 0;
		for (int i = 0; i < chars.length; i++) {
			if(!Character.isLetter(chars[i])){
				notLetter++;
			}else if(Character.isUpperCase(chars[i])){
				
				upperLetter++;
			}else{
				lowerLetter++;
			}
		}
		
		System.out.println("大写英文字母数："+upperLetter);
		System.out.println("小写英文字母数："+lowerLetter);
		System.out.println("非英文字母数："+notLetter);
	}
}
