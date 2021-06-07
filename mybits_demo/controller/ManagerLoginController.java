package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.service.ManagerLoginService;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录页面
 */
@Controller
public class ManagerLoginController {

    private static final Logger LOGGER = Logger.getLogger(ManagerLoginController.class);

    @Autowired
    private ManagerLoginService managerLoginService;


    @RequestMapping("Managerlogin")
    public String Managerlogin(){
        LOGGER.info("Go to Managerlogin.html");
        return "Managerlogin";
    }

    /**
     *跳转到管理员下学生信息页面
     *
     */
    @RequestMapping("/Manager_student_info")
    public String Manager_student_info(){
        LOGGER.info("Go To Manager_student_info.html");
        return "Manager_student_info";
    }
    /**
     *跳转到管理员下教师信息页面
     *
     */
    @RequestMapping("/Manager_teacher_info")
    public String Manager_teacher_info(){
        LOGGER.info("Go To Manager_teacher_info.html");
        return "Manager_teacher_info";
    }

    /**
     *跳转到管理员下课件管理页面
     *
     */
    @RequestMapping("/Manager_content")
    public String Manager_content(){
        LOGGER.info("Go To Manager_content.html");
        return "Manager_content";
    }



    @RequestMapping(value="/ManagerLogin", method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String ManagerLogin(HttpServletRequest request, Model model){
        String userName = request.getParameter("account");
        String password = request.getParameter("password");
        LOGGER.info("forLogin接收参数"+" " +userName+" "+password);
        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)){
            if (managerLoginService.login(userName,password,request)){
                LOGGER.info("登录成功");
                return "Managerback";
            }else {
                LOGGER.info("登录失败");
                model.addAttribute("message","登录失败，无此用户");
            }
        }else {
            LOGGER.info("输入参数为空");
            model.addAttribute("message","输入为空");
        }
        return "err";
    }

}
