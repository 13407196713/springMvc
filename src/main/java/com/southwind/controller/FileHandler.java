package com.southwind.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request){
        if(img.getSize()>0){
            // 获取路径
            String path = request.getServletContext().getRealPath("file");

            // 获取文件名
            String name = img.getOriginalFilename();

            File file = new File(path,name);
            try {
                img.transferTo(file);
                // 保存文件上传后的文件路径
                request.setAttribute("path", "/file/"+name);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){
        List<String> files = new ArrayList<>();
        for(MultipartFile img:imgs){
            if(img.getSize()>0){
                // 获取路径
                String path = request.getServletContext().getRealPath("file");

                // 获取上传文件名
                String name = img.getOriginalFilename();

                File file = new File(path,name);
                try {
                    img.transferTo(file);
                    files.add("/file/" + name);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files",files);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name,
                         HttpServletRequest request,
                         HttpServletResponse response){
        if(name != null){
            name += ".png";
            // 获取路径
            String path = request.getServletContext().getRealPath("file");

            File file = new File(path,name);
            OutputStream outputStream = null;
            if(file.exists()){
                // 下载设置
                response.setContentType("application/forc-download");
                // 下载后的文件名字
                response.setHeader("Content-Disposition", "attachment;filename = " + name );

                try {
                    outputStream = response.getOutputStream();

                    // FileUtils：文件 转 Byte型数组
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(outputStream != null){
                        try {
                            outputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
