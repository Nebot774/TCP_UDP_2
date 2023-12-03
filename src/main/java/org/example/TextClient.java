package org.example;

import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.Scanner;
public class TextClient {
    public static void main(String[] args) throws IOException {

        // Crear un socket para conectarse al servidor en el puerto 6789
        Socket socket=new Socket("localhost",6789);

        // Crear un PrintWriter para enviar mensajes al servidor
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

        //creamos un scaner para leer la entrada del usuario
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese texto para enviar al servidor:");

        //leemos la entrada del usuario
        String userinput=scanner.nextLine();

        //codificamos el mensaje en base64
        String encodeMessage=Base64.getEncoder().encodeToString(userinput.getBytes());

        //enviamos el mensaje codificado al servidor con delimitadores
        out.println("#"+encodeMessage+"#");

        //cerramos recursos
        scanner.close();
        out.close();
        socket.close();



    }
    }
