package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Student;

import javax.servlet.http.HttpServletRequest;

public interface StudentService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Boolean login(String username, String password, HttpServletRequest request);
}
