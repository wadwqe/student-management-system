package Window123;

import ADMINISTRATOR.Administrator;
import Stu.Student;

import javax.swing.*;

import static Stu.Student.findStudent;


public class log_in {
    //这是一个登录界面窗口，使用Swing实现
    //这个窗口的功能是管理员登录或者学生登录
    //管理员登录后可以跳转到管理员窗口
    //学生登录后可以跳转到学生窗口
    //首先一个登录窗口应该有一个用户名输入框和一个密码输入框，下面可以选择登录的身份
    //登录的身份有两种，一种是管理员，一种是学生
    //登录的时候需要检查用户名和密码是否正确，如果正确则跳转到对应的窗口
    //如果不正确则弹出一个提示框，提示用户名或密码错误
    //这个窗口的功能应该是在主窗口中调用的，所以应该有一个返回值，返回值是一个字符串
    //如果返回值是"admin"，则说明登录的是管理员
    //如果返回值是"student"，则说明登录的是学生
    //如果返回值是"error"，则说明登录失败

    public static void main(String[] args) {
        Admin admin = new Admin();
        Student_windows student_windows = new Student_windows();
        login_window(admin,student_windows);
    }

    public static void login_window(Admin admin,Student_windows student_windows) //往面板中添加组件
    {
        JFrame frame = new JFrame("登录");//创建一个窗口对象
        frame.setSize(400, 300);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        JPanel panel = new JPanel();//创建一个面板
        frame.add(panel);//将面板添加到窗口中
        frame.setVisible(true);//设置窗口可见

        panel.setLayout(null);//设置面板的布局为空
        JLabel userLabel = new JLabel("用户名:");//创建一个标签
        userLabel.setBounds(50, 50, 80, 25);//设置标签的位置和大小
        panel.add(userLabel);// 将标签添加到面板中

        JTextField userText = new JTextField(20);   //创建一个文本框
        userText.setBounds(100, 50, 165, 25);   //设置文本框的位置和大小
        panel.add(userText);    //将文本框添加到面板中

        JLabel passwordLabel = new JLabel("密码:");   //创建一个标签
        passwordLabel.setBounds(50, 100, 80, 25);   //设置标签的位置和大小
        panel.add(passwordLabel);   //将标签添加到面板中

        JPasswordField passwordText = new JPasswordField(20);   //创建一个密码输入框
        passwordText.setBounds(100, 100, 165, 25);  //设置密码输入框的位置和大小
        panel.add(passwordText);    //将密码输入框添加到面板中

        JLabel identityLabel = new JLabel("身份:");   //创建一个标签
        identityLabel.setBounds(50, 150, 80, 25);   //设置标签的位置和大小
        panel.add(identityLabel);   //将标签添加到面板中

        String[] identity = {"管理员", "学生"};  //创建一个字符串数组，用来存储身份
        JComboBox identityBox = new JComboBox(identity);    //创建一个下拉列表框
        identityBox.setBounds(100, 150, 165, 25);   //设置下拉列表框的位置和大小
        panel.add(identityBox); //将下拉列表框添加到面板中

        JButton loginButton = new JButton("登录");    //创建一个按钮
        loginButton.setBounds(150, 200, 80, 25); //设置按钮的位置和大小
        panel.add(loginButton); //将按钮添加到面板中

        JButton regButton = new JButton("注册");    //创建一个注册按钮
        regButton.setBounds(250, 200, 80, 25); //设置按钮的位置和大小
        panel.add(regButton); //将按钮添加到面板中



        loginButton.addActionListener(e -> {    //为登录按钮添加一个监听器
            String username = userText.getText();   //获取用户名
            String password = passwordText.getText();   //获取密码
            String identity1 = (String) identityBox.getSelectedItem();  //获取身份


            if (username.equals("admin") && password.equals("admin") && identity1.equals("管理员"))
            {
                JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                Administrator administrator = new Administrator();
                frame.dispose();    //关闭窗口
                    //调用admin_window()方法，跳转到管理员窗口
                admin.admin_window();
            }

            //通过调用findStudent()方法，通过username去学生库中查询，如果存在则跳转到学生窗口
            //如果不存在则弹出一个提示框，提示用户名或密码错误
            else if (findStudent(username)!=null && password.equals("student") && identity1.equals("学生"))
            {
                JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();    //关闭窗口
                //调用student_window()方法，跳转到学生窗口
                Student student = findStudent(username);
                student_windows.student_window(student);

            }


            else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误", "提示", JOptionPane.ERROR_MESSAGE);
            }



        });

        regButton.addActionListener(e -> {  //为注册按钮添加一个监听器
            //调用reg_window()方法，跳转到注册窗口
            new Register_window(admin,student_windows);
        });

    }


}



