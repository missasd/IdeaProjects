package java8inaction.chp1.p1.q3;

/**
 * 作为生产者和消费者之间的共享数据类型
 */
public class PCData {
    private final  int intData;
    public PCData(int d){
        this.intData = d;
    }
    public PCData(String d){
        this.intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return  "data:" + intData;
    }
}
