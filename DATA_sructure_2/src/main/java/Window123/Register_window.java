package Window123;

import Stu.Student;

import javax.swing.*;


public class Register_window {
    //通过方法Register_window()创建一个窗口
    //这个窗口由Log_in.java中的注册按钮触发
    //在这个窗口中，会显示一个注册表单，包括名字、密码、地址等信息
    //注册成功之后，会弹出一个对话框，提示注册成功，然后调用Student类中的构造方法，创建一个学生对象，将学生对象添加到学生数组中
    //退回到登录界面，然后调用Log_in类中的登录方法，登录
    public Register_window(Admin admin,Student_windows student_windows)
    {
        JFrame frame = new JFrame("注册");//创建一个窗口对象
        frame.setSize(400, 300);//设置窗口的大小
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的时候退出程序
        JPanel panel = new JPanel();//创建一个面板
        frame.add(panel);//将面板添加到窗口中
        frame.setVisible(true);//设置窗口可见
        panel.setLayout(null);//设置面板的布局为空

        JLabel userLabel = new JLabel("用户名:");//创建一个标签
        userLabel.setBounds(10,20,80,25);//设置标签的位置和大小
        panel.add(userLabel);// 将标签添加到面板中
        JTextField userText = new JTextField(20);//创建一个文本框，用于输入用户名
        userText.setBounds(100,20,165,25);//设置文本框的位置和大小
        panel.add(userText);//将文本框添加到面板中

        JLabel passwordLabel = new JLabel("密码:");//创建一个标签
        passwordLabel.setBounds(10,50,80,25);//设置标签的位置和大小
        panel.add(passwordLabel);//将标签添加到面板中
        JPasswordField passwordText = new JPasswordField(20);//创建一个密码输入框
        passwordText.setBounds(100,50,165,25);//设置密码输入框的位置和大小
        panel.add(passwordText);//将密码输入框添加到面板中

        //输入地址，这里的地址是int
        JLabel addressLabel = new JLabel("地址:");//创建一个标签
        addressLabel.setBounds(10,80,80,25);//设置标签的位置和大小
        panel.add(addressLabel);//将标签添加到面板中
        JTextField addressText = new JTextField(20);//创建一个文本框，用于输入地址
        addressText.setBounds(100,80,165,25);//设置文本框的位置和大小
        panel.add(addressText);//将文本框添加到面板中
        //将输入的地址转换为int类型







        //创建一个注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.setBounds(20, 170, 80, 25);//设置按钮的位置和大小
        panel.add(registerButton);//将按钮添加到面板中
        registerButton.addActionListener(e -> {
            //注册成功之后，会弹出一个对话框，提示注册成功，然后调用Student类中的构造方法，创建一个学生对象，将学生对象添加到学生数组中
            //退回到登录界面，然后调用Log_in类中的登录方法，登录
            JOptionPane.showMessageDialog(null, "注册成功");
            frame.dispose();
            //调用Student类中的构造方法，创建一个学生对象，将学生对象添加到学生数组中
            int address = Integer.parseInt(addressText.getText());
            //int password = Integer.parseInt(passwordText.getText());

            Student student = new Student(userText.getText(),address);
            //将学生对象调用Studnet中的addStudent方法，添加到学生数组中
            student.addStudent(student);




            //调用Log_in类中的登录方法，登录
            log_in.login_window(admin,student_windows);
        });

    }
}
