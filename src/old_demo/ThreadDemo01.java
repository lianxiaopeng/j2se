package old_demo;

public class ThreadDemo01  implements Runnable{

	private Timer timer = new Timer();
	
	
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		int i = 0;
		try{
			i++;
			Thread.sleep(5000);
			System.out.println(i);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		timer.add(Thread.currentThread().getName());
		
		

	}
	public void houmen(){
		timer.houmen();
	}
	
	public static void main(String[] args) {
		
		ThreadDemo01 t1 = new ThreadDemo01();
		Thread t2 = new Thread(t1);
		Thread t3 = new Thread(t1);
		
		
		
		t2.start();
		t3.start();
	//	t3.interrupt();
	//	t1.houmen();
		
		
	}
	
	
	
	

}
class Timer{
	
	private  static int num = 0;
	
	public  synchronized void add(String name){
		
		num ++;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "这是第" + num + "访问");
		
	}
	public void houmen(){
		num ++ ;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(  "这是第" + num + "访问");
	}
	
}
