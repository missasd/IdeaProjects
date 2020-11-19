package java7ConcurrentProgram.chp6.p5;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed {

    private Date startDate;

    public Event(Date date){
        this.startDate = date;
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0){
            return -1;
        }else if (result > 0){
            return 1;
        }
        return 0;
    }

    /**
     * 返回当前对象的startDate和当前实际日期的间隔
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);

    }
}
