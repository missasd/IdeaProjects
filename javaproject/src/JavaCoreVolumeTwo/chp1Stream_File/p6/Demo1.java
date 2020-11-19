package JavaCoreVolumeTwo.chp1Stream_File.p6;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo1 {
    public static void main(String[] args) {
        /**
         *  // \home\cay
         *   myprog\\conf\\user.properties
         */
        Path absolute = Paths.get("/home", "cay");
        Path relative = Paths.get("myprog", "conf", "user.properties");
        System.out.println(absolute);
        System.out.println(relative);
        // p.resolve(q)
        // get方法可以获取包含多个部件构成的单个字符串
        Path basePath = Paths.get("base","dir");
        Path workRelative = Paths.get("work");
        Path workPath = basePath.resolve(workRelative);
        System.out.println(workPath);



    }
}
