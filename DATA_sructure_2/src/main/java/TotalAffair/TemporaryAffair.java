package TotalAffair;


import java.util.HashMap;
import java.util.Map;

public class TemporaryAffair extends Affair {
//    private static int total_id = 0;
//    private static TemporaryAffair[] temporaryaffair = new TemporaryAffair[1000];
//    private static Map<String, Integer> cache = new HashMap<>(1000);
    public TemporaryAffair(String name,int startTime,int endTime,int place, boolean isOnline,String platform,String link) {
        super.setName(name);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setPlace(place);
        this.setOnline(isOnline);
        this.setPlatform(platform);
        this.setLink(link);
        this.setCycle(1);
    }
    public TemporaryAffair(String name, int startTime, int endTime, int place){
        super.setName(name);
        super.setStartTime(startTime);
        super.setEndTime(endTime);
        super.setPlace(place);
        super.setCycle(1);
    }
}