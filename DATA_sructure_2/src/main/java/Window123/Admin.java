package Window123;

import ADMINISTRATOR.Administrator;

import javax.swing.*;

import static TotalAffair.Exam.examKu;
import static TotalAffair.Lesson.lessonKu;
import static Window123.log_in.login_window;


public class Admin {
    //这是一个管理员窗口，使用Swing实现
    //以管理员身份登陆成功后跳转到这个窗口
    //这个窗口的功能提供一些按钮，可以实现对Administer类当中的方法的调用
    //一共有3个按钮居中横向排列，第一个按钮是向课程库当中添加课程，第二个按钮是公布考试安排，第三个按钮是退出登录，返回登录界面
    //第一个按钮按下后会弹出一个文本框，用来输入课程的相关信息，包括课程名称、课程时间、课程地点、课程是否线上、课程线上平台、课程线上链接，这些参数会传递给Administer类当中的addCourse方法
    //第二个按钮按下后会弹出一个文本框，用来输入考试的相关信息，包括考试名称、考试时间、考试地点、考试是否线上、考试线上平台、考试线上链接，这些参数会传递给Administer类当中的addExam方法
    //第三个按钮按下后会返回登录界面log_in
    //这个窗口的功能应该是在log_in窗口中调用的，所以应该有一个返回值，返回值是一个字符串

    //定义ku1和ku2两个变量，用来存储课程库和考试库



