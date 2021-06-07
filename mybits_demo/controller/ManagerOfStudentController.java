package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.entity.ManageOfStudent;
import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;
import cn.zcbigdata.mybits_demo.entity.dataCheck;
import cn.zcbigdata.mybits_demo.service.ManagerOfStudentService;
import cn.zcbigdata.mybits_demo.service.ManagerOfTeacherService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/ManagerStu")
public class ManagerOfStudentController {
    private static Gson gson = new Gson();
    private static final Logger LOGGER = Logger.getLogger(ManagerOfStudentController.class);

    @Autowired
    private ManagerOfStudentService MOfStudentService;

    //系统中所有学生信息
    @ResponseBody
    @RequestMapping(value="/selectAllStudent", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String selectAllTeacher() throws Exception{
        List<ManageOfStudent>  student_info = MOfStudentService.selectAllStudent();
        String[] column = {"id","stu_id","stu_name","stu_grade"};
        String data = gson.toJson(student_info);
        LOGGER.info(data);
        return data ;
    }

    //系统新插入学生信息
    @ResponseBody
    @RequestMapping(value="/insertStudent", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String insertStudent(String stu_id,String stu_name,String stu_grade){
        ManageOfStudent student_info = new ManageOfStudent();
        try{
            student_info.setStu_id(dataCheck.check(stu_id));
        }catch(Exception e ){
            LOGGER.info(e.getMessage());
        }
        student_info.setStu_name(stu_name);
        student_info.setStu_grade(stu_grade);
        MOfStudentService.insertStudent(student_info);
        String data = "{\"data\":\"系统新插入学生信息\"}";
        return data;
    }

    //根据学号删除学生信息，包含模糊学号删除！
    @ResponseBody
    @RequestMapping(value="/deleteStudent", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String deleteStudent(String stu_id){
        ManageOfStudent student_info = new ManageOfStudent();
        try {
            student_info.setStu_id(dataCheck.check(stu_id));
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        Integer stu_idInteger = Integer.valueOf(stu_id);
        MOfStudentService.deleteStudent(stu_idInteger);
        String data = "{\"data\":\"信息删除成功\"}";
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/updateStudent", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String updateStudent(String id,String stu_id,String stu_name,String stu_grade)throws Exception{
        ManageOfStudent student_info = new ManageOfStudent();
        String data = "";
        try{
            student_info.setStu_id(dataCheck.check(stu_id));
            student_info.setId(dataCheck.check(id));
            data = "{\"data\":\"学生信息修改成功\"}";
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        student_info.setStu_name(stu_name);
        student_info.setStu_grade(stu_grade);
        MOfStudentService.updateStudent(student_info);
        return data;
    }

}
