package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.ManagerLogin;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.mapper.ManagerLoginMapper;
import cn.zcbigdata.mybits_demo.mapper.StudentMapper;
import cn.zcbigdata.mybits_demo.service.ManagerLoginService;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {

    @Autowired
    private ManagerLoginMapper managerMapper;

    @Override
    public Boolean login(String userName, String password,HttpServletRequest request) {
        ManagerLogin managerLogin = managerMapper.login(userName, password);
        if (managerLogin != null){
            HttpSession session = request.getSession();
            session.setAttribute("userid", managerLogin.getId());
            return true;
        }
        return false;
    }
}
