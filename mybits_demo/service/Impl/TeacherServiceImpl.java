package cn.zcbigdata.mybits_demo.service.Impl;


import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.page;
import cn.zcbigdata.mybits_demo.mapper.StudentMapper;

import cn.zcbigdata.mybits_demo.mapper.TeacherMapper;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    public List<Teacher> selectAll(String stu_grade){
        return this.teacherMapper.selectAll(stu_grade);
    }

    public int insert(Teacher teacher){
        return this.teacherMapper.insert(teacher);
    }

    public int delete(int id){
        return this.teacherMapper.delete(id);
    }

    public int update(Teacher teacher){
        return this.teacherMapper.update(teacher);
    }

}
