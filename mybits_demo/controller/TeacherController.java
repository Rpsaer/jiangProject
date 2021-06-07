package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.dataCheck;
import cn.zcbigdata.mybits_demo.entity.page;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private static Gson gson = new Gson();
    private static final Logger LOGGER = Logger.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/xx")
    public String student_info(){
        LOGGER.info("Go To student_info.html");
        return "student_info";
    }
    @ResponseBody
    @RequestMapping(value="/selectAllByGrade", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String selectAllByGrade(HttpServletRequest request) throws Exception{
        HttpSession session  = request.getSession();
        String stu_grade = (String)session.getAttribute("LoginGrade");
        System.out.println(session.getAttribute("接收到的班级session："+"LoginGrade"));
        LOGGER.info(stu_grade);
        List<Teacher>  TEACHER = teacherService.selectAll(stu_grade);
        String[] column = {"id","stu_id","stu_name","stu_grade"};
        String data = gson.toJson(TEACHER);
        LOGGER.info(data);
        return data ;
    }

    @ResponseBody
    @RequestMapping(value="/insert", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String insert(String stu_id,String stu_name,String stu_grade) throws Exception{
        Teacher TEACHER =new Teacher();
        String data = "";
        try{
            TEACHER.setStu_id(dataCheck.check(stu_id));
            data = "{\"data\":\"插入成功\"}";
        }catch(Exception e){
            data = "{\"data\":"+e.getMessage()+"}";
        }
        TEACHER.setStu_name(stu_name);
        TEACHER.setStu_grade(stu_grade);
        teacherService.insert(TEACHER);
        return data ;
    }


    @ResponseBody
    @RequestMapping(value="/delete", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String delete(String id) throws Exception{
        Teacher TEACHER =new Teacher();
        LOGGER.info(id+"+++++++++++");
        String data = "";
        try{
            TEACHER.setId(dataCheck.check(id));
            data = "{\"data\":\"删除成功\"}";
        }catch(Exception e){
            data = "{\"data\":"+e.getMessage()+"}";
        }
        Integer idInteger = Integer.valueOf(id);
        teacherService.delete(idInteger);
        return data ;
    }


    @ResponseBody
    @RequestMapping(value="/update", method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public  String update(String id,String stu_id,String stu_name,String stu_grade) throws Exception{
        Teacher TEACHER =new Teacher();
        String data = "";
        try{
            TEACHER.setId(dataCheck.check(id));
            TEACHER.setStu_id(dataCheck.check(stu_id));
            data = "{\"data\":\"修改成功\"}";
        }catch(Exception e){
            data = "{\"data\":"+e.getMessage()+"}";
        }
        TEACHER.setStu_name(stu_name);
        TEACHER.setStu_grade(stu_grade);
        teacherService.update(TEACHER);
        return data ;
    }

}
