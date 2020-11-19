package java7ConcurrentProgram.chp2.p3;

/**
 * final修饰
 * 1. 类：不可以被继承
 * 2. 方法：不可以被重写
 * 3. 变量：不可变
 *
 * 使用非依赖属性实现同步；
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema(){
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    /**
     * 当第一个电影院有票卖出的时候将调用这个方法
     * 使用controlCinema1对象控制同步代码块的访问
     * 用synchronized关键字保护代码块时，使用对象作为它的传入参数。
     * JVM能保证同一时间只有一个线程能够访问这个对象的同步代码块；
     *
     * 这个例子使用了controlCinema1对象来控制对vacanciesCinema1属性的访问
     * 这个例子使用了controlCinema2对象来控制对vacanciesCinema2属性的访问
     *
     *
     * @param number
     * @return
     */
    public boolean sellTicket1(int number){
        synchronized (controlCinema1){
            if (number < vacanciesCinema1){
                vacanciesCinema1 -= number;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean sellTicket2(int number){
        synchronized (controlCinema2){
            if (number < vacanciesCinema2){
                vacanciesCinema2 -= number;
                return true;
            }else {
                return false;
            }
        }
    }

    /**
     * 当第一个电影院有票退回的时候调用；
     * 使用controlCinema1对象控制同步代码块的访问
     * @param number
     * @return
     */
    public boolean returnTicket1(int number){
        synchronized (controlCinema1){
            vacanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTicket2(int number){
        synchronized (controlCinema2){
            vacanciesCinema2 += number;
            return true;
        }
    }

    /**
     * 返回各自电影院的票数
     */
    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
