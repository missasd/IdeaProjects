package JavaCoreVolumeTwo.chp3Socket.socketDemo;



import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 818955533;
        // 立一个负责监控端口8189的服务器
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        // 服务器发送给服务器输出流的所有信息都会成为客户端程序的输入，
        // 来自客户端程序的所有输出都会被包含在服务器输入流中。
        InputStream inputStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();

        try {
            Scanner scin = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outStream, true);
            out.print("Hello! Enter BYE to exit!");

            boolean done = false;
            while (!done && scin.hasNextLine()){
                String line = scin.nextLine();
                out.print("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }
            scin.close();
            socket.close();
            server.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

