package java7ConcurrentProgram.chp2.p6;

public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo){
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : Price1 : %f\n", Thread.currentThread().getName(), priceInfo.getPrice1());
            System.out.printf("%s : Price2 : %f\n", Thread.currentThread().getName(), priceInfo.getPrice2());
        }
    }
}
