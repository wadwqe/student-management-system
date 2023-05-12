package Stu;

import TIME.Time;
import TotalAffair.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Student {
    //学生列表,数组大小设置为1000
    private static Student[] student = new Student[1000];
    private final int id;
    private static int total_id = 0;
    private String name;
    private String password;
    private int location;

    //时间表
    private int[] ctime_table;
    private int[] gtime_table;
    private int[] ptime_table;
    private int[] ttime_table;
    //每个学生所拥有的活动或课程
    private List<GroupActivity> glist;
    private List<PersonalActivity> plist;
    private List<TemporaryAffair> tlist;
    private List<Lesson> clist;

    public Student(String name, int location) {
        this.id = total_id;
        total_id++;
        this.name = name;
        this.location = location;
        ctime_table = new int[3000];
        gtime_table = new int[3000];
        ptime_table = new int[3000];
        ttime_table = new int[24];
        glist = new ArrayList<GroupActivity>();
        plist = new ArrayList<PersonalActivity>();
        tlist = new ArrayList<TemporaryAffair>();
        clist = new ArrayList<Lesson>();
    }
    public static void addStudent(Student student)
    {
        //学生列表数组大小设置为1000
        Student.student[student.getId()] = student;
        //打印学生列表
        for(int i = 0; i < total_id; i++)
        {
            System.out.println(Student.student[i].getName());
        }
    }
    //根据学生名字查找学生是否存在于学生列表中
    public static Student findStudent(String name)
    {
        for(int i = 0; i < total_id; i++)
        {
            if(student[i].getName().equals(name))
            {
                return student[i];
            }
        }
        return null;
    }
    //查找学生的已选课程，返回课程列表
    public List<Lesson> findLesson()
    {
        return clist;
    }

    //学生进行选课
    public void chooseLesson(Lesson lesson)
    {
        clist.add(lesson);
        //更新时间表
        for(int i = lesson.getStartTime(); i < lesson.getEndTime(); i++)
        {
            ctime_table[i] = 1;
        }
    }

    public int[] getPtime_table() {
        return ptime_table;
    }
    public int[] getGtime_table(){
        return gtime_table;
    }
    public int[] getCtime_table() {
        return ctime_table;
    }

    public int[] getTtime_table() {
        return ttime_table;
    }
    public List<TemporaryAffair> getTlist() {
        return tlist;
    }
    public List<PersonalActivity> getPlist() {
        return plist;
    }
    public List<GroupActivity> getGlist() {
        return glist;
    }
    public List<Lesson> getClist() {
        return clist;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    public int getId() {
        return id;
    }
    public Boolean isConflict(Affair affair)
    //检测时间冲突，若有冲突则返回true
    {
        if(affair instanceof GroupActivity) {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    if(ctime_table[j + i * 24 * 7] != 0 || gtime_table[j+i * 24 * 7] != 0 || ptime_table[j+i * 24 * 7] != 0)
                    {
                        return true;
                    }
                }
            }
        }
        else if(affair instanceof PersonalActivity) {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    if(ctime_table[j + i * 24 * 7] != 0 || gtime_table[j+i * 24 * 7] != 0 || ptime_table[j+i * 24 * 7] != 0)
                    {
                        return true;
                    }
                }
            }
        }
        else if(affair instanceof TemporaryAffair) {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    if(ctime_table[j + i * 24 * 7] != 0 || gtime_table[j+i * 24 * 7] != 0 || ptime_table[j+i * 24 * 7] != 0)
                    {
                        return true;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    if(ctime_table[j + i * 24 * 7] != 0)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void addAffair(Affair affair)
    //给实例添加课程或活动事务
    {
        int len;
        List templist;
        int[] temp_table = null;
        if(affair instanceof GroupActivity) {
            len = glist.size();
            templist = glist;
            temp_table = gtime_table;
        }
        else if(affair instanceof PersonalActivity) {
            len = plist.size();
            templist = plist;
            temp_table = ptime_table;
        }
        else if(affair instanceof TemporaryAffair) {
            len = tlist.size();
            templist = tlist;
            temp_table = ttime_table;
        }
        else {
            len = clist.size();
            templist = clist;
            temp_table = ctime_table;
        }
        if(isConflict(affair))
        {
            System.out.println("Conflict!");
            avoidConflict(affair);
            return;
        }
        if(temp_table != ttime_table)
        {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    temp_table[j + i * 24 * 7] = affair.getId();
                }
            }
        }
        else
        {
            for (int i = 0; i < affair.getCycle(); i++) {
                for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                    temp_table[j % 24] = 1;
                }
            }
        }
        int i = 0;
        if (!templist.isEmpty()) {
            i = Collections.binarySearch(templist, affair, new UserComparator());
        }
        else
        {
            templist.add(affair);
            return;
        }
        if(i >= 0){
            templist.add(i, affair);
        }
        else{
            templist.add(-i-1, affair);
        }
    }
    public void deleteAffair(Affair affair)
    //给实例删除课程或活动事务
    {
        int len;
        List templist;
        if(affair instanceof GroupActivity) {
            len = glist.size();
            templist = glist;
        }
        else if(affair instanceof PersonalActivity) {
            len = plist.size();
            templist = plist;
        }
        else if(affair instanceof TemporaryAffair) {
            len = tlist.size();
            templist = tlist;
        }
        else {
            len = clist.size();
            templist = clist;
        }
        int i = 0;
        if (!templist.isEmpty()) {
            i = Collections.binarySearch(templist, affair, new UserComparator());
        }
        if(i > 0){
            int[] temp_table = null;
            if(templist == clist)
            {
                temp_table = ctime_table;
            }
            else if(templist == plist)
            {
                temp_table = ptime_table;
            }
            else if(templist == glist)
            {
                temp_table = gtime_table;
            }
            else
            {
                temp_table = ttime_table;
            }
            if(temp_table != null)
            {
                for (int k = 1; k <= affair.getCycle(); k++) {
                    for (int j = affair.getStartTime(); j <= affair.getEndTime(); j++) {
                        temp_table[j % 24] = 0;
                    }
                }
            }
            templist.remove(i);
        }
    }
    public TemporaryAffair searchTemporaryAffair(String name) {
        for (TemporaryAffair temp : tlist) {
            if (temp.getName().equals(name)) {
                temp.printAffair();
                return temp;
            }
        }
            System.out.println("null");
            return null;
    }//查找临时事务
    public void updateTemporaryAffair(String name)
    //更新临时事务
    {
        TemporaryAffair temp = searchTemporaryAffair(name);
        if(temp != null)
        {
            int starttime = 12;
            int endtime = 12;
            int cycle = 1;
            int place = 10;
            boolean isOnline = false;
            String platform = "null";
            String link = "null";
            upTemporaryAffair(temp, starttime, endtime, cycle, place, isOnline, platform, link);
        }
    }
    private void upTemporaryAffair(TemporaryAffair temp, int starttime, int endtime, int cycle, int place, boolean isOnline, String platform, String link)
    //上面更新临时事务方法的子方法
    {
        temp.setStartTime(starttime);
        temp.setEndTime(endtime);
        temp.setCycle(cycle);
        temp.setPlace(place);
        temp.setOnline(isOnline);
        temp.setPlatform(platform);
        temp.setLink(link);
    }
    public void TimeDetection(Time now)
    //时间检测，系统时间每变化一秒就调用该方法检测是否有闹钟或者需要输出提醒
    {
        if(Time.getTime() % 24 == 0)
        {
            int flag = 0;
            int j = 0;
            int pre;
            for(int i = 0; i < 24; i ++)
            {
                pre = j;
                j = ctime_table[Time.getTime() + i];
                if(j != 0 && pre != j)
                {
                    if(flag == 0)
                    {
                        System.out.println("今天的课程如下:");
                        flag = 1;
                    }
                    Lesson.lessonKu[j].printDailyAffair();
                }
            }
            flag = 0;
            for(int i = 0; i < 24; i ++)
            {
                pre = j;
                j = gtime_table[Time.getTime() + i];
                if(j != 0 && pre != j)
                {
                    if(flag == 0)
                    {
                        System.out.println("今天的集体活动如下:");
                        flag = 1;
                    }
                    GroupActivity.groupactivity[j].printDailyAffair();
                }
            }
            flag = 0;
            for(int i = 0; i < 24; i ++)
            {
                pre = j;
                j = ptime_table[Time.getTime() + i];
                if(j != 0 && pre != j)
                {
                    if(flag == 0)
                    {
                        System.out.println("今天的个人活动如下:");
                        flag = 1;
                    }
                    PersonalActivity.personalactivity[j].printDailyAffair();
                }
            }
        }
        int j = ctime_table[Time.getTime() + 1];
        if(j != 0)
        {
            System.out.println(String.format("距离%s课还有一个小时。", Lesson.lessonKu[j].getName()));
        }
        if(!Time.qu.isEmpty() && Time.qu.peek().getTime() == Time.getTime())
        {
            Affair temp;
            switch(Time.qu.peek().getType())
            {
                case 0:
                    //lesson
                    temp = Lesson.lessonKu[Lesson.cache.get(Time.qu.peek().getName())];
                    break;
                case 1:
                    temp = GroupActivity.groupactivity[GroupActivity.cache.get(Time.qu.peek().getName())];
                    break;
                case 2:
                    temp = PersonalActivity.personalactivity[PersonalActivity.cache.get(Time.qu.peek().getName())];
                    break;
                    case 3:
                        temp = searchTemporaryAffair(Time.qu.peek().getName());
                        break;
                default:
                    temp = null;
                        break;
            }
            System.out.println("闹钟提醒，你有如下课程或事务");
            temp.printDailyAffair();
            Time.qu.remove();
        }
    }
    public void avoidConflict(Affair affair) {
        if (affair instanceof PersonalActivity || affair instanceof GroupActivity) {
            int flag = 0;
            int[] busy_time = new int[500];
            for (int i = 0; i < 500; i++) {
                busy_time[i] = -1;
            }
            int temp_time = affair.getStartTime() / 24 * 24;
            int len = affair.getEndTime() - affair.getStartTime() + 1;
            int i, j;
            for (i = 6; i + len < 23; i++)
            {
                int conflict_num = 3;
                for (j = 0; j < affair.getCycle(); j++) {
                    for(int k = 0; k < len; k++)
                    {
                            if (ptime_table[temp_time + i + j * 7 * 24 + k] != 0) {
                                conflict_num++;
                            }
                            if (gtime_table[temp_time + i + j * 7 * 24 + k] != 0) {
                                conflict_num++;
                            }
                            if (ctime_table[temp_time + i + j * 7 * 24 + k] != 0) {
                                conflict_num++;
                            }
                    }
                }
                if(conflict_num == 3)
                {
                    conflict_num = 0;
                }
                while (busy_time[conflict_num] != -1) {
                    conflict_num++;
                }
                if (conflict_num < 500) {
                    busy_time[conflict_num] = temp_time + i;
                }
                if(busy_time[0] != -1 && busy_time[1] != -1 && busy_time[2] != -1)
                {
                    flag = 1;
                    break;
                }
        }
        if (flag == 1) {
            System.out.println("空闲时间如下");
            for (i = 0; i < 3; i++) {
                System.out.println(busy_time[i]);
            }
        }
        else if(flag == 0 && affair instanceof PersonalActivity)
        {
            System.out.println("无空闲时间");
        }
        else if (flag == 0 && affair instanceof GroupActivity) {
            int t = 0;
            System.out.println("最少冲突时间如下");
            for (i = 0; i < 500 && t < 3; i++) {
                if (busy_time[i] != -1) {
                    System.out.println(busy_time[i]);
                    t++;
                        }
                    }
                }
            }
        }//避免冲突
}
