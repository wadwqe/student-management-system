package TotalAffair;

public class Affair {
    //父类属性，包括事务名称，开始时间，结束时间，循环几周，地点，是否线上，线上平台，线上链接
    private int id;
    private String name;
    private int startTime;
    private int endTime;
    //循环几周
    private int cycle;
    private int place;
    private boolean isOnline;
    private String platform;
    private String link;

    public Affair() {
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }
    void setId(int id) {this.id = id;}

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    //构造函数，用于初始化
    public Affair(String name, int startTime, int endTime, int cycle, int place, boolean isOnline, String platform, String link) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cycle = cycle;
        this.place = place;
        this.isOnline = isOnline;
        this.platform = platform;
        this.link = link;
    }
    public void printAffair()
    {
        System.out.println("id: " + getId());
        System.out.println("name: " + getName());
        System.out.println("startTime: " + getStartTime());
        System.out.println("endTime: " + getEndTime());
        System.out.println("place: " + getPlace());
        System.out.println("isOnline: " + isOnline());
        System.out.println("platform: " + getPlatform());
        System.out.println("link: " + getLink());
        System.out.println();
    }
    public void printDailyAffair()
    {
        System.out.println("name: " + getName());
        System.out.println("startTime: " + getStartTime());
        System.out.println("endTime: " + getEndTime());
    }
//父类的方法
}