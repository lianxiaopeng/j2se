package bishi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test4 {

	public Test4()  {
		// TODO Auto-generated constructor stub
		
    
		
	}
	public static void main(String[] args) throws IOException {
		 FileInputStream fis = new FileInputStream("d:/a.txt");

	     InputStreamReader isr  = new InputStreamReader(fis);
	     
	     BufferedReader br  = new BufferedReader(isr);         
	     String line = null;
	     
	     while((line=br.readLine())!=null){
	         System.out.println(line);
	     }
	     br.close();
	}

}
