package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.service.StudentService;
import org.apache.catalina.session.StandardSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录页面
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private StudentService studentService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String tologin(){
        LOGGER.info("Go To login.html");
        return "login";
    }

    @RequestMapping("/content")
    public String content(){
        LOGGER.info("Go To content.html");
        return "content";
    }

    /**
     * 跳转到文件上传和下载页面
     * @return
     */
    @RequestMapping("/upload")
    public String upload(){
        LOGGER.info("Go To upload.html");
        return "upload";
    }
    /**
     *跳转到教师下学生信息页面
     *
     */
    @RequestMapping("/student_info")
    public String student_info(){
        LOGGER.info("Go To student_info.html");
        return "student_info";
    }
    /**
     *跳转到教师下话题页面
     *
     */
    @RequestMapping("/chat")
    public String chat(){
        LOGGER.info("Go To chat.html");
        return "chat";
    }
    /**
     * 登录操作
     * @param request
     * @return
     */
    @RequestMapping(value="/tologin", method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String login(HttpServletRequest request, Model model){
        String username = request.getParameter("account");
        String password = request.getParameter("password");
        String grade = request.getParameter("grade");
        LOGGER.info("tologin接收参数"+" " +username+" "+password+" " +grade);
        HttpSession session = request.getSession();
        session.setAttribute("LoginUserName",username);
        session.setAttribute("LoginGrade",grade);
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
            if (studentService.login(username,password,request)){
                LOGGER.info("登录成功");
                return "back";
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
