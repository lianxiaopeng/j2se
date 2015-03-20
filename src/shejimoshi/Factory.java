package shejimoshi;

public class Factory {
	
	public static Sample creator(int choose){
		switch(choose){
		case 1 :
			
			return new SampleA();
		case 2 :
			return new SampleB();
		default :
			return null;
		
		}
				
	}
	
	public static void main(String[] args) {
		 Factory factory = new Factory();
		 Sample sample = factory.creator(1);
		 
	}

}
