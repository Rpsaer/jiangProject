package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.ManageOfStudent;
import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;

import java.util.List;


public interface ManagerOfStudentService {

    List<ManageOfStudent> selectAllStudent();

    int insertStudent(ManageOfStudent student_info);

    int deleteStudent(int stu_id);

    int updateStudent(ManageOfStudent student_info);


}
