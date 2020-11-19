package JavaCoreVolumeTwo.chp3Socket.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        Socket incoming = new Socket();
        try {
            // 用于建立一个负责监控端口8189的服务器
            ServerSocket serverSocket = new ServerSocket(8189);
            // 用于告诉程序不停地等待，直到有客户端连接到这个端口。
            // 一旦有人通过网络发送了正确的连接请求，并以此连接到了端口上，
            // 该方法就会返回一个表示连接已经建立的Socket对象。
            incoming = serverSocket.accept();
            // 你可以使用这个对象来得到输入流和输出流
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            //
            Scanner scin = new Scanner(inStream);
            PrintWriter outprintWriter = new PrintWriter(outStream, true);
            outprintWriter.println("Hello ");



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            incoming.close();
        }
    }
}
