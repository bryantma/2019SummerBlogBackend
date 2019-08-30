package com.shimh.controller;

import com.shimh.common.annotation.LogAnnotation;
import com.shimh.common.constant.ResultCode;
import com.shimh.common.result.Result;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);


    private String baseFolderPath = "/root/blogData/";

    @GetMapping("/root/blogData/{dir}/{fileName:.+}")
    @LogAnnotation(module = "文件下载", operation = "文件下载")
    public ResponseEntity<Resource> download(@PathVariable("dir") String dir, @PathVariable("fileName") String fileName) throws IOException {
        String pathName = baseFolderPath + dir + "/" + fileName;
        File file = new File(pathName);
        Path path = Paths.get(pathName);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }


    @PostMapping("/upload")
    @RequiresAuthentication
    @LogAnnotation(module = "文件上传", operation = "文件上传")
    public Result upload(HttpServletRequest request, MultipartFile image) {

        Result r = new Result();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        StringBuffer url = new StringBuffer();
        String filePath = baseFolderPath + sdf.format(new Date());

        File baseFolder = new File(filePath);
        if (!baseFolder.exists()) {
            boolean x = baseFolder.mkdirs();
            System.out.println("创建目录 " + baseFolder.getAbsolutePath() + " result = " + x);
        }

        url.append(request.getScheme())
                .append("://")
                .append(request.getServerName())
                .append(":")
                .append(request.getServerPort())
                .append(request.getContextPath())
                .append(filePath);

        String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");

        try {

            File dest = new File(baseFolder, imgName);
            image.transferTo(dest);
            url.append("/").append(imgName);
            r.setResultCode(ResultCode.SUCCESS);
            r.simple().put("url", url);
        } catch (IOException e) {
            logger.error("文件上传错误 , uri: {} , caused by: ", request.getRequestURI(), e);
            System.out.println("文件上传错误 , uri: {} , caused by: " + request.getRequestURI());
            r.setResultCode(ResultCode.UPLOAD_ERROR);
        }
        return r;
    }
}
