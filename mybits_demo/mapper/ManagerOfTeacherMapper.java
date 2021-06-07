package cn.zcbigdata.mybits_demo.mapper;
import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;

import java.util.List;

public interface ManagerOfTeacherMapper {

    List<ManagerOfTeacher> selectAllTeacher();

    int insertTeacher(ManagerOfTeacher teacher_info);

    int updateTeacher(ManagerOfTeacher teacher_info);

    int deleteTeacher(int id);


}
