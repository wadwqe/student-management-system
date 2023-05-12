package Window123;

import Stu.Student;

import javax.swing.*;

import static TotalAffair.Lesson.lessonKu;

public class Select_course {
    //通过方法Select_course()创建一个窗口
    //这个窗口由student_windows.java中的选择课程按钮触发
    //在这个窗口中，会显示由管理员添加课程后的课程库，通过遍历Lessen[]数组获取课程库中的课程信息，然后将课程信息显示在窗口中，是一个列表，每个课程都有一个选择按钮，点击之后，会弹出一个对话框，询问是否选择这门课程
    //如果选择了这门课程，那么这门课程就会被添加到学生的课程表中，通过Student类中的addCourse方法实现

    //因为需要知道是哪个学生在操作，所以需要传入一个Student类的实例
    public static void Select_course_f(Student student)
    {
        JFrame frame = new JFrame("选课界面");//创建一个窗口对象
        frame.setSize(700, 500);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        frame.setVisible(true);//设置窗口可见

        //整个窗口包含两个面板，左边面板添加列表组件，用于显示课程库中的课程信息，右边面板是学生的课表，用于显示学生已经选择的课程的信息
        JPanel panel1 = new JPanel();//创建一个面板
        frame.add(panel1);//将面板添加到窗口

        //通过遍历lessenKu[1000]数组获取课程库中的课程信息，然后将课程信息显示在左边列表中，列表的下方有选择和退选两个按钮，点击之后，会弹出一个对话框，询问是否选择、退选这门课程
        for (int i = 0; i < 1000; i++) {
            if (lessonKu[i] != null) {
                //为每个课程创建一个按钮，鼠标悬浮在按钮上时，会显示课程的详细信息，鼠标点击按钮时，会弹出一个对话框，询问是否选择这门课程
                JButton button = new JButton(lessonKu[i].getName());
                button.setToolTipText(lessonKu[i].toString());
                panel1.add(button);
                int finalI = i;
                button.addActionListener(e -> {
                    int n = JOptionPane.showConfirmDialog(null, "是否选择这门课程？", "提示", JOptionPane.YES_NO_OPTION);
                    if (n == 0) {
                        //如果选择了这门课程，那么这门课程就会被添加到学生的课程表中，通过Student类中的chooseLesson()方法实现
                        student.addAffair(lessonKu[finalI]);
                    }
                });

            }
        }
        //通过student.getClist()方法获得学生的课表，然后将课表信息显示在右边的表格中
        //右边面板是学生的课表，用于显示学生已经选择的课程的信息



//        JPanel panel1 = new JPanel();//创建一个面板
//        JPanel panel2 = new JPanel();//创建一个面板
//        frame.add(panel1);//将面板添加到窗口
//        frame.add(panel2);//将面板添加到窗口
//        frame.setVisible(true);//设置窗口可见
//        panel1.setLayout(null);//设置面板的布局为空
//        panel2.setLayout(null);//设置面板的布局为空
//        JLabel userLabel = new JLabel("欢迎"+student.getName()+"同学");//创建一个标签
//        userLabel.setBounds(10,20,200,25);//设置标签的位置和大小
//        panel1.add(userLabel);//将标签添加到面板
//        JLabel userLabel1 = new JLabel("课程库");//创建一个标签
//        userLabel1.setBounds(10,50,200,25);//设置标签的位置和大小
//        panel1.add(userLabel1);//将标签添加到面板
//        JLabel userLabel2 = new JLabel("课程表");//创建一个标签
//        userLabel2.setBounds(400,50,200,25);//设置标签的位置和大小
//        panel2.add(userLabel2);//将标签添加到面板
//        JButton button1 = new JButton("选择");//创建一个按钮
//        button1.setBounds(10,400,100,25);//设置按钮的位置和大小
//        panel1.add(button1);//将按钮添加到面板
//        JButton button2 = new JButton("退选");//创建一个按钮
//        button2.setBounds(120,400,100,25);//设置按钮的位置和大小
//        panel1.add(button2);//将按钮添加到面板



        //如果选择了这门课程，那么这门课程就会被添加到学生的课程表中，通过Student类中的student.addCourse()方法实现,如果退选了这门课程，那么这门课程就会从学生的课程表中删除，通过Student类中的student.deleteCourse()方法实现
        //并且需要进行时间冲突检测，通过Student类中的student.checkTime()方法实现



    }

}
