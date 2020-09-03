package com.company;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMultiThread {

    private static int port=6666;
    public static void main(String[] args) throws Exception {
        try{
            if(args.length ==1){
                port = Integer.parseInt(args[0]);
            }
            ServerSocket server=new ServerSocket(port);
            int counter=0;
            System.out.println("Server Started ....");
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server ip: " + serverIP);
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                TCPServerClientThread sct = new TCPServerClientThread(serverClient,counter); //send  the request to a separate thread
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
