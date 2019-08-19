package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {



    public static void main(String[] args) {

        int port = 8000;
        double aNumber = Double.NaN;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream  (socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());



            while (true) {

                System.out.println("Venter på client");

                aNumber = in.readDouble();
                if(aNumber == 0.0) { break; }
                System.out.println("nummer fra client = " + aNumber);

                aNumber = aNumber * aNumber * Math.PI;

                System.out.println("Sender areal til client = " + aNumber);
                out.writeDouble(aNumber);

                System.out.println("Resultatet blev sendt");
            }


        } catch (IOException e) {
            System.out.println("Serveren oplevede en fejl");
            e.printStackTrace();
        }


    }



}
