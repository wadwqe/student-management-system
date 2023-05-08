//import TotalAffair.Affair;
//import TotalAffair.Lesson;
//
//import java.util.*;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.*;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        Student student = new Student("xiaomin", 0);
//        Time now = new Time();
//        Affair chinese = new Lesson("chinese", 0, 1, 1, 10);  //String name, int startTime, int endTime, int place
//        Affair  english = new Lesson("english", 2, 2, 1, 10);
//        Affair  math = new  Lesson("math", 3, 4, 1,  10);
//        Affair  Physics = new  Lesson("Physics", 5, 6, 1, 10);
//        Affair  Chemistry = new  Lesson("Chemistry", 7, 8, 1, 10);
//        Affair  Biology = new  Lesson("Biology", 9, 10, 1, 10);
//        Affair  Geography = new  Lesson("Geography", 11, 12, 1,10);
//        Affair  Politics = new  Lesson("Politics", 13, 14, 2, 10);
//        student.addAffair(chinese);
//        student.addAffair(english);
//        student.addAffair(math);
//        student.addAffair(Physics);
//        student.addAffair(Chemistry);
//        student.addAffair(Biology);
//        student.addAffair(Geography);
//        student.addAffair(Politics);
////        student.TimeDetection(now);
//        // 创建一个固定大小的线程池:
//        MoveTime movetime = new MoveTime(student, now);
//        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
//        ses.scheduleAtFixedRate(movetime, 0, 1, TimeUnit.SECONDS);
//        Scanner sc = new Scanner(System.in);
//
//        // 关闭线程池:
////        ses.shutdown();
//    }
//}
//class MoveTime implements Runnable {
//    Student student;
//    Time now;
//    public MoveTime(Student student, Time now) {
//        this.student = student;
//        this.now = now;
//    }
//
//    @Override
//    public void run() {
//        try {
//            moveTime();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public synchronized void moveTime()throws InterruptedException
//    {
//        while(Main.c.equals("t"))
//        {
//            this.wait();
//        }
//            Time.addTime();
//            System.out.println("now time: " + Time.getTime() + "(输入t暂停时间)");
//            student.TimeDetection(now);
//    }
//    public synchronized void Task()throws InterruptedException
//    {
//        String c;
//        Scanner sc = new Scanner(System.in);
//        while(true)
//        {
//            c = sc.nextLine();
//            if(!"t".equals(c))
//            {
//                notifyAll();
//            }
//        }
//    }
//
//}
