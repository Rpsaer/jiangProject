package cn.zcbigdata.mybits_demo.mapper;
import cn.zcbigdata.mybits_demo.entity.ManageOfStudent;
import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;

import java.util.List;

public interface ManagerOfStudentMapper {

    List<ManageOfStudent> selectAllStudent();

    int insertStudent(ManageOfStudent student_info);

    int deleteStudent(int stu_id);

    int updateStudent(ManageOfStudent student_info);


}
