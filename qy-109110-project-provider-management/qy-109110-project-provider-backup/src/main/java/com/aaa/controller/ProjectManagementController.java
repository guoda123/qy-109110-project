package com.aaa.controller;

import com.aaa.model.ProjectInfo;
import com.aaa.service.ManagementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author xxx
 * @description
 *      项目管理
 * @DATE 2020/7/16
 * @return
*/
@RestController
public class ProjectManagementController {
    @Autowired
    private ManagementService managementService;
    /**
     * @author xxx
     * @description
     *      查看所有项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/selectProjectInfo")
    public PageInfo ProjectManagement(@RequestBody PageInfo pageInfo){
    PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<ProjectInfo> list = this.managementService.SelectInfo();
        PageInfo<ProjectInfo> info = new PageInfo(list);
        return info;
    }
    /**
     * @author xxx
     * @description
     *      通过Id查询项目
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("selectById")
    public ProjectInfo selectById(@RequestParam("id") Long id){
        try {
            ProjectInfo manProject = managementService.selectById(id);
            if (!"".equals(manProject) && null != manProject){
                return manProject;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @author xxx
     * @description
     *      通过id修改项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/updateById")
    public Integer updateById(@RequestBody ProjectInfo manProject){
        try {
            Integer integer = managementService.updateById(manProject);
            return integer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @author xxx
     * @description
     *      根据项目类型查询
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("/getInfoByType")
    public List<ProjectInfo> getInfoByType(@RequestParam("projectType") String projectType){
        List<ProjectInfo> infos = managementService.getInfoByType(projectType);
        if (infos == null){
            return null;
        }else {
            return infos;
        }
    }
    /**
     * @author xxx
     * @description
     *      新增项目
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/insertInfo")
    int insertInfo(@RequestBody ProjectInfo projectInfo){
        return managementService.insertInfo(projectInfo);
    }
}
