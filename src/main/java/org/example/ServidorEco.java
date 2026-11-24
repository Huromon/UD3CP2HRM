package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorEco {
public static void main(){
  final int PUERTO = 5000;
    Random ran = new Random();
    int numero = ran.nextInt(100);
    int count = 0;
  try (ServerSocket ss = new ServerSocket(PUERTO)){


    try (Socket s = ss.accept();

         BufferedReader in = new BufferedReader(
                 new InputStreamReader(s.getInputStream()));
         PrintWriter out = new PrintWriter(
                 s.getOutputStream(),true)) {
        String linea;
        int num ;

        while ((linea = in.readLine())!=null){
            count++;
            try {
                num = Integer.parseInt(linea);

                System.out.println(num);
                if (num > numero) {
                    out.println("MENOR");
                } else if (num < numero) {
                    out.println("MAYOR");
                } else if (num == numero) {
                    out.println("Correcto era el " + numero + " nº de intentos: " + count);
                   break;
                }
            }catch (NumberFormatException e){
                System.out.println("no se ha recibido un numero");
            }


        }
    }
  }catch (IOException e ){
      e.printStackTrace();
  }
}
}
