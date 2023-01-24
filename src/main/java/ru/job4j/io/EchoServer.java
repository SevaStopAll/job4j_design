package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = in.readLine().split(" ")[1].substring(6);
                    if ("Hello".equals(string)) {
                        string = "Hello";
                    }
                    if ("Exit".equals(string)) {
                        server.close();
                    }
                    System.out.println(string);
                    out.write(string.getBytes());
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}

