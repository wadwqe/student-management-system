package TIME;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Time {
    private static int time = 5;       //默认当前时间是10点
    public static Queue<Clock> qu = new PriorityQueue<>(new UserComparator1());     //优先队列，按照时间排序
    public static int getTime() {
        return time;
    }
    public static void addTime() {
        Time.time ++;
    }

    public static void addClock(Clock clock)
    {
        for(int i = 0; i < clock.getCycle(); i ++)//getCycle()是周期，比如如果是每天的话，就是1，如果是每周的话，就是7
        {
            Clock temp = new Clock(clock.getType(), clock.getName(), clock.getTime() + i * clock.getInterval(), clock.getCycle(), clock.getInterval());//getInterval()是间隔
            qu.add(temp);
        }
    }
}
class UserComparator1 implements Comparator<Clock> //
{
    public int compare(Clock p1, Clock p2) {
        return p1.getTime() - p2.getTime();
    }
}