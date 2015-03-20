package old_demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.URL;
import java.util.Properties;

public class IoDemo {
	
	
	
	public static void fileCopy(File src , File dest) {
		
		try{
			
			InputStream in = new FileInputStream(src);
			//�ֽ���ת�����ַ���
			InputStreamReader isr = new InputStreamReader(in);
			
			OutputStream out = new FileOutputStream(dest);
			
			OutputStreamWriter osw = new OutputStreamWriter(out);
			
			char[] cbuf = new char[in.available()];
			long  count = 0;
            while(isr.read(cbuf)!=-1){
            	osw.write(cbuf);
            	System.out.println(count++);
            }
            osw.flush();
            isr.close();
            osw.close();

		
		}catch(FileNotFoundException e ){
			System.out.println("�ļ��Ҳ���");
			System.exit(-1);
			
		}catch(IOException e){
			System.out.println("�ļ���д����");
			System.exit(-1);			
		}
		
		
		
	}

	
	/*
	 * datastream
	 * */
	public static void datastream1() throws IOException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeByte(1);
		dos.writeByte(3);
		
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		DataInputStream ds = new DataInputStream(bais);
		
		byte c = ds.readByte();
		System.out.println(c);
		
		dos.flush();
		dos.close();
	}
	public static void objectStream() throws IOException, ClassNotFoundException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		T t1 = new T();
		t1.name="hehe";
		oos.writeObject(t1);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		T t = (T)ois.readObject();
		System.out.println(t.name);
		
		
		
	}
public static void datastream2() throws IOException, ClassNotFoundException{
		
		FileOutputStream fos = new FileOutputStream("d:/e.txt");
		DataOutputStream oos = new DataOutputStream(fos);
		
		double d = 1.1234546563d;
		oos.writeDouble(d);		
		oos.writeInt(48);
		//oos.writeInt(0);
		oos.writeChar('c');
		oos.writeByte('c');
		oos.writeChars("48");
		oos.writeUTF("48");
		oos.flush();
		FileInputStream fis = new FileInputStream("d:/e.txt");
	//	ObjectInputStream ois = new ObjectInputStream(fis);
		//double d1 = ois.readDouble();
	//	System.out.println(d1);
		
	}
	

	public static void readFromClasspath(){
		
		//����װ����ȥ���� a.txt
		ClassLoader cl = IoDemo.class.getClassLoader();
		
		//�����������·��
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		//E:\remotePrint\j2se\bin
		System.out.println(System.getProperty("java.class.path"));
		
		//���ַ�ʽ���ϵͳӦ�ü�����
		
		if(cl == ClassLoader.getSystemClassLoader()){
			System.out.println("=======");
		}
		
		
		try {
		InputStream in = cl.getResourceAsStream("a.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
        
		
		
		} catch(IOException e){
			e.printStackTrace();
			
		}
		
		
	}
	/*
	 * ͨ����װ�� ��ȡ��Դ�ļ� 
	 * */
	
	public static void readProperties() throws IOException{
		ClassLoader cl = IoDemo.class.getClassLoader();
        InputStream in = cl.getResourceAsStream("db.properties");
        Properties prop = new Properties();
        prop.load(in);
       
        String password =  prop.getProperty("password");
        System.out.println(password);
		
	}
	/*
	 * ͨ����װ�� ��ȡ��Դ�ļ� λ�ã�������ͨ�ļ���������ȡ��Դ
	 * */
	
	public static void readPropertiesByFile() throws IOException{
		ClassLoader cl = IoDemo.class.getClassLoader();
        URL url = cl.getResource("db.properties");
        InputStream in = new FileInputStream(url.getPath());
        Properties prop = new Properties();
        prop.load(in);
       
        String password =  prop.getProperty("password");
        System.out.println(password);
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		

	}
	
	
	

}
class T implements Serializable{
	
	public String name;
	public double price;
}
