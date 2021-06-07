package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.ManagerLogin;
import cn.zcbigdata.mybits_demo.entity.Student;

public interface ManagerLoginMapper {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    ManagerLogin login(String userName, String password);


}
