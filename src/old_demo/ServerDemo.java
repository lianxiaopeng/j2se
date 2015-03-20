package old_demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerDemo {

	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5002);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        BufferedReader conBr = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("client :" + br.readLine());
        String context ;
        context = conBr.readLine();
        
        while (!context.equals("bye")){
         bw.write(context);
         bw.write("\\n");
       	 bw.flush();
       	System.out.println("server :" + context);
    	System.out.println("client : " + br.readLine());
    	 context = conBr.readLine();
        }
        
		
	}
	
	
}
