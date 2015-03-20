package bishi;


public class Test3 {

	private Test3() {
		// TODO Auto-generated constructor stub
	}

	
	
	private static Test3 instance = null;

	public static synchronized Test3 getInstance() {
		if(instance == null) {
			instance = new Test3();
		}
		return instance;
	}
	public void print(){
		System.out.println("hello ");
	}
	
	public static void main(String[] args) {
		
		
		Test3 test3 = Test3.getInstance();
		test3.print();
		
		
	}
	
	
}
