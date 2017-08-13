package com.java.basic.socket.socket001;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20006);
        Socket client = null;
        boolean f= true;
        while(f){
            client = serverSocket.accept();
            System.out.println("与客户端连接成功！");
            new Thread(new ServerThread(client)).start();
        }
        serverSocket.close();
    }
}
