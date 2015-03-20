package old_demo;

import java.io.File;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDemo {
    /*
     * 代表系统文件名，实际上，并不是指硬盘中的文件
     * */
	
	public static void main(String[] args) {
		
		File f = new File("d:"+File.separator+"AliWorkbenchData");
		if(!f.exists()){
			f.mkdir();
		}
	    tree(f,1);
	    System.out.println(isChinese("哈"));;
	    
		
	}
	
	public static void tree(File f,int level){
		
		String str ="";
		for (int i = 0; i < level; i++) {
			str += "  ";
		}
		
		File[] files = f.listFiles();
		for(File value : files){
			if(value.isDirectory()){
				
				System.out.println(str+value.getName());
				tree(value,level+1);
			}else{
				System.out.println(str+value.getName());
			}
			
		}
		
	}
	public static boolean isChinese(String str){
		
		Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
		Matcher m = p.matcher(str);
		if(m.find()){
			return true;
		}else 
			return false;
	    }

	
}
