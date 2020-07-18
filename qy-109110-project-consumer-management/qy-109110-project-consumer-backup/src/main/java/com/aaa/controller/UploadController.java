package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: qy109-second-phase-project
 * @PackageName: com.aaa.pro.controller
 * @Author： jkm
 * @Date： Create in 20:10 2020/7/14
 * @description： ftp文件上传
 */
@RestController
@Api(tags = "文件上传")
public class UploadController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/upload")
    @ApiOperation(value =  "单文件上传接口")
    public ResultData uploadFile(MultipartFile file) {
        Boolean result = iProjectService.uploadFile(file);
        if (result) {
            return super.uploadSuccess();
        }
        return super.uploadFalse();
    }

}
