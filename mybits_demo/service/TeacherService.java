package cn.zcbigdata.mybits_demo.service;



import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


public interface TeacherService {



    public  List<Teacher> selectAll(String stu_grade);

    int insert(Teacher teacher);

    int delete(int id);

    int update(Teacher teacher);
}
