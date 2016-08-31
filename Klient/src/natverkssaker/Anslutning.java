package natverkssaker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Anslutning {

	private String adress;
	private int port;
	private Socket socket;
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	private Protokol protokol; 
	private String cfglocation = "res/protokol.cfg";
	
	public Anslutning(String adress, int port) {
		
		this.adress = adress;
		this.port = port;
		this.protokol = new Protokol(cfglocation);
		open();
	}
	
	private void open(){
		
		try {
			
			socket = new Socket(adress, port);
			outStream = new ObjectOutputStream(socket.getOutputStream());
			inStream = new ObjectInputStream(socket.getInputStream());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send(Message message){
		
		/*
		 * Skickar ett meddelande över nätverket.
		 */
		
		try {
			outStream.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectOutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(ObjectOutputStream outStream) {
		this.outStream = outStream;
	}

	public ObjectInputStream getInStream() {
		return inStream;
	}

	public void setInStream(ObjectInputStream inStream) {
		this.inStream = inStream;
	}

	public Protokol getProtokol() {
		return protokol;
	}

	public void setProtokol(Protokol protokol) {
		this.protokol = protokol;
	}

	public String getCfglocation() {
		return cfglocation;
	}

	public void setCfglocation(String cfglocation) {
		this.cfglocation = cfglocation;
	}
	
	
	
}
