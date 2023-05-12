package TotalAffair;

import java.util.HashMap;
import java.util.Map;

public class GroupActivity extends Affair {
    private static int total_id = 1;
    public static GroupActivity[] groupactivity = new GroupActivity[1000];
    public static Map<String, Integer> cache = new HashMap<>(1000);     //用于存储活动名和id的映射
//集体活动的专属属性

    //子类一的构造函数（后期需要补上专属属性）
    public GroupActivity(String name, int startTime, int endTime, int cycle, int place, boolean isOnline, String platform, String link) {
        super(name, startTime, endTime, cycle, place, isOnline, platform, link);
        cache.put(name, total_id);
        super.setId(total_id++);
        groupactivity[getId()] = this;
    }
    public GroupActivity(String name, int startTime, int endTime, int cycle, int place){
        super.setName(name);
        super.setStartTime(startTime);
        super.setEndTime(endTime);
        super.setCycle(cycle);
        super.setPlace(place);
        cache.put(name, total_id);
        super.setId(total_id++);
        groupactivity[getId()] = this;
    }
    public static Boolean searchGroupActivity(String name)
    {
        if(cache.get(name) != null)
        {
            groupactivity[cache.get(name)].printAffair();
            return true;
        }
        else
        {
            System.out.println("null");
            return false;
        }
    }
    public static void updateGroupActivity(String name)
    {
        if(searchGroupActivity(name))
        {
            int starttime = 12;
            int endtime = 12;
            int cycle = 1;
            int place = 10;
            boolean isOnline = false;
            String platform = "null";
            String link = "null";
            upGroupActivity(name, starttime, endtime, cycle, place, isOnline, platform, link);
        }
    }
    private static void upGroupActivity(String name, int starttime, int endtime, int cycle, int place, boolean isOnline, String platform, String link)
    {
        GroupActivity temp = groupactivity[cache.get(name)];
        temp.setStartTime(starttime);
        temp.setEndTime(endtime);
        temp.setCycle(cycle);
        temp.setPlace(place);
        temp.setOnline(isOnline);
        temp.setPlatform(platform);
        temp.setLink(link);
    }
//子类一的专属方法
}