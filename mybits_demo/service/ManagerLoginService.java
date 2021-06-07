package cn.zcbigdata.mybits_demo.service;

import javax.servlet.http.HttpServletRequest;

public interface ManagerLoginService {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    Boolean login(String userName, String password, HttpServletRequest request);
}
