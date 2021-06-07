package cn.zcbigdata.mybits_demo.service.Impl;


import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.mapper.ManagerOfTeacherMapper;
import cn.zcbigdata.mybits_demo.mapper.TeacherMapper;
import cn.zcbigdata.mybits_demo.service.ManagerOfTeacherService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerOfTeacherServiceImpl implements ManagerOfTeacherService {

    @Autowired
    private ManagerOfTeacherMapper MOFTeacherMapper;


    public List<ManagerOfTeacher> selectAllTeacher(){
        return this.MOFTeacherMapper.selectAllTeacher();
    }

    public int insertTeacher(ManagerOfTeacher teacher_info){
        return this.MOFTeacherMapper.insertTeacher(teacher_info);
    }

    public int updateTeacher(ManagerOfTeacher teacher_info){
        return this.MOFTeacherMapper.updateTeacher(teacher_info);
    }

    public int deleteTeacher(int id){
        return this.MOFTeacherMapper.deleteTeacher(id);
    }

}
