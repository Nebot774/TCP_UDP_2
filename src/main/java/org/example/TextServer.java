package org.example;

import java.io.*;
import java.net.*;
import java.util.Base64;
public class TextServer {
    public static void main(String[] args) throws IOException {

        // Crear un socket de servidor en el puerto 6789
            ServerSocket serverSocket=new ServerSocket(6789);

            //creamos un archivo para escribir los mensajes descodificados
            File file=new File("C:\\Users\\Adria\\Desktop\\mensages-descodificados.txt");
            FileWriter fileWriter=new FileWriter(file, true);

            while (true){
                //esperamos conexiones de clientes
                Socket clientSocket=serverSocket.accept();

                //creamos un buffer para leer mensajes del cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                //leemos mensajes del cliente i quitamos los delimitadores
                String encodedMessage = in.readLine().substring(1);
                encodedMessage = encodedMessage.substring(0, encodedMessage.length() - 1);

                //descodificamso el mensaje
                String decodedMessage = new String(Base64.getDecoder().decode(encodedMessage));

                //escribe el mensaje descodificado en el archivo
                fileWriter.write(decodedMessage+"\n");

                //cerramos coenxiones
                in.close();
                clientSocket.close();

                fileWriter.close();







            }



    }
}
