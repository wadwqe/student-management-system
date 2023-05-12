package ADMINISTRATOR;

import TotalAffair.Exam;
import TotalAffair.Lesson;

import static TotalAffair.Exam.*;
import static TotalAffair.Lesson.lessonKu;
import static TotalAffair.Lesson.searchLesson;

public class Administrator {
    //通过调用Lesson类的构造函数来添加课程，课程包括名称，开始时间，结束时间，循环几周，地点，是否线上，线上平台，线上链接
    public static Lesson[] addLesson(String name, int startTime, int endTime, int cycle, int place, boolean isOnline, String platform, String link)
    {
        //判断是否已经存在该课程
        if(searchLesson(name)==true)
        {
            System.out.println("该课程已经存在");
            return lessonKu;
        }
        Lesson lesson = new Lesson(name, startTime, endTime, cycle, place, isOnline, platform, link);//新建课程

        return lessonKu;

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

    public static Exam[] addExam(String name, int startTime, int endTime, int place, boolean isOnline, String platform, String link)
    {
        //判断是否已经存在该考试
        if(searchExam(name)==true)
        {
            System.out.println("该考试已经存在");
            return examKu;
        }

        Exam exam = new Exam(name, startTime, endTime, place, isOnline, platform, link);//新建考试
        //添加到考试库
        return examKu;

    }



}
