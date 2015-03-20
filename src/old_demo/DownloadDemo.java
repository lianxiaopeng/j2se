package old_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class DownloadDemo {
	
	private String fileName;
	private InputStream inputStream;
	
	 /*@Action(value="exportExcel",results={@Result(params = {  
             "contentType", "application/vnd.ms-excel;charset=gbk",  
             "inputName", "inputStream",  
             "contentDisposition", "attachment;filename=${DownloadChineseFileName}",  
             "bufferSize", "4096"},type = "stream") })*/
     public void exportExcel(){
		 try{
	        	String path = null;// ServletActionContext.getServletContext().getRealPath("/download");
	        	
	        	String filePath = path +File.separator+ "宿舍楼信息.xls";
	        	
	             OutputStream out = new FileOutputStream(filePath);
	             //ex.exportExcel(headers, dataset, out);
	             out.close();
	            
	             System.out.println("excel导出成功！");
	             
	             inputStream = new FileInputStream(filePath);
	             fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
	             
	         } catch (FileNotFoundException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         } catch (IOException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
		 
		 
		 
	 }
	 
	 public String getDownloadChineseFileName()
     {
      String downloadChineseFileName = fileName;

      try
      {
       downloadChineseFileName = new String(downloadChineseFileName
         .getBytes(), "ISO8859-1");
      }
      catch (UnsupportedEncodingException e)
      {
       e.printStackTrace();
      }

      return downloadChineseFileName;
     }

}
