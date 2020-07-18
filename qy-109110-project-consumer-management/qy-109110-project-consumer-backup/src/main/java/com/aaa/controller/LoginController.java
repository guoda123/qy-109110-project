package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.IProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "登录")
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;

    /**
     * @author xxx
     * @description
     *      执行登录操作
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/doLogin")
    public ResultData doLogin(User user) {
        return projectService.doLogin(user);
    }

}
