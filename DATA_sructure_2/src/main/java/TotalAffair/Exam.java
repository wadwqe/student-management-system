package TotalAffair;

import java.util.HashMap;
import java.util.Map;



public class Exam extends Affair{
    public static Exam[] examKu=new Exam[1000];
    private static int total_id = 1;        //总id
    public static Map<String, Integer> cache = new HashMap<>(1000);

    public Exam(String name, int startTime, int endTime, int place, boolean isOnline, String platform, String link) {

        super(name ,startTime ,endTime ,1, place ,isOnline ,platform ,link);
        cache.put(name, total_id);
        super.setId(total_id++);
        examKu[getId()] = this;   //添加到考试库
        //打印考试库
        System.out.println("考试库：");
        for(int i = 1; i < total_id; i++)
        {
            examKu[i].printAffair();
        }
    }
    public static Boolean searchExam(String name)         //通过考试名查找课程，所以考试名不能重复
    {
        if(cache.get(name) != null)
        {
            examKu[cache.get(name)].printAffair();
            return true;
        }
        else
        {
            System.out.println("null");
            return false;
        }
    }

}
