package DeepIntoJVM.chp12;

public class Code1Test1 {
    // 一个变量a
    private static volatile int a = 0;

    public static void main(String[] args) {
        Code1Test1 test = new Code1Test1();
        Thread[] threads = new Thread[5];
        // 定义5个线程，每个线程加10
        for (int i = 0; i < 5 ; i++) {
            threads[i] = new Thread(() -> {
                try{
                    for (int j = 0; j < 10; j++){
                        System.out.println(a++);
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
