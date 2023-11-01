package com.app.playground.controller;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/file/*")
public class FileController {

//    파일 업로드
//    @PostMapping("upload")
//    @ResponseBody
//    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
//        log.info("들어옴");
//        String rootPath = "C:/upload/" + getPath();
//        List<String> uuids = new ArrayList<>();
//        File file = new File(rootPath);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//
//        for(int i=0; i<uploadFiles.size(); i++){
//            uuids.add(UUID.randomUUID().toString());
//            uploadFiles.get(i).transferTo(new File(rootPath, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
//            if(uploadFiles.get(i).getContentType().startsWith("image")){
//                FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
//                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
//                out.close();
//            }
//        }
//        return uuids;
//    }

    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("uploadFiles") List<MultipartFile> uploadFiles) throws IOException {
        log.info(uploadFiles.toString());
        String rootPath = "/usr/upload/" + getPath();
        List<String> uuids = new ArrayList<>();
        File file = new File(rootPath);
        if(!file.exists()){
            file.mkdirs();
        }

        for(int i=0; i<uploadFiles.size(); i++){
            uuids.add(UUID.randomUUID().toString());
            uploadFiles.get(i).transferTo(new File(rootPath, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
            if(uploadFiles.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(rootPath, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
                out.close();
            }
        }

        return uuids;
    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("/usr/upload", fileName));
    }

    private String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
