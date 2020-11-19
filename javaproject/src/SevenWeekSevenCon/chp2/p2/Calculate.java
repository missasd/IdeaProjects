package SevenWeekSevenCon.chp2.p2;

import java.util.concurrent.atomic.AtomicInteger;

public class Calculate implements Runnable{
    private Integer j;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(++j);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Calculate calculate = new Calculate();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println(i);
                }
            }
        });
        thread.start();



    }
}
