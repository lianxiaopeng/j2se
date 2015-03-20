package bishi;

import java.util.Date;


public class Info {

	
	private String username;
	private String lastTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public Info(String username, String lastTime) {
		super();
		this.username = username;
		this.lastTime = lastTime;
	}
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
