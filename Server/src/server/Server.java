package server;

import java.io.IOException;
import java.net.ServerSocket;

import network.Host;

public class Server {

	private ServerSocket server_socket;
	private int port = 1337; //1337 H4x0r xDxDxD
	private Host host;
	private Thread host_thread;
	
	public Server() {
	
		try {
			server_socket = new ServerSocket(1337);
			host = new Host(server_socket);
			host_thread = new Thread(host);
			host_thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
	
}
