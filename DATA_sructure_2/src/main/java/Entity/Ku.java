package Entity;

import TotalAffair.Exam;
import TotalAffair.Lesson;

public class Ku {
    public Lesson[] lessonKu ;
    public Exam[] examKu ;

    public Ku(Lesson[] lessonKu, Exam[] examKu) {
        //初始化考试库和课程库
        this.lessonKu = lessonKu;
        this.examKu = examKu;
    }

    public Lesson[] getLessonKu() {
        return lessonKu;
    }
    public Exam[] getExamKu() {
        return examKu;
    }
    public void setLessonKu(Lesson[] lessonKu) {
        this.lessonKu = lessonKu;
    }
    public void setExamKu(Exam[] examKu) {
        this.examKu = examKu;
    }
}
