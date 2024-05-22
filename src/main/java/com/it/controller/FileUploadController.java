package com.it.controller;

import com.it.utils.Code;
import com.it.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;


@RestController
public class FileUploadController {

    @RequestMapping("upload")
    public Result fileLoad(@RequestPart("file") MultipartFile file) throws Exception {
        Integer code=0;
        String msg="";
        System.out.println(file);
        //设置上传的文件所存放的路径
        String path = "F:\\University\\Junior_first\\a_Web\\finalWork\\music\\src\\main\\webapp\\static\\";
        //获取上传文件的名称
        String filename = file.getOriginalFilename();
        // 文件保存的全路径
        String filePath = path + filename;
        System.out.println(filePath);
        if (!file.isEmpty()) {
            file.transferTo(new File(filePath));
            code=Code.SAVE_OK;
            msg="添加成功！";
            return new Result(msg,code,msg);
        }
        code=Code.SAVE_ERR;
        msg="数据添加失败，请重试！";
        return new Result(msg,code,msg);
    }
}
