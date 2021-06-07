package cn.zcbigdata.mybits_demo.mapper;


import cn.zcbigdata.mybits_demo.entity.Filepath;

import java.io.File;
import java.util.List;

public interface FilepathMapper {
    int insert(Filepath fp);

    List<Filepath> showFiles(String LoginUser);

    List<Filepath> showAllFiles();


}