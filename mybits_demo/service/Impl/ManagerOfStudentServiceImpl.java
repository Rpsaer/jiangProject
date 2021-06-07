package cn.zcbigdata.mybits_demo.service.Impl;


import cn.zcbigdata.mybits_demo.entity.ManageOfStudent;
import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;
import cn.zcbigdata.mybits_demo.mapper.ManagerOfStudentMapper;
import cn.zcbigdata.mybits_demo.mapper.ManagerOfTeacherMapper;
import cn.zcbigdata.mybits_demo.service.ManagerOfStudentService;
import cn.zcbigdata.mybits_demo.service.ManagerOfTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerOfStudentServiceImpl implements ManagerOfStudentService {

    @Autowired
    private ManagerOfStudentMapper MOFStudentMapper;

    public List<ManageOfStudent> selectAllStudent(){
        return this.MOFStudentMapper.selectAllStudent();
    }

    public  int insertStudent(ManageOfStudent student_info){
        return this.MOFStudentMapper.insertStudent(student_info);
    }

    public int deleteStudent(int stu_id){
        return this.MOFStudentMapper.deleteStudent(stu_id);
    }

    public int updateStudent(ManageOfStudent student_info){
        return this.MOFStudentMapper.updateStudent(student_info);
    }

}