    public static void admin_window(Admin admin, Student_windows student_windows) {

        //定义以全局变量的形式存储课程库和考试库



        JFrame frame = new JFrame("管理员");//创建一个窗口对象
        //设置UI界面风格为IDEA风格

        frame.setSize(400, 300);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        frame.setVisible(true);//设置窗口可见
        JPanel panel = new JPanel();//创建一个面板

        frame.add(panel);//将面板添加到窗口中
        panel.setLayout(null);//设置面板的布局为空
        JButton addCourseButton = new JButton("添加课程");//创建一个按钮
        addCourseButton.setBounds(100, 50, 200, 25);//设置按钮的位置和大小
        panel.add(addCourseButton);//将按钮添加到面板中
        //这里是添加课程按钮的监听器，当按钮被按下后会执行这里的代码
        //这里的代码是弹出一个文本框，用来输入课程的相关信息，包括课程名称、课程时间、课程地点、课程是否线上、课程线上平台、课程线上链接，布局是两行三列
        //这些参数会传递给Administer类当中的addCourse方法
        addCourseButton.addActionListener(e -> {
            JTextField courseName = new JTextField(20);//创建一个文本框，用来输入课程名称
            JTextField courseStarTime = new JTextField(20);
            JTextField courseEndTime = new JTextField(20);
            JTextField cycle = new JTextField(20);
            JTextField courseLocation = new JTextField(20);
            JTextField courseOnline = new JTextField(20);
            JTextField courseOnlinePlatform = new JTextField(20);
            JTextField courseOnlineLink = new JTextField(20);

            JPanel myPanel = new JPanel();//创建一个面板
            myPanel.add(new JLabel("课程名称:"));
            myPanel.add(courseName);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程开始时间:"));
            myPanel.add(courseStarTime);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程结束时间:"));
            myPanel.add(courseEndTime);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程是否线上:"));
            myPanel.add(courseOnline);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("循环周数:"));
            myPanel.add(cycle);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程地点:"));
            myPanel.add(courseLocation);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程线上平台:"));
            myPanel.add(courseOnlinePlatform);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("课程线上链接:"));
            myPanel.add(courseOnlineLink);

            //修改布局为两行4列
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));


            //这里是弹出一个对话框，用来输入课程的相关信息，包括课程名称、课程时间、课程地点、课程是否线上、课程线上平台、课程线上链接，布局是两行三列
            int result = JOptionPane.showConfirmDialog(null, myPanel, "请输入课程信息", JOptionPane.OK_CANCEL_OPTION);//JOptionPane.OK_CANCEL_OPTION表示对话框有一个确定按钮和一个取消按钮
            //当点击对话框的确定按钮后，会执行这里的代码
            if (result == JOptionPane.OK_OPTION) //当点击对话框的确定按钮后，会执行这里的代码
            {
                String courseNameString = courseName.getText();
                String courseStarTimeText = courseStarTime.getText();
                //将String类型的课程开始时间转换为int类型
                int courseStarTimeInt = Integer.parseInt(courseStarTimeText);

                String courseEndTimeString = courseEndTime.getText();
                //将String类型的课程结束时间转换为int类型
                int courseEndTimeInt = Integer.parseInt(courseEndTimeString);
                String cycleString = cycle.getText();
                //将String类型的循环周数转换为int类型
                int cycleInt = Integer.parseInt(cycleString);

                String courseLocationString = courseLocation.getText();
                int courseLocationInt = Integer.parseInt(courseLocation.getText());


                String courseOnlineString = courseOnline.getText();
                Boolean courseOnlineBoolean = Boolean.parseBoolean(courseOnlineString);

                String courseOnlinePlatformString = courseOnlinePlatform.getText();
                String courseOnlineLinkString = courseOnlineLink.getText();
                //将输入的课程信息传递给Administer类当中的addCourse方法
                lessonKu = Administrator.addLesson(courseNameString, courseStarTimeInt, courseEndTimeInt, cycleInt, courseLocationInt, courseOnlineBoolean, courseOnlinePlatformString, courseOnlineLinkString);

            }
        });


        JButton addExamButton = new JButton("公布考试安排");//创建一个按钮
        addExamButton.setBounds(100, 100, 200, 25);//设置按钮的位置和大小
        panel.add(addExamButton);//将按钮添加到面板中
        //这里是公布考试安排按钮的监听器，当按钮被按下后会执行这里的代码
        //这里的代码是弹出一个文本框，用来输入考试的相关信息，包括考试名称、考试时间、考试地点、考试是否线上、考试线上平台、考试线上链接，布局是两行三列
        //这些参数会传递给Administer类当中的addExam方法
        addExamButton.addActionListener(e -> {
            JTextField examName = new JTextField(20);
            JTextField examStarTime = new JTextField(20);
            JTextField examEndTime = new JTextField(20);
            JTextField examLocation = new JTextField(20);
            JTextField examOnline = new JTextField(20);
            JTextField examOnlinePlatform = new JTextField(20);
            JTextField examOnlineLink = new JTextField(20);

            JPanel myPanel = new JPanel();//创建一个面板
            myPanel.add(new JLabel("考试名称:"));
            myPanel.add(examName);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试开始时间:"));
            myPanel.add(examStarTime);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试结束时间:"));
            myPanel.add(examEndTime);

            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试地点:"));
            myPanel.add(examLocation);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试是否线上:"));
            myPanel.add(examOnline);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试线上平台:"));
            myPanel.add(examOnlinePlatform);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("考试线上链接:"));
            myPanel.add(examOnlineLink);
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            int result = JOptionPane.showConfirmDialog(null, myPanel, "请输入考试信息", JOptionPane.OK_CANCEL_OPTION);//
            if (result == JOptionPane.OK_OPTION)
            {
                String examNameString = examName.getText();
                String examStarTimeString = examStarTime.getText();
                int examStarTimeInt = Integer.parseInt(examStarTimeString);
                String examEndTimeString = examEndTime.getText();
                int examEndTimeInt = Integer.parseInt(examEndTimeString);
                String examLocationString = examLocation.getText();
                int examLocationInt = Integer.parseInt(examLocationString);
                String examOnlineString = examOnline.getText();
                boolean examOnlineBoolean = Boolean.parseBoolean(examOnlineString);
                String examOnlinePlatformString = examOnlinePlatform.getText();
                String examOnlineLinkString = examOnlineLink.getText();
                examKu= Administrator.addExam(examNameString, examStarTimeInt, examEndTimeInt, examLocationInt, examOnlineBoolean, examOnlinePlatformString, examOnlineLinkString);

            }
        });

        JButton exitButton = new JButton("退出登录");//创建一个按钮
        exitButton.setBounds(100, 150, 200, 25);//设置按钮的位置和大小
        panel.add(exitButton);//将按钮添加到面板中
        //这里是退出登录按钮的监听器，当按钮被按下后会执行这里的代码
        //这里的代码是弹出一个确认框，确认是否退出登录
        exitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "确认退出登录？", "确认框", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION)
            {

                frame.dispose();

                login_window(admin,student_windows);

            }
        });


    }

}
