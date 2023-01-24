package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Temp {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = in.readLine().split(" ")[1].substring(6);
                    if (string.equals("Hello")) {
                        string = "Hello";
                    }
                    if (string.equals("Exit")) {
                        server.close();
                    }
                    System.out.println(string);
                    out.write(string.getBytes());
                    out.flush();
                }
            }
        }
    }
}

