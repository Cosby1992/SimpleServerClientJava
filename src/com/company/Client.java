package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        int port = 8000;
        double aNumber = 0.0;


        try {

            Socket socket = new Socket("localhost", port);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scan = new Scanner(System.in);

            while (true){

                System.out.println("Indtast en radius (double)...");
                aNumber = scan.nextDouble();


                out.writeDouble(aNumber);
                if(aNumber == 0.0) { break; }

                System.out.println(in.readDouble());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
