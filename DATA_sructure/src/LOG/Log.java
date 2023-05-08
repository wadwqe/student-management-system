package LOG;

import Stu.Student;
import TIME.Clock;
import TIME.Time;
import TotalAffair.GroupActivity;
import TotalAffair.Lesson;
import TotalAffair.PersonalActivity;
import TotalAffair.TemporaryAffair;
public class Log {
    public void printGroupActivity(Student student)
    {
        for(GroupActivity affair : student.getGlist())
        {
            System.out.println(affair.getName() + " " + affair.getStartTime());
        }
    }
    public void printPersonalActivity(Student student)
    {
        for(PersonalActivity affair : student.getPlist())
        {
            System.out.println(affair.getName() + " " + affair.getStartTime());
        }
    }
    public void printTemporaryAffair(Student student)
    {
        for(TemporaryAffair affair : student.getTlist())
        {
            System.out.println(affair.getName() + " " + affair.getStartTime());
        }
    }
    public void printLesson(Student student){
        for(Lesson affair : student.getClist())
        {
            System.out.println(affair.getName() + " " + affair.getStartTime());
        }
    }
    public void printCtime_table(Student student)
    {
        int cnt = 0;
        for(int i = 0; i < 2880; i ++)
        {
            if(i % 24 == 0)
            {
                cnt ++;
                System.out.print("   ");
            }
            if(i % (7 * 24) == 0)
            {
                cnt = 0;
                System.out.println();
            }
            if(i % 720 == 0)
            {
                System.out.println();
                System.out.println();
                for(int j = 0; j < cnt; j ++)
                {
                    System.out.print("                           ");
                }
            }
            System.out.print(student.getCtime_table()[i]);
        }
        System.out.println();
    }
    public void printPtime_table(Student student)
    {
        int cnt = 0;
        for(int i = 0; i < 2880; i ++)
        {
            if(i % 24 == 0)
            {
                cnt ++;
                System.out.print("   ");
            }
            if(i % (7 * 24) == 0)
            {
                cnt = 0;
                System.out.println();
            }
            if(i % 720 == 0)
            {
                System.out.println();
                System.out.println();
                for(int j = 0; j < cnt; j ++)
                {
                    System.out.print("                           ");
                }
            }
            System.out.print(student.getPtime_table()[i]);
        }
        System.out.println();
    }
    public void printGtime_table(Student student)
    {
        int cnt = 0;
        for(int i = 0; i < 2880; i ++)
        {
            if(i % 24 == 0)
            {
                cnt ++;
                System.out.print("   ");
            }
            if(i % (7 * 24) == 0)
            {
                cnt = 0;
                System.out.println();
            }
            if(i % 720 == 0)
            {
                System.out.println();
                System.out.println();
                for(int j = 0; j < cnt; j ++)
                {
                    System.out.print("                           ");
                }
            }
            System.out.print(student.getGtime_table()[i]);
        }
        System.out.println();
    }
    public void printTtime_table(Student student)
    {
        int cnt = 0;
        for(int i = 0; i < 24; i ++)
        {
            System.out.print(student.getTtime_table()[i]);
        }
        System.out.println();
    }
    public void printWeekLesson(Student student, Time now)
    {
        System.out.println("本周课程如下:");
        for(int i = 8; i <= 20; i ++)
        {
            System.out.print(String.format("%-20d", i));
        }
        System.out.println();
        int time = Time.getTime() - (Time.getTime() % (24 * 7));
        for(int j = 0; j < 7; j ++)
        {
            for(int i = 8; i < 21; i ++)
            {
                int k = student.getCtime_table()[time + i + j * 24];
                if(k == 0)
                {
                    continue;
                }
                System.out.print(String.format("%-20s", Lesson.lessonKu[k].getName()));
            }
            System.out.println();
        }
    }
    public void printTotalLesson()
    {
        for(Lesson c: Lesson.lessonKu)
        {
            if(c != null)
            {
                c.printAffair();
            }
        }
    }
    public void printClock()
    {
        for(Clock clock : Time.qu)
        {
            System.out.println(clock.getName() + ":" + clock.getTime());
        }
    }

}
