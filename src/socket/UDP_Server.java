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
	
	
	//����long��������
	public static void main(String[] args) throws IOException {
		//udp�˿ں�
		DatagramSocket ds = new DatagramSocket(10025);
		byte[] bbuf = new byte[1024];
		//��������
		DatagramPacket p = new DatagramPacket(bbuf,0,bbuf.length);
		ds.receive(p);
		//���ֽ�����ת��long
		System.out.println(p.getOffset());
		System.out.println(p.getLength());
		ByteArrayInputStream bis = new ByteArrayInputStream(bbuf,0,p.getLength());
		DataInputStream dis = new DataInputStream(bis);
		long l = dis.readLong();
		System.out.println(l);
		
	    
		
		
		

		
		
		
	}

}
