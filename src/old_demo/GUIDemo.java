package old_demo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GUIDemo {
	
    public static void frameWithPanel(){
		
		Frame f = new Frame("My First Test");
		f.setLocation(0, 0);
		f.setSize( 200,200);
		f.setBackground( Color.blue);
		f.setResizable(false);
	
		Panel pan = new Panel();
		Panel pan1 = new Panel();
		pan.setBackground(Color.green);
		pan1.setBackground(Color.red);
		
	
		f.add(BorderLayout.CENTER, pan);
		f.add(BorderLayout.NORTH,pan1);
		f.add(BorderLayout.SOUTH,new Panel());
		
	
		f.setVisible( true);
	}
    
    public static void button(){
    	Frame frame = new Frame("按钮Demo");
    	frame.setSize(200, 200);
    	Button button = new Button("点击");
    	Monitor monitor = new Monitor();
    	button.addActionListener(monitor);
    	frame.add(button,BorderLayout.CENTER);
    	frame.pack();
    	frame.setVisible(true);
    	
    }
    public static void textField(){
    	Frame frame = new Frame("文本框Demo");
    	frame.setSize(200, 200);
    	TextField textField = new TextField();
    	TextFiledMonitor monitor = new TextFiledMonitor();
    	textField.addActionListener(monitor);
    	textField.setEchoChar('*');
    	frame.add(textField,BorderLayout.CENTER);
    	frame.pack();
    	
    	frame.setVisible(true);
    	
    }
	
	public static void main(String[] args) {
		//frameWithPanel();
		//textField();
		//new MyFrame().lauchFrame(); 
		new PaintFrame().lauchFrame();
		
		
		
	}

}

class Monitor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println((Button)e.getSource());
		System.out.println("试一试!");
		
	}
	
}
class TextFiledMonitor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println((TextField)e.getSource());
		System.out.println("试一试!");
		
	}
	
}
//传递对象引用  门面模式
class MyFrame extends Frame{
	
	public TextField num1 , num2 , num3 ;
	public void lauchFrame(){
		
		 num1 = new TextField();
		 num2 = new TextField();
		 num3 = new TextField();
		Label labelPlus = new Label("+");
		Button btn = new Button("=");
		setLayout(new FlowLayout());
		add(num1);
		add(labelPlus);
		add(num2);
		btn.addActionListener(new MyMonitor(this));
		add(btn);
		add(num3);
		pack();
		setVisible(true);
		
		
		
		
	}
	
}
class MyMonitor implements ActionListener{

	MyFrame myFrame ;
	//传递对象引用  门面模式
	public MyMonitor(MyFrame frame){
		this.myFrame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int n1  = Integer.parseInt(myFrame.num1.getText());
		int n2 = Integer.parseInt(myFrame.num2.getText());
		myFrame.num3.setText("" + ( n1 + n2 ));
		
	}
	
	
}

/*
 * 鼠标点击显示圆点
 * */

class PaintFrame extends Frame{

	private List<Point> points;
	
	public void lauchFrame(){
		setBounds(0,0, 400, 400);
		points = new ArrayList<Point>();
		//添加鼠标点击事件
		addMouseListener(new Monitor());
		
		setVisible(true);
		
		
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
        Color c = g.getColor();
        g.setColor(Color.red);
        for(Point p : points){
        	
        	g.fillOval(p.x, p.y, 10, 10);
        }
        
        
        g.setColor(c);
        
        
	
	}
	private class Monitor extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			points.add(new Point(e.getX(),e.getY()));
			repaint();
		}
	}
	
}

