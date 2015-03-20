package socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Arrays;

public class UDP_Server {
	
	
	//接受long类型数据
	public static void main(String[] args) throws IOException {
		//udp端口号
		DatagramSocket ds = new DatagramSocket(10025);
		byte[] bbuf = new byte[1024];
		//接受数据
		DatagramPacket p = new DatagramPacket(bbuf,0,bbuf.length);
		ds.receive(p);
		//将字节数组转成long
		System.out.println(p.getOffset());
		System.out.println(p.getLength());
		ByteArrayInputStream bis = new ByteArrayInputStream(bbuf,0,p.getLength());
		DataInputStream dis = new DataInputStream(bis);
		long l = dis.readLong();
		System.out.println(l);
		
	    
		
		
		

		
		
		
	}

}
