package JavaCoreVolumeTwo.chp3Socket.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8189);
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
