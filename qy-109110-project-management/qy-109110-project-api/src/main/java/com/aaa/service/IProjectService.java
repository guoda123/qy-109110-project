package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.LoginLog;
import com.aaa.model.MappingProject;
import com.aaa.model.ProjectInfo;
import com.aaa.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "backup-project-interface")
public interface IProjectService {

    /**
     * @author xxx
     * @description
     *      执行登录操作
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @author xxx
     * @description
     *      新增日志
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     * @author xxx
     * @description
     *      查询所有用户信息
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/selectAllUser")
    PageInfo selectAllUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * @author xxx
     * @description
     *      根据主键删除用户
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/deleteUser")
    Integer deleteUser(@RequestBody User user);

    /**
     * @author xxx
     * @description
     *      根据id批量删除用户
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/delectMoreUser")
    Integer deleteMoreUser(@RequestBody List<Object> ids);
    /**
     * @author xxx
     * @description
     *      根据id查询用户信息
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("/selectUserById")
    User selectUserById(@RequestParam("id") Long id);
    /**
     * @author xxx
     * @description
     *      根据id修改用户信息
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/updateUserById")
    Integer updateUserById(@RequestBody User user);


    /**
     * @return java.lang.Boolean
     * @Author: jkm
     * @Description: ftp文件上传
     * 因为feign默认只能发送普通类型(java8种基本类型，封装类型，集合...)
     * 这些普通类型都可以转换为二进制流的形式在http之间传输，但是文件类型不行，
     * 因为文件类型只能转换为字节流/字符流
     * 也就是说，最终我可以让PostMapping去接收Multipart/form-data类型
     * 让feign使用json的数据格式来进行接收
     * @Date: 20:49 2020/7/14
     * @param: [file]
     */
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(@RequestBody MultipartFile file);


    /**
     * @author xxx
     * @description
     *      测绘管理--项目管理--查询所有项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/selectProjectInfo")
    PageInfo ProjectManagement(@RequestBody PageInfo pageInfo);

    /**
     * @author xxx
     * @description
     *      测绘管理--项目管理--通过id查询项目项目
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("selectById")
    ProjectInfo selectById(@RequestParam("id") Long id);

    /**
     * @author xxx
     * @description
     *      测绘管理--项目管理--通过id修改项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/updateById")
    Integer updateById(@RequestBody ProjectInfo manProject);

    /**
     * @author xxx
     * @description
     *      测绘管理--项目管理--根据项目类型查询
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("/getInfoByType")
    List<ProjectInfo> getInfoByType(@RequestParam("projectType") String projectType);
    /**
     * @author xxx
     * @description
     *      测绘管理--项目管理--新增项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/insertInfo")
    int insertInfo(@RequestBody ProjectInfo projectInfo);

    /**
     * @author xxx
     * @description
     *      测绘管理--项目汇交--查询所有提交项目信息
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("/selectAll")
    List<MappingProject> selectAllProject();
    /**
     * @author xxx
     * @description
     *      测绘管理--项目汇交--条件查询 根据项目类型查询已提交项目信息
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping ("/selectAllByType")
    List<MappingProject> selectAllByType(@RequestParam(value = "projectType",required = false) String projectType);
    /**
     * @author xxx
     * @description
     *      测绘管理--项目汇交--分页查询 将所有已提交项目信息，进行分页
     * @DATE 2020/7/17
     * @return
    */
    @PostMapping("/selectALLByPage")
    PageInfo selectALLByPage(@RequestBody MappingProject mappingProject,
                             @RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);
    /**
     * @author xxx
     * @description
     *      测绘管理--项目汇交--模糊查询测绘项目名称
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("/fuzzyProjectName")
    public List<MappingProject> fuzzyProjectName(@RequestParam("projectName") String projectName,
                                                 @RequestParam("projectType") String projectType,
                                                 @RequestParam("startDate") String startDate);


}
