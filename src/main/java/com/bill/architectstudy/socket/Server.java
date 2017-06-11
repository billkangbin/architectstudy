package com.bill.architectstudy.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public final static int PORT = 8765;
	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("server start");
			//阻塞
			Socket socket = server.accept();
			//新建一个线程执行客户端任务
			new Thread(new ServerHandler(socket)).start();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server!=null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			server = null;
		}
	}
}
