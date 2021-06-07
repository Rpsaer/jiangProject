package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Filepath;

import java.util.List;

public interface FilepathService {
    int insert(String filepath,String up_name,String up_time);

    List<Filepath> showFiles(String LoginUser);

    List<Filepath> showAllFiles();
}
