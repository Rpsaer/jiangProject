package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.entity.ManagerOfTeacher;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.dataCheck;
import cn.zcbigdata.mybits_demo.service.ManagerOfTeacherService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/Manager")
public class ManagerOfTeacherController {
    private static Gson gson = new Gson();
    private static final Logger LOGGER = Logger.getLogger(ManagerOfTeacherController.class);

    @Autowired
    private ManagerOfTeacherService MOfTeacherService;

    //系统中所有老师信息
    @ResponseBody
    @RequestMapping(value="/selectAllTeacher", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String selectAllTeacher(HttpServletRequest request) throws Exception{
        List<ManagerOfTeacher>  teachers_info = MOfTeacherService.selectAllTeacher();
        String[] column = {"id","teacher_id","teacher_grade","teacher_lesson","teacher_name"};
        String data = gson.toJson(teachers_info);
        LOGGER.info(data);
        return data ;
    }

    //系统新添加教师信息
    @ResponseBody
    @RequestMapping(value = "insertTeacher", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String insertTeacher(String teacher_id,String teacher_name,String teacher_lesson,String teacher_grade){
        ManagerOfTeacher  teachers_info = new ManagerOfTeacher();
        try{
            teachers_info.setTeacher_id(dataCheck.check(teacher_id));
            teachers_info.setTeacher_grade(dataCheck.check(teacher_grade));
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        teachers_info.setTeacher_name(teacher_name);
        teachers_info.setTeacher_lesson(teacher_lesson);
        MOfTeacherService.insertTeacher(teachers_info);
        String data = "{\"data\":\"新教师信息插入成功\"}";
        return  data;
    }

    //更新系统中的教师信息
    @ResponseBody
    @RequestMapping(value = "updateTeacher", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String updateTeacher(String teacher_id,String teacher_name,String teacher_grade,String teacher_lesson,String id){
        ManagerOfTeacher teacher_info = new ManagerOfTeacher();
        String data = "";
        try{
            teacher_info.setId(dataCheck.check(id));
            teacher_info.setTeacher_id(dataCheck.check(teacher_id));
            teacher_info.setTeacher_grade(dataCheck.check(teacher_grade));
             data = "{\"data\":\"教师信息修改成功\"}";
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        teacher_info.setTeacher_name(teacher_name);
        teacher_info.setTeacher_lesson(teacher_lesson);
        MOfTeacherService.updateTeacher(teacher_info);
        return data;
    }

    //删除教师信息
    @ResponseBody
    @RequestMapping(value = "deleteTeacher", method = RequestMethod.POST,produces = "text/plain;charset=utf-8" )
    public String deleteTeacher(String id){
        ManagerOfTeacher teacher_info = new ManagerOfTeacher();
        try{
            teacher_info.setId(dataCheck.check(id));
        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        Integer idInteger = Integer.valueOf(id);
        int i = MOfTeacherService.deleteTeacher(idInteger);
        LOGGER.info(i);
        String data = "{\"data\":\"删除成功\"}";
        return data;
    }

}
