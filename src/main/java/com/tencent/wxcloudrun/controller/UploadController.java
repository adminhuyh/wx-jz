package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.config.RestResultData;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/xcx/upload")
public class UploadController {


    private static final String imagePath = "static//images/";

    private static final String serverName = "D:/wx-project/wx-jz/src/main/resources/";





    @PostMapping("/uploadImage")
    public RestResultData uploadImage(@RequestParam("image") MultipartFile image) {
        if (image.getSize() > 1024 * 1024 * 5) {
            return RestResultData.failed("附件大小不能大于5M");
        }
        //下面判断，图片的格式需要是jpg,jpeg,gif,png格式
        String pictureSuffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(pictureSuffix.toUpperCase())) {
            return RestResultData.failed("请选择jpg,jpeg,gif,png格式的图片");
        }
        String fileName = image.getOriginalFilename();
        fileName = ((int) Math.random() * 999) + "_" +fileName;
        String savePath = imagePath+fileName;
        try {
            File f = new File(serverName+savePath);
            image.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
            return RestResultData.failed("上传图片失败");
        }
        return RestResultData.successed(savePath);
    }

}
