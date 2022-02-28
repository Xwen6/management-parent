package wyu.xwen.ossService.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wyu.xwen.commonutils.Result;
import wyu.xwen.ossService.service.AliyunService;

@RestController
@RequestMapping("ossService/file")
public class AliyunController {

    @Autowired
    private AliyunService aliyunService;


    @ApiOperation(value = "文件上传")
    @PostMapping("uploadUserPhoto")
    public Result uploadUserPhoto(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = aliyunService.uploadUserPhoto(file);
        //返回r对象
        return Result.ok().message("文件上传成功").date("url",uploadUrl);
    }

    @ApiOperation(value = "文件上传")
    @PostMapping("uploadCarImage")
    public Result uploadCarImag(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = aliyunService.uploadCarImag(file);
        //返回r对象
        return Result.ok().message("文件上传成功").date("url",uploadUrl);
    }

    @ApiOperation(value = "文件上传")
    @PostMapping("uploadPetImage")
    public Result uploadPetImag(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = aliyunService.uploadPetImag(file);
        //返回r对象
        return Result.ok().message("文件上传成功").date("url",uploadUrl);
    }

    @ApiOperation(value = "文件上传")
    @PostMapping("UploadCommunityThumb")
    public Result UploadCommunityThumb(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = aliyunService.UploadCommunityThumb(file);
        //返回r对象
        return Result.ok().message("文件上传成功").date("url",uploadUrl);
    }

}
