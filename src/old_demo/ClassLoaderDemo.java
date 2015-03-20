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
/*主要可以扩展的方法有：
findClass          定义查找Class的方式
defineClass       将类文件字节码加载为jvm中的class
findResource    定义查找资源的方式

如果嫌麻烦的话，我们可以直接使用或继承已有的ClassLoader实现，比如
    java.net.URLClassLoader
    java.security.SecureClassLoader
    java.rmi.server.RMIClassLoader
    sun.applet.AppletClassLoader
 * 
 * 调试：-verbose:class 查看classLoad的过程
 * 
 * 实际应用：servlet的动态加载 
 * */
public class ClassLoaderDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
		System.out.println("main 方法");
		/*ClassLoader cl = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name)   throws ClassNotFoundException {
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					//该变类加载路径
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

		//读取class位置，由于不是很明白URL格式，这里多了几个步骤
		URL[] urls = {new File("d:/ddd").toURL()};
		URL[] urls1 = {new File("d:/ddd").toURL()};
		//创建URLClassLoader，传个URL地址，然后装载器会去扫描传入的地址
		URLClassLoader cl = new URLClassLoader(urls);
		URLClassLoader cl1 = new URLClassLoader(urls1);
		
		//加载到内存中
		Class clazz = cl.loadClass("old_demo.Son");
		//打印加载类名 ，和下面的对比
		System.out.println(clazz.getName());
		//实例化
		Object o = clazz.newInstance();
		//造型
		Parent oo =(Parent)o;
		
		Class clazz1 = cl1.loadClass("old_demo.Son");
		//类名和上面一模一样
		System.out.println(clazz1.getName());
		Object o1 = clazz1.newInstance();
		//调用实例对象方法
		oo.getName();
		//不同ClassLoader装载相同Class，JVM生成的类是不同的。   
		System.out.println(clazz == clazz1);//false
	
		
	
	}
	
	/*http://www.cnblogs.com/mailingfeng/archive/2012/07/02/2573419.html
	 * 那就是利用面向对象的基本特性之一的多形性。我们把我们动态载入的Class的实例造型成它的一个system classloader所能识别的父类就行了！
这是为什么呢？我们还是要再来分析一次。当我们用我们自己的classloader来动态载入这我们只要把这个Class的时候，发现它有一个父类Class，
在载入它之前JVM先会载入这个父类Class，这个父类Class是system classloader所能识别的，根据委托机制，它将由system classloader载入，
然后我们的classloader再载入这个Class，创建一个实例，造型为这个父类Class，注意了，
造型成这个父类 Class的时候（也就是上溯）是面向对象的java语言所允许的并且JVM也支持的，JVM就使用system classloader再次载入这个父类Class，
然后将此实例造型为这个父类Class。大家可以从这个过程发现这个父类Class都是由 system classloader载入的，也就是同一个class loader载入的同一个Class，
所以造型的时候不会出现任何异常。而根据多形性，调用这个父类的方法时，真正执行的是这个Class（非父类 Class）的覆盖了父类方法的方法。
这些方法中也可以引用system classloader不能识别的Class，因为根据全盘负责原则，
只要载入这个Class的classloader即我们自己定义的 classloader能够定位和载入这些Class就行了。
 
 这样我们就可以事先定义好一组接口或者基类并放入CLASSPATH中，然后在执行的时候动态的载入实现或者继承了这些接口或基类的子类。
还不明白吗？让我们来想一想Servlet吧，web application server能够载入任何继承了Servlet的Class并正确的执行它们，不管它实际的Class是什么，
就是都把它们实例化成为一个Servlet Class，然后执行Servlet的init，doPost，doGet和destroy等方法的,而不管这个Servlet是从web- inf/lib和web-inf/classes下由system classloader的子classloader(即定制的classloader)动态载入。
说了这么多希望大家都明白了。在applet,ejb等容器中,都是采用了这种机制.
	 * */
	
	

}
