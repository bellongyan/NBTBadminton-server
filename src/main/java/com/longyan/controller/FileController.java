package com.longyan.controller;

import com.longyan.pojo.Result;
import com.longyan.utils.AliOssUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file, String uuid) throws Exception {
        if (file.isEmpty()) {
            return Result.error("文件上传失败");
        }

        String filename = uuid + ".jpg";

        String url = AliOssUtils.uploadFile(filename, file.getInputStream());

        return Result.success(url);
    }
}
