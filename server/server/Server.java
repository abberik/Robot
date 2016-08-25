package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private ServerSocket server_socket;
	private int port = 1337; //1337 H4x0r xDxDxD
	
	public Server() {
	
		try {
			server_socket = new ServerSocket(1337);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
	
}
