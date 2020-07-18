package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
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
 *      项目汇交
 * @DATE 2020/7/17
 * @return
*/
@RestController
@Api(tags = "项目汇交")
public class MappingProjectController extends BaseController {
    @Autowired
    private IProjectService iqyService;

    /**
     * @author xxx
     * @description
     *      查询所有的，已提交的项目信息
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("/getAll")
    @ApiOperation(value = "查询所有已提交项目")
    public ResultData<MappingProject> getAllMapping() {
        // 调用 iqyService 中的 getAllMappingProject 方法获取数据
        List<MappingProject> allMapping = iqyService.selectAllProject();

        // 判断 结果是否为空
        if (null != allMapping && allMapping.size() > 0) {
            // 说明拿到数据，返回系统查询成功，使用系统消息、自定义返回值
            return getSuccess(allMapping);
        }else {
            // 查询失败，使用系统消息
            return getFalse();
        }
    }

    /**
     * @author xxx
     * @description
     *      条件查询，根据项目类型 projectType，查询所有的 已提交的项目信息
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("/selectAllByType")
    @ApiOperation(value = "通过projectType查询已提交项目")
    public ResultData<MappingProject> getAllByType( String projectType) {
        List<MappingProject> projectList = null;
        try {
            // 调用 iqyService 中的 selectAllByType 方法获取数据
            projectList = iqyService.selectAllByType(projectType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 判断 结果是否为空
        if (null != projectList && projectList.size() > 0) {
            // 说明拿到数据，返回系统查询成功，使用系统消息、自定义返回值
            return getSuccess(projectList);
        }else {
            // 返回提出查询失败，使用系统消息
            return getFalse();
        }
    }

    /**
     * @author xxx
     * @description
     *      分页查询方法
     * @DATE 2020/7/17
     * @return
    */
    @PostMapping("/selectALLByPage")
    @ApiOperation(value = "通过分页查询项目")
    public PageInfo selectALLByPage(MappingProject mappingProject, Integer pageNo, Integer pageSize){
        return iqyService.selectALLByPage(mappingProject,pageNo,pageSize);
    }
}
