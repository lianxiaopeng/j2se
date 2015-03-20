package shejimoshi;

import java.util.ArrayList;
import java.util.List;

public class Child implements Runnable{
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String[] strArray = {"java2se.Father","java2se.Mother","java2se.Mother"};
		Child child = new Child();

		
		for(String str : strArray){
			Class clazz = Class.forName(str);			
			child.addListener((Listener)clazz.newInstance());
		}
		new Thread(child).start();
		
	}

	private List<Listener>  listenersList = new ArrayList<Listener>();
	
	public void addListener(Listener l ){
		listenersList.add(l);
	}
	public void wakeUp(){
		//Í¨Öª¼àÌýÕß
		for(Listener l : listenersList){
			l.actionToWakenUp(new WakenUpEvent(System.currentTimeMillis(), this, "bed"));
		}
		
		
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wakeUp();
		
		
	}
	
	
	
	 

}
class WakenUpEvent{
	private long time;
	private Child source;
	private String loc;
	
	public WakenUpEvent(long time, Child source, String loc) {
		super();
		this.time = time;
		this.source = source;
		this.loc = loc;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Child getSource() {
		return source;
	}
	public void setSource(Child source) {
		this.source = source;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
interface Listener{
	public void actionToWakenUp(WakenUpEvent e);
}

class Father implements Listener{

	@Override
	public void actionToWakenUp(WakenUpEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Father ");
		
	}
	
}
class Mother implements Listener{

	@Override
	public void actionToWakenUp(WakenUpEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mother ");
	}
	
}

