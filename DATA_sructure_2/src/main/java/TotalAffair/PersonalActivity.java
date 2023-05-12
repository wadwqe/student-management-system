package TotalAffair;


import java.util.HashMap;
import java.util.Map;

public class PersonalActivity extends Affair {
    private static int total_id = 1;
    public static PersonalActivity[] personalactivity = new PersonalActivity[1000];
    public static Map<String, Integer> cache = new HashMap<>(1000);
    public PersonalActivity(String name, int startTime, int endTime, int cycle, int place, boolean isOnline, String platform, String link) {
        super(name ,startTime ,endTime ,cycle, place ,isOnline ,platform ,link);
        cache.put(name, total_id);
        super.setId(total_id++);
        personalactivity[getId()] = this;
    }
    public PersonalActivity(String name, int startTime, int endTime, int cycle, int place){
        super.setName(name);
        super.setStartTime(startTime);
        super.setEndTime(endTime);
        super.setCycle(cycle);
        super.setPlace(place);
        cache.put(name, total_id);
        super.setId(total_id++);
        personalactivity[getId()] = this;
    }
    public static Boolean searchPersonalActivity(String name)
    {
        if(cache.get(name) != null)
        {
            personalactivity[cache.get(name)].printAffair();
            return true;
        }
        else
        {
            System.out.println("null");
            return false;
        }
    }
    public static void updatePersonalactivity(String name)
    {
        if(searchPersonalActivity(name))
        {
            int starttime = 12;
            int endtime = 12;
            int cycle = 1;
            int place = 10;
            boolean isOnline = false;
            String platform = "null";
            String link = "null";
            upPersonalactivity(name, starttime, endtime, cycle, place, isOnline, platform, link);
        }
    }
    private static void upPersonalactivity(String name, int starttime, int endtime, int cycle, int place, boolean isOnline, String platform, String link)
    {
        PersonalActivity temp = personalactivity[cache.get(name)];
        temp.setStartTime(starttime);
        temp.setEndTime(endtime);
        temp.setCycle(cycle);
        temp.setPlace(place);
        temp.setOnline(isOnline);
        temp.setPlatform(platform);
        temp.setLink(link);
    }
}
