package shejimoshi;

import java.lang.reflect.Proxy;

public class Order {

	
	private String name;
	private int count;
	private double unitPrice;
	private Strategy strategy = new StrategyNormal();
	
	
	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public double getTotalPrice(){
		return strategy.calPrice(count * unitPrice);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
	@Override
	public String toString() {
		return name + "-" + getTotalPrice() ; 
	}
	
	public static void main(String[] args) {
		Order order = new Order();
		order.setName("apple");
		order.setCount(2);
		order.setUnitPrice(12.2);
		order.setStrategy(new StrategyA());
		System.out.println(order);
		
		
	}
	
	
}

 abstract class Strategy{
	public abstract double calPrice(double price) ;
}

class StrategyA extends Strategy{

	@Override
	public double calPrice(double price) {
		// TODO Auto-generated method stub
		return price * 0.8;
	}
	
}
class StrategyB extends Strategy{

	@Override
	public double calPrice(double price) {
		// TODO Auto-generated method stub
		return price - 10;
	}
	
}
class StrategyNormal extends Strategy{

	@Override
	public double calPrice(double price) {
		// TODO Auto-generated method stub
		return price;
	}
	
}
