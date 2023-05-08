import LOG.Log;
import Stu.Student;
import TIME.Clock;
import TIME.Time;
import TotalAffair.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentTest {
    Time now = new Time();
    @BeforeEach
    void unit()
    {

    }
    @Test
    void testAddClass(){
        Log log = new Log();
        Student xiaomin = new Student("xiaomin", 0);
        Student xioahong = new Student("xiaohong", 1);
        Student xiaonan = new Student("xiaonan", 2);
        Affair  chiness = new Lesson("chiness", 0, 1, 1, 10);  //String name, int startTime, int endTime, int place
        Affair  chinese = new Lesson("chinese", 0, 1, 1, 10);  //String name, int startTime, int endTime, int place
        Affair  english = new Lesson("english", 2, 2, 1, 10);
        Affair  math = new  Lesson("math", 3, 4, 1,  10);
        Affair  Physics = new  Lesson("Physics", 5, 6, 1, 10);
        Affair  Chemistry = new  Lesson("Chemistry", 7, 8, 1, 10);
        Affair  Biology = new  Lesson("Biology", 9, 10, 1, 10);
        Affair  Geography = new  Lesson("Geography", 11, 12, 1,10);
        Affair  Politics = new  Lesson("Politics", 13, 14, 2, 10);
        xiaomin.addAffair(chinese);
        xiaomin.addAffair(english);
        xiaomin.addAffair(math);
        xiaomin.addAffair(Physics);
        xiaomin.addAffair(Chemistry);
        xiaomin.addAffair(Biology);
        xiaomin.addAffair(Geography);
        xiaomin.addAffair(Politics);
        xiaomin.addAffair(chiness);
//        xiaomin.deleteAffair(english);
//        xiaomin.deleteAffair(Chemistry);
        log.printLesson(xiaomin);
//        Lesson.searchLesson("Geography");
//        log.printCtime_table(xiaomin);
//        Lesson.updateLesson("chinese");
//        log.printTotalLesson();
//        log.printLesson(xiaomin);
//        xiaomin.TimeDetection(now);
//        log.printWeekLesson(xiaomin, now);
    }
    @Test
    void testAddActivity() {
        Log log = new Log();
        Student xiaomin = new Student("xiaomin", 0);//添加学生xiaomin

/*        Student xioahong = new Student("xiaohong", 1);
        Student xiaonan = new Student("xiaonan", 2);

        Affair  chiness = new Lesson("chiness", 0, 1, 1, 10);  //String name, int startTime, int endTime, int place*/

        //xiaomin.addAffair(chiness);
/*        Affair  chinese01 = new PersonalActivity("chinese", 0, 0, 1, 10);  //new一个个人事务
        Affair  english = new PersonalActivity("english", 1, 1, 1, 10);
        Affair  math = new  PersonalActivity("math", 2, 2, 1,  10);
        Affair  Physics = new  PersonalActivity("Physics", 3, 3, 1, 10);
        Affair  Chemistry = new  PersonalActivity("Chemistry", 4, 4, 1, 10);
        Affair  Biology = new  PersonalActivity("Biology", 5, 5, 1, 10);
        Affair  Geography = new  PersonalActivity("Geography", 6, 6, 1,10);*/
        Affair  Politics0 = new  PersonalActivity("Politics0", 7, 8, 2, 10);
        Affair  Politics1 = new GroupActivity("Politics1", 3, 4, 2, 10);
        Affair  Politics2 = new GroupActivity("Politics2", 5, 7, 2, 10, true, "腾讯会议","http://123456");


/*        xiaomin.addAffair(chinese01);//为xiaomin学生添加个人事务
        xiaomin.addAffair(english);
        xiaomin.addAffair(math);
        xiaomin.addAffair(Physics);
        xiaomin.addAffair(Chemistry);
        xiaomin.addAffair(Biology);
        xiaomin.addAffair(Geography);*/
        xiaomin.addAffair(Politics0);
        xiaomin.addAffair(Politics1);
        xiaomin.addAffair(Politics2);

        log.printPersonalActivity(xiaomin);   //打印个人事务
        log.printGroupActivity(xiaomin);   //打印小组事务
        //打印集体事务时间表
        log.printGtime_table(xiaomin);
/*        log.printPtime_table(xiaomin);    //打印个人时间表*/
        Clock clock1 = new Clock(1, "Politics2", 5, 4, 1);    //new一个闹钟，闹钟名字为math，闹钟响铃时间为6点，这个闹钟重复4次，每天响一次
        Time.addClock(clock1);    //添加闹钟
        xiaomin.TimeDetection(now);   //时间检测，now=5

//        PersonalActivity.searchPersonalActivity("Geography"); //查找个人事务
//        log.printPersonalActivity(xiaomin);   //打印个人事务
//        PersonalActivity.updatePersonalactivity("chinese");   //更新个人事务
//        log.printPersonalActivity(xiaomin);   //打印个人事务
//        log.printPtime_table(xiaomin);    //打印个人时间表
//        Clock clock1 = new Clock(2, "math", 10, 4, 1);    //new一个闹钟
//        Time.addClock(clock1);    //添加闹钟
//        xiaomin.TimeDetection(now);   //时间检测
    }
    @Test
    void testAddTemporaryAffair() {
        Log log = new Log();
        Student xiaomin = new Student("xiaomin", 0);
        Student xioahong = new Student("xiaohong", 1);
        Student xiaonan = new Student("xiaonan", 2);
        Affair  chiness = new TemporaryAffair("chiness", 0, 1,  10);  //String name, int startTime, int endTime, int place
        //xiaomin.addAffair(chiness);
        Affair  chinese = new TemporaryAffair("chinese", 0, 0, 10);  //String name, int startTime, int endTime, int place
        Affair  english = new TemporaryAffair("english", 1, 1, 10);
        Affair  math = new  TemporaryAffair("math", 2, 2, 10);
        Affair  Physics = new  TemporaryAffair("Physics", 3, 3,  10);
        Affair  Chemistry = new  TemporaryAffair("Chemistry", 4, 4,  10);
        Affair  Biology = new  TemporaryAffair("Biology", 5, 5,  10);
        Affair  Geography = new  TemporaryAffair("Geography", 6, 6, 10);
        Affair  Politics = new  TemporaryAffair("Politics", 7, 7,  10);
        xiaomin.addAffair(chinese);
        xiaomin.addAffair(english);
        xiaomin.addAffair(math);
        xiaomin.addAffair(Physics);
        xiaomin.addAffair(Chemistry);
        xiaomin.addAffair(Biology);
        xiaomin.addAffair(Geography);
        xiaomin.addAffair(Politics);
        //PersonalActivity.searchPersonalActivity("Geography");
//        log.printTemporaryAffair(xiaomin);
//        Clock clock1 = new Clock(2, "math", 0, 4, 1);
//        Time.addClock(clock1);
//        xiaomin.TimeDetection(now);
//        log.printClock();
        //xiaomin.updateTemporaryAffair("chinese");
//        log.printTemporaryAffair(xiaomin);
//        log.printTtime_table(xiaomin);
    }
}
