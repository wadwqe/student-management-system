package TIME;
public class Clock {
    private int type;
    private String name;
    private int time;
    private int cycle;//周期
    private int interval;//间隔
    public Clock(int type, String name, int time, int cycle, int interval)//比如想要设置一个每天5点提醒的闹钟，就可以这样写：new Clock(2, "每天提醒", 5, 120, 1)
    {
        this.type = type;//type=1,表示这个闹钟是针对课程的，type=2，表示这个闹钟是针对集体活动的，type=3，表示这个闹钟是针对个人活动的，type=4，表示这个闹钟是针对临时事务的
        this.name = name;//这个名字必须要关联具体的课程或者活动，比如“每天提醒”这个名字就不行，必须要写成“英语课——吴启凡”
        this.time = time;//time = 10 表示这个闹钟会在10点响
        this.cycle = cycle;//cycle = 3 表示这个闹钟一共会响3次，最大值为120，即如果每天响一次有效期是4个月
        this.interval = interval;//interval =  表示这个闹钟每隔7天会响一次，比如interval = 7，cycle = 3，那么这个闹钟会在第7天，第14天，第21天响
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
