package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Filepath;
import cn.zcbigdata.mybits_demo.mapper.FilepathMapper;
import cn.zcbigdata.mybits_demo.service.FilepathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FilepathServiceImpl implements FilepathService {
    @Autowired
    private FilepathMapper filepathMapper;


    @Override
    public int insert(String filepath,String up_name,String up_time) {
        Filepath  fp = new Filepath();
        fp.setUp_name(up_name);
        fp.setUp_time(up_time);
        fp.setFilepath(filepath);
        return this.filepathMapper.insert(fp);
    }

    @Override
    public List<Filepath> showFiles(String LoginUser) {
        return this.filepathMapper.showFiles(LoginUser);
    }

    public  List<Filepath> showAllFiles(){
        return this.filepathMapper.showAllFiles();
    }
}
