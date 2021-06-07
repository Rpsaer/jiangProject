package cn.zcbigdata.mybits_demo.mapper;


import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.page;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectAll(String stu_grade);

    int insert(Teacher teacher);

    int delete(int id);

    int update(Teacher teacher);
}
