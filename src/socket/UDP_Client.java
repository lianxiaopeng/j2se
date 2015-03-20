package socket;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDP_Client {

	
	//long类型转成字节数组发出去 
		public static void main(String[] args) throws IOException {
			//udp端口号
			DatagramSocket ds = new DatagramSocket(10024);
			long l = 10000l;
			//long to array
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeLong(l);
			byte[] bbuf = baos.toByteArray();
			DatagramPacket p = new DatagramPacket(bbuf, 0, bbuf.length,new InetSocketAddress("127.0.0.1",10025) );
			//发送数据包
			ds.send(p);
			dos.close();
			ds.close();
      }
}
