package ADMINISTRATOR;

import TotalAffair.Lesson;

public class Administrator {
    //通过调用Lesson类的构造函数来添加课程，课程包括名称，开始时间，结束时间，循环几周，地点，是否线上，线上平台，线上链接
    public static void addLesson(String name, int startTime, int endTime, int cycle, int place, boolean isOnline, String platform, String link)
    {
        //判断是否已经存在该课程
        Lesson lesson = new Lesson(name, startTime, endTime, cycle, place, isOnline, platform, link);//新建课程

    }

    public void updateLesson(String name)
    {
        Lesson.updateLesson(name);
    }
    public void deleteLesson(String name)
    {
        if(Lesson.cache.get(name) != null)
        {
            Lesson.cache.remove(name);
        }
    }

    public void releaseExam(String name, int startTime, int endTime, int place)
    {

    }



}
