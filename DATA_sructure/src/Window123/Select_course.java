package Window123;

import TotalAffair.Lesson;

import javax.swing.*;

public class Select_course {
    //通过方法Select_course()创建一个窗口
    //这个窗口由student_windows.java中的选择课程按钮触发
    //在这个窗口中，会显示由管理员添加课程后的课程库，通过遍历Lessen[]数组获取课程库中的课程信息，然后将课程信息显示在窗口中，是一个列表，每个课程都有一个选择按钮，点击之后，会弹出一个对话框，询问是否选择这门课程
    //如果选择了这门课程，那么这门课程就会被添加到学生的课程表中，通过Student类中的addCourse方法实现
    public Select_course(Lesson English)
    {
        JFrame frame = new JFrame("选课");//创建一个窗口对象
        frame.setSize(400, 500);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        JPanel panel = new JPanel();//创建一个面板
        frame.add(panel);//将面板添加到窗口中
        placeComponents(panel,frame,English);//往面板中添加组件
        frame.setVisible(true);//设置窗口可见
        //通过遍历Lessen[]数组获取课程库中的课程信息，然后将课程信息显示在窗口中，是一个列表，每个课程都有一个选择按钮，点击之后，会弹出一个对话框，询问是否选择这门课程
        //如果选择了这门课程，那么这门课程就会被添加到学生的课程表中，通过Student类中的addCourse方法实现


    }
    private static void placeComponents(JPanel panel,JFrame frame,Lesson English) //往面板中添加组件
    {

    }
}
