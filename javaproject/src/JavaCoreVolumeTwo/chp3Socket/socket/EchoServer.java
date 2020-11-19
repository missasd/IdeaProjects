package JavaCoreVolumeTwo.chp3Socket.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try{
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            try {
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);
                out.println("Hello! Enter yes to exit");

                boolean done = false;
                while ((!done) && in.hasNextLine()){
                    String line = in.nextLine();
                    out.print("Echo: " + line);
                    if (line.trim().equals("BYE")) done=true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
