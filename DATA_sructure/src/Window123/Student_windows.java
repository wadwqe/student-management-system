package Window123;

import Stu.Student;

import javax.swing.*;



public class Student_windows {
    //引用包外的Student类

    //这是一个学生窗口，用于执行学生的操作，如果登录的是学生小明，则跳转到这个窗口，也就是以小明的身份登录之后，会创建一个学生实例小明，然后这个窗口下的功能都是以小明的身份执行的


    //为学生小明选择课程、设置闹钟、查看本周的日程表、添加个人活动、添加集体活动、添加临时事务、退出登陆
    //这个窗口应该有一个返回值，返回值是一个字符串


    public static void student_window(Student student) {


        JFrame frame = new JFrame("欢迎"+student.getName()+"同学");//创建一个窗口对象
        frame.setSize(400, 500);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        JPanel panel = new JPanel();//创建一个面板
        frame.add(panel);//将面板添加到窗口
        frame.setVisible(true);//设置窗口可见




        panel.setLayout(null);//设置面板的布局为空
        JLabel userLabel = new JLabel("欢迎小明同学");//创建一个标签
        userLabel.setBounds(50, 50, 80, 25);//设置标签的位置和大小
        panel.add(userLabel);// 将标签添加到面板中

        JButton button1 = new JButton("选择课程");//创建一个按钮
        button1.setBounds(50, 100, 150, 25);//设置按钮的位置和大小
        panel.add(button1);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到课程选择窗口
        button1.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button2 = new JButton("设置闹钟");//创建一个按钮
        button2.setBounds(50, 150, 150, 25);//设置按钮的位置和大小
        panel.add(button2);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到闹钟设置窗口
        button2.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button3 = new JButton("查看本周日程表");//创建一个按钮
        button3.setBounds(50, 200, 150, 25);//设置按钮的位置和大小
        panel.add(button3);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到日程表窗口
        button3.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button4 = new JButton("添加个人活动");//创建一个按钮
        button4.setBounds(200, 100, 150, 25);//设置按钮的位置和大小
        panel.add(button4);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到添加个人活动窗口
        button4.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button5 = new JButton("添加集体活动");//创建一个按钮
        button5.setBounds(200, 150, 150, 25);//设置按钮的位置和大小
        panel.add(button5);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到添加集体活动窗口
        button5.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button6 = new JButton("添加临时事务");//创建一个按钮
        button6.setBounds(200, 200, 150, 25);//设置按钮的位置和大小
        panel.add(button6);//将按钮添加到面板中
        //设置按钮的点击事件，点击之后跳转到添加临时事务窗口
        button6.addActionListener(e -> {
            //为我选择课程
            //这个按钮应该跳转到课程选择窗口

        });

        JButton button7 = new JButton("退出登录");//创建一个按钮
        button7.setBounds(125, 250, 150, 25);//设置按钮的位置和大小
        panel.add(button7);//将按钮添加到面板中


    }

}
