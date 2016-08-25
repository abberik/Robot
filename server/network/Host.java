package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Host implements Runnable {

	private ServerSocket serv_socket;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	
	public Host(ServerSocket serv_socket) {
	
		this.serv_socket = serv_socket;

	}
	
	@Override
	public void run() {
		
		while(true){
			boolean disconnected = false;
			
			try {
				
				socket = serv_socket.accept();
				
				inputStream = new ObjectInputStream(socket.getInputStream());
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("connected");
			
			while(!disconnected){
				
				
				
			}
			
		}
		
	}

	
	
}
