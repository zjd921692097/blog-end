package com.blog.controller;

import com.blog.common.resultUtil.ResultEx;
import com.blog.param.UploadFileParam;
import com.blog.result.UploadFileView;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/file", name = "文件相关")
public class FileController {
    @ResponseBody
    @RequestMapping(value = "/uploadFile",method=RequestMethod.POST)
    public ResultEx uploadFile(UploadFileParam param, HttpServletRequest request) {
        ResultEx resultEx=new ResultEx();
        UploadFileView view=new UploadFileView();
        if(param.getFile()==null) {

        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        File f = new File("/tomcat/apache-tomcat-8.5.32/webapps/img/"+ fmt.format(new Date()),param.getFile().getOriginalFilename());

        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        try {
            param.getFile().transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        view.setFilePath("http://47.106.219.141:9090/img/"+fmt.format(new Date())+"/"+param.getFile().getOriginalFilename());
        resultEx.setData(view);
        System.out.print(f.getPath());

        return resultEx.makeSuccessResult();
    }

}
