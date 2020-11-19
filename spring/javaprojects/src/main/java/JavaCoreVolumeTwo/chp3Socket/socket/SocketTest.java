package JavaCoreVolumeTwo.chp3Socket.socket;

import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws UnknownHostException {
        try{
            // 用于打开一个套接字，它也是网络软件中的一个抽象概念，负责启动该程序内部和外部之间的通信
            // Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            // 上面这个构造器会一直无限期的阻塞下去
            Socket s = new Socket();
            s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13));

            // 调用setSoTimeout方法设置这个超时值（单位：毫秒）。
            s.setSoTimeout(10000);
            // java.net.Socket类中的getInputStream方法就会返回一个InputStream对象，
            InputStream inStream = s.getInputStream();
            Scanner sc = new Scanner(inStream);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }

        }catch (InterruptedIOException e){
            System.out.println("time out");
        }

        catch (Exception e){
            e.printStackTrace();
        }

        InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");

        System.out.println("address is : " + address);
        // 一个InetAddress对象，该对象封装了一个4字节的序列：132.163.4.104
        byte[] address1 = address.getAddress();

        // 可以通过调用getAllByName方法来获得所有主机
        InetAddress[] baidus = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress baidu: baidus){
            System.out.println("baidu: "+baidu);
        }
        //可以使用静态的getLocalHost方法来得到本地主机的地址：
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localhost: "+localHost); // localhost: DESKTOP-UM7B36E/169.254.133.217




    }
}
