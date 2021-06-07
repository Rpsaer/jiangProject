package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Student;

public interface StudentMapper {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Student login(String username,String password);


}
