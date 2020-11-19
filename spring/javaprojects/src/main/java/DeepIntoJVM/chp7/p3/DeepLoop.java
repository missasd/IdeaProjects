package DeepIntoJVM.chp7.p3;

public class DeepLoop {
    static {
        //
        if (true){
            System.out.println(Thread.currentThread() + "init DeepLoop");
            while (true){

            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeepLoop dlc = new DeepLoop();
                System.out.println(Thread.currentThread() + " run over");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeepLoop dlc = new DeepLoop();
                System.out.println(Thread.currentThread() + " run over");
            }
        });

        thread1.start();
        thread2.start();
    }
}
