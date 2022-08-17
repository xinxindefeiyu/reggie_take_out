package com.example.controller;

import com.example.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) throws IOException {
        //判断路径是否存在
        File dir = new File(basePath);
        log.info("dir = {}", dir);
        if(!dir.exists()) {
            log.info("dir exist = {}", dir.exists());
            dir.mkdirs();
        }
        //原始文件名
        String originFilename = file.getOriginalFilename(); //abc.jpg
        String suffix = originFilename.substring(originFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;

        //file是一个临时文件，需要转存到指定位置
        file.transferTo(new File(basePath + fileName));

        return R.success(fileName);

    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

            outputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
