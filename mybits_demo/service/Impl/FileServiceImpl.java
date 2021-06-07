package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Filepath;
import cn.zcbigdata.mybits_demo.mapper.FilepathMapper;
import cn.zcbigdata.mybits_demo.service.FileService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    private static final String UTF_8 = "UTF-8";

    @Autowired
    private FilepathMapper filepathMapper;

    @Value("${define.nginx.path}")
    private String nginxPath;

    /**
     * 文件上传
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    @Override
    public void saveFile(byte[] file, String filePath, String fileName,String up_name,String up_time) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //掺入到数据库
        Filepath  fp = new Filepath();
        fp.setUp_name(up_name);
        fp.setUp_time(up_time);
        fp.setFilepath(fileName);
        filepathMapper.insert(fp);
        FileOutputStream out = new FileOutputStream(filePath + fileName + up_name + up_time);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 文件下载
     * @param response
     * @param filename
     * @param model
     */
    @Override
    public void download(HttpServletResponse response, String filename, Model model) {
        //待下载文件名
        String fileName = filename;
        //设置为png格式的文件
//        response.setHeader("content-type", "image/png");
//        response.setContentType("application/octet-stream");
//        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setContentType("application/force-download");
        response.setCharacterEncoding(UTF_8);
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + URLEncoder.encode(filename));
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File("D:/uploadFile/" + fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            System.out.println("--------------------------------");
            model.addAttribute("result","下载失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
