package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteEco {
    public static void main(){
        try (Socket s = new Socket("localhost",5000);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(
                     s.getOutputStream(),true );
        BufferedReader teclado = new BufferedReader(
                new InputStreamReader(System.in))){
            String linea;

String Resultado;
            System.out.println("Inserta un numero del 0-100");
            while ((linea = teclado.readLine())!=null){
                out.println((linea));
                Resultado=in.readLine();
                System.out.println(Resultado);
                if(!Resultado.equals("MAYOR")&& !Resultado.equals("MENOR")){
                    break;
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
