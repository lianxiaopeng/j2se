package old_demo;

public class LockDemo01 implements Runnable{
	
	public static void main(String[] args) {
		
		LockDemo01 lockDemo01 = new LockDemo01();
		LockDemo01 lockDemo02 = new LockDemo01();
		lockDemo01.flag = true;
		lockDemo02.flag = false;
		Thread t1  = new Thread(lockDemo01);
		Thread t2  = new Thread(lockDemo02);
		t1.start();
		t2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}

	
	private static Object o1 = new Object();
	private static Object o2 = new Object();
	public   boolean flag ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(flag==true){
			
			synchronized(o1){
				System.out.println("o1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("o11");
				}
				
			}
			System.out.println("1");
			
		}
		if(flag==false){
			
			synchronized(o2){
				System.out.println("o2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("o22");
				}
				
			}
			System.out.println("2");
		}
		
	}

}
