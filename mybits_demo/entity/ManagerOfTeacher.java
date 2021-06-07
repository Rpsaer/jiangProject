package cn.zcbigdata.mybits_demo.entity;

public class ManagerOfTeacher {
    private int id;
    private int teacher_id;
    private int teacher_grade;
    private String teacher_lesson;
    private String teacher_name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_lesson() {
        return teacher_lesson;
    }

    public void setTeacher_lesson(String teacher_lesson) {
        this.teacher_lesson = teacher_lesson;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getTeacher_grade() {
        return teacher_grade;
    }

    public void setTeacher_grade(int teacher_grade) {
        this.teacher_grade = teacher_grade;
    }

    @Override
    public String toString() {
        return "ManagerOfTeacherController{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", teacher_grade=" + teacher_grade +
                ", teacher_lesson='" + teacher_lesson + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                '}';
    }
}
