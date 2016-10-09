package test.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VTimeServer {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("TimeServer start. " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool executor = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                executor.execute(new TimeServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                server.close();
                server = null;
            }
        }
    }
}
