package DeepIntoJVM.chp12;

import java.util.concurrent.atomic.AtomicInteger;

public class Code1Test2 {
    // 使用AtomicInteger定义a
    static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        Code1Test2 code1Test2 = new Code1Test2();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5 ; i++) {
            threads[i] = new Thread(() -> {
                try{
                    for (int j =0; j<10; j++){
                        // 使用getAndIncrement函数进行自增
                        System.out.println(a.incrementAndGet());
                        Thread.sleep(500);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

    }
}
