package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;

import java.util.List;


public interface ManagerOfTeacherService {

    List<ManagerOfTeacher> selectAllTeacher();

    int insertTeacher(ManagerOfTeacher teacher_info);

    int updateTeacher(ManagerOfTeacher teacher_info);

    int deleteTeacher(int id);
}
