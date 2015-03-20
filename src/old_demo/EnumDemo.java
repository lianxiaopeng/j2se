package old_demo;

public class EnumDemo {

	
	public enum SS{red};
	
	public enum MyColor{red ,greed,white};
	public static void main(String[] args) {
		MyColor my = MyColor.red;
		switch(my){
		case red:
			System.out.println("red");
			break;
		case greed:
			System.out.println("greed");
			break;
		case white:
			System.out.println("white");
			break;
		}
		
	}
}
