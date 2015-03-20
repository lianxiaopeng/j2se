package old_demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		Socket socket = new Socket("127.0.0.1", 5002);
       
        
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader conBr = new BufferedReader(new InputStreamReader(System.in));
        
        
        String context ;
        context = conBr.readLine();
        
        while (!context.equals("bye")){
        	//这里要刷新
        pw.println(context);
       	 pw.flush();
       	System.out.println("client :" + context);
    	System.out.println("server : " + br.readLine());
    	 context = conBr.readLine();
        }
		
		
	}

    
}
