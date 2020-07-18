package com.aaa.controller;

import com.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.ProjectInfo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author xxx
 * @description
 *      项目管理
 * @DATE 2020/7/16
 * @return
*/
@RestController
@Api(tags = "项目管理")
public class ProjectManagementController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @author xxx
     * @description
     *      查询项目管理的信息
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/selectProjectInfo")
    @ApiOperation(value = "查询项目管理信息")
    public ResultData  ProjectManagement( PageInfo pageInfo){
        try {
            PageInfo<List> info = iProjectService.ProjectManagement(pageInfo);
            if (null != info){
                System.out.println("查询成功");
                return super.getSuccess(info);
            }
        }catch (Exception e){
            e.printStackTrace();
            return super.getFalse();
        }
        return super.getFalse();
    }
    /**
     * @author xxx
     * @description
     *      根据主键查询
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("/selectById")
    @ApiOperation(value = "根据主键查询项目")
    public ResultData selectProById(Long id){
        ProjectInfo manProject = iProjectService.selectById(id);
        if (!"".equals(manProject) && null != manProject){
            return super.getSuccess(manProject);
        }
        return super.getFalse();
    }
    /**
     * @author xxx
     * @description
     *      根据主键修改
     * @DATE 2020/7/16
     * @return
    */
    @PostMapping("/updateById")
    @ApiOperation(value = "根据主键修改项目")
    public ResultData updateById(ProjectInfo manProject){
        Integer integer = iProjectService.updateById(manProject);
        if (integer>0){
            return super.updateSuccess();
        }
        return super.updateFalse();
    }
    /**
     * @author xxx
     * @description
     *      根据项目类型查询
     * @DATE 2020/7/16
     * @return
    */
    @GetMapping("/getInfoByType")
    @ApiOperation(value = "根据类型查询项目")
    public ResultData<ProjectInfo> getInfoByType( String projectType) {
        List<ProjectInfo> projectInfos = null;
        try {
            // 调用 iqyService 中的 selectAllByType 方法获取数据
            projectInfos = iProjectService.getInfoByType(projectType);
            return super.getSuccess(projectInfos);
        } catch (IllegalArgumentException e) {
            // 非法参数异常
            e.printStackTrace();
            return super.getFalse();
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
    @ApiOperation(value = "新增项目")
    public ResultData<ProjectInfo> insertInfo(ProjectInfo projectInfo){
        int i = iProjectService.insertInfo(projectInfo);
        try {
            if (i>0){
                return super.insertSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
            return super.insertFalse();
        }
        return super.insertFalse();
    }

}
