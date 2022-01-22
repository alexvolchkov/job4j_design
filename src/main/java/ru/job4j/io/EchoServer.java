package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String command = "null";
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=")) {
                            command = parseString(str);
                        }
                    }
                    if ("Hello".equals(command)) {
                        out.write("Hello, dear friend.".getBytes());
                    } else if ("Exit".equals(command)) {
                        server.close();
                    } else {
                        out.write(String.format("http://localhost:9000/?msg=%s", command).getBytes());
                    }
                    out.flush();
                }
            }
        }
    }

    private static String parseString(String string) {
        String rsl = null;
        String[] array = string.split(" |/");
        for (String s : array) {
            if (s.startsWith("?msg=")) {
                rsl = s.substring(5);
                break;
            }
        }
        return rsl;
    }
}
