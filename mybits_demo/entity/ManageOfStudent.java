package cn.zcbigdata.mybits_demo.entity;

public class ManageOfStudent {

    private int id;
    private int stu_id;
    private String stu_name;
    private String stu_grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(String stu_grade) {
        this.stu_grade = stu_grade;
    }

    @Override
    public String toString() {
        return "ManageOfStudent{" +
                "id=" + id +
                ", stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_grade='" + stu_grade + '\'' +
                '}';
    }
}
