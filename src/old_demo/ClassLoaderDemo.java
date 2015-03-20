package old_demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
//import java.nio.file.Path;

import bean.Parent;
/*��Ҫ������չ�ķ����У�
findClass          �������Class�ķ�ʽ
defineClass       �����ļ��ֽ������Ϊjvm�е�class
findResource    ���������Դ�ķ�ʽ

������鷳�Ļ������ǿ���ֱ��ʹ�û�̳����е�ClassLoaderʵ�֣�����
    java.net.URLClassLoader
    java.security.SecureClassLoader
    java.rmi.server.RMIClassLoader
    sun.applet.AppletClassLoader
 * 
 * ���ԣ�-verbose:class �鿴classLoad�Ĺ���
 * 
 * ʵ��Ӧ�ã�servlet�Ķ�̬���� 
 * */
public class ClassLoaderDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
		System.out.println("main ����");
		/*ClassLoader cl = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name)   throws ClassNotFoundException {
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					//�ñ������·��
					System.out.println(name);
					if(is==null||fileName.equals("Parent.class")){
						System.out.println(name);
						Class clazz =  super.loadClass(name);
						return clazz;
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					Class clazz = defineClass(name, b, 0,b.length);
					return clazz;
					
				}catch(IOException e){
					e.printStackTrace();
				}
				return super.loadClass(name);
			}
		};*/

		//��ȡclassλ�ã����ڲ��Ǻ�����URL��ʽ��������˼�������
		URL[] urls = {new File("d:/ddd").toURL()};
		URL[] urls1 = {new File("d:/ddd").toURL()};
		//����URLClassLoader������URL��ַ��Ȼ��װ������ȥɨ�贫��ĵ�ַ
		URLClassLoader cl = new URLClassLoader(urls);
		URLClassLoader cl1 = new URLClassLoader(urls1);
		
		//���ص��ڴ���
		Class clazz = cl.loadClass("old_demo.Son");
		//��ӡ�������� ��������ĶԱ�
		System.out.println(clazz.getName());
		//ʵ����
		Object o = clazz.newInstance();
		//����
		Parent oo =(Parent)o;
		
		Class clazz1 = cl1.loadClass("old_demo.Son");
		//����������һģһ��
		System.out.println(clazz1.getName());
		Object o1 = clazz1.newInstance();
		//����ʵ�����󷽷�
		oo.getName();
		//��ͬClassLoaderװ����ͬClass��JVM���ɵ����ǲ�ͬ�ġ�   
		System.out.println(clazz == clazz1);//false
	
		
	
	}
	
	/*http://www.cnblogs.com/mailingfeng/archive/2012/07/02/2573419.html
	 * �Ǿ��������������Ļ�������֮һ�Ķ����ԡ����ǰ����Ƕ�̬�����Class��ʵ�����ͳ�����һ��system classloader����ʶ��ĸ�������ˣ�
����Ϊʲô�أ����ǻ���Ҫ��������һ�Ρ��������������Լ���classloader����̬����������ֻҪ�����Class��ʱ�򣬷�������һ������Class��
��������֮ǰJVM�Ȼ������������Class���������Class��system classloader����ʶ��ģ�����ί�л��ƣ�������system classloader���룬
Ȼ�����ǵ�classloader���������Class������һ��ʵ��������Ϊ�������Class��ע���ˣ�
���ͳ�������� Class��ʱ��Ҳ�������ݣ�����������java����������Ĳ���JVMҲ֧�ֵģ�JVM��ʹ��system classloader�ٴ������������Class��
Ȼ�󽫴�ʵ������Ϊ�������Class����ҿ��Դ�������̷����������Class������ system classloader����ģ�Ҳ����ͬһ��class loader�����ͬһ��Class��
�������͵�ʱ�򲻻�����κ��쳣�������ݶ����ԣ������������ķ���ʱ������ִ�е������Class���Ǹ��� Class���ĸ����˸��෽���ķ�����
��Щ������Ҳ��������system classloader����ʶ���Class����Ϊ����ȫ�̸���ԭ��
ֻҪ�������Class��classloader�������Լ������ classloader�ܹ���λ��������ЩClass�����ˡ�
 
 �������ǾͿ������ȶ����һ��ӿڻ��߻��ಢ����CLASSPATH�У�Ȼ����ִ�е�ʱ��̬������ʵ�ֻ��߼̳�����Щ�ӿڻ��������ࡣ
��������������������һ��Servlet�ɣ�web application server�ܹ������κμ̳���Servlet��Class����ȷ��ִ�����ǣ�������ʵ�ʵ�Class��ʲô��
���Ƕ�������ʵ������Ϊһ��Servlet Class��Ȼ��ִ��Servlet��init��doPost��doGet��destroy�ȷ�����,���������Servlet�Ǵ�web- inf/lib��web-inf/classes����system classloader����classloader(�����Ƶ�classloader)��̬���롣
˵����ô��ϣ����Ҷ������ˡ���applet,ejb��������,���ǲ��������ֻ���.
	 * */
	
	

}
