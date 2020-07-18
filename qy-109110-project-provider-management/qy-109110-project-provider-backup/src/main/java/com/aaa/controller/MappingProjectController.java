package com.aaa.controller;


import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xxx
 * @description
 *      项目交汇
 * @DATE 2020/7/17
 * @return
*/
@RestController
public class MappingProjectController {
    @Autowired
    private MappingProjectService mappingProjectService;

    /**
     * @author xxx
     * @description
     *      查询所有已提交的项目信息
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("/selectAll")
    public List<MappingProject> selectAllProject(){
        //调用mappingProjectService中的getAllMappingProject方法获取数据
        List<MappingProject> projectList = mappingProjectService.selectAllMappingProject();
        return projectList;
    }

    /**
     * @author xxx
     * @description
     *      条件查询，根据项目类型projectType，查询所有已提交的项目信息
     *          项目类型分为：基础测绘、专业测绘
     * @DATE 2020/7/17
     * @return
    */
    @GetMapping("selectByType")
    public List<MappingProject> selectAllByType(@RequestParam(value = "projectType",required = false) String projectType){
        //调用mappingProjectService中的getAllProjectType方法，得到结果
        List<MappingProject> allByType = mappingProjectService.selectAllByProjectType(projectType);
        //判断结果是否为空
        if (allByType == null){
            //结果为空，返回null
            return null;
        }else {
            return allByType;
        }
    }
    /**
     * @author xxx
     * @description
     *      分页查询，将查询的所有已提交项目信息进行分页
     * @DATE 2020/7/17
     * @return
    */
    @PostMapping("/selectAllByPage")
    public PageInfo seleceAllByPage(@RequestBody MappingProject mappingProject,
                                    @RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
        //调用mappingProjectService中的getAllByProjectType方法进行查询
        PageInfo pageInfo = mappingProjectService.selectAllByType(mappingProject,pageNo,pageSize);
        return pageInfo;
    }
}
