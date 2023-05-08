package TotalAffair;


import java.util.HashMap;
import java.util.Map;

public class Lesson extends Affair {
    //继承的属性：名称，开始时间，结束时间，循环几周，地点，是否线上，线上平台，线上链接
    private static int total_id = 1;        //总id
    public static Lesson[] lessonKu = new Lesson[1000];   //课程库
    public static Map<String, Integer> cache = new HashMap<>(1000);
    public Lesson(String name,int startTime,int endTime,int cycle, int place,boolean isOnline,String platform,String link) //构造函数1
    {
        super(name ,startTime ,endTime ,cycle, place ,isOnline ,platform ,link);
        cache.put(name, total_id);
        super.setId(total_id++);
        lessonKu[getId()] = this;   //添加到课程库
        //打印课程库
        System.out.println("课程库：");
        for(int i = 1; i < total_id; i++)
        {
            lessonKu[i].printAffair();
        }

    }
    public Lesson(String name, int startTime, int endTime, int cycle, int place)//构造函数2
    {
        super.setName(name);
        super.setStartTime(startTime);
        super.setEndTime(endTime);
        super.setCycle(cycle);
        super.setPlace(place);
        cache.put(name, total_id);
        super.setId(total_id++);
        lessonKu[getId()] = this;   //添加到课程库
    }
    public static Boolean searchLesson(String name)         //通过课程名查找课程，所以课程名不能重复
    {
        if(cache.get(name) != null)
        {
            lessonKu[cache.get(name)].printAffair();
            return true;
        }
        else
        {
            System.out.println("null");
            return false;
        }
    }

    public static void updateLesson(String name)        //通过课程名更新课程信息
    {
        if(searchLesson(name))//如果存在该课程
        {
            int starttime = 12;
            int endtime = 12;
            int cycle = 1;
            int place = 10;
            boolean isOnline = false;
            String platform = "null";
            String link = "null";
            uplesson(name, starttime, endtime, cycle, place, isOnline, platform, link);
        }
    }

    private static void uplesson(String name, int starttime, int endtime, int cycle, int place, boolean isOnline, String platform, String link)//更新课程信息
    {
        Lesson temp = lessonKu[cache.get(name)];
        temp.setStartTime(starttime);
        temp.setEndTime(endtime);
        temp.setCycle(cycle);
        temp.setPlace(place);
        temp.setOnline(isOnline);
        temp.setPlatform(platform);
        temp.setLink(link);
    }

}
