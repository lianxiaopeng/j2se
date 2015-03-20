package old_demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharsetDemo {
  public static void main(String[] args) throws UnsupportedEncodingException {
	
	  String str = "中文";
	   long l =  str.length();
	   char c = '文';
	   char c1 = '中';
	  
			   
	   for(String str1 : Charset.availableCharsets().keySet()){
		   System.out.println(str1);
	   }

	  byte[] bbuf = str.getBytes();
	  byte[] bbuf1 = str.getBytes("utf-8");
	 
}
}
