package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                        } else if (str.contains("?msg=Exit")) {
                            server.close();
                        } else if (str.contains("?msg=")) {
                            out.write("http://localhost:9000/?msg=What".getBytes());
                        }
                    }
                    out.flush();
                } catch (IOException e) {
                    LOG.error("Exception in log example", e);
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}
