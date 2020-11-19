package ArtofConcurrent.chp1.p1;

public class ConcurrencyTest {
    private static final long count = 10000L;

    public static void main(String[] args) {
        concurrency();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() -start;
        System.out.println("serial: " + time + "ms, b = " +b+ ", a = " + a);
        
    }

    private static void concurrency() {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() -start;
        System.out.println("Concurrent: " + time + "ms, b = " +b);
    }

}
