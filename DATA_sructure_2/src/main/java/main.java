import Entity.Ku;
import TotalAffair.Exam;
import TotalAffair.Lesson;
import Window123.Admin;
import Window123.Student_windows;
import Window123.log_in;
import com.formdev.flatlaf.FlatDarkLaf;

public class main {

    /*Admin admin = new Admin();
    Student_windows student_windows = new Student_windows();
    login_window(admin,student_windows);*/


    public static void main(String[] args) {
        //安装idea的浅色界面风格
        FlatDarkLaf.install();
        Admin admin = new Admin();
        Student_windows student_windows = new Student_windows();
        //初始化考试库和课程库



        log_in.login_window(admin,student_windows);
    }


}
