package com.aaa.mapper;

import com.aaa.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author xxx
 * @description
 *      项目汇交
 * @DATE 2020/7/17
 * @return
*/
public interface MappingProjectMapper extends Mapper<MappingProject> {
    /**
     * @author xxx
     * @description
     *      查询所有已提交的项目信息
     * @DATE 2020/7/17
     * @return
    */
    List<MappingProject> selectAllMappingProject();

    /**
     * @author xxx
     * @description
     *      条件查询 根据项目类型projectType 查询所有已提交项目
     * @DATE 2020/7/17
     * @return
    */
    List<MappingProject> selectAllByProjectType(String projectType);

    /**
     * @author xxx
     * @description
     *      模糊查询 查询项目名称
     * @DATE 2020/7/17
     * @return
    */
    List<MappingProject> fuzzyProjectName(@Param("projectName") String projectName,
                                          @Param("projectType") String projectType,
                                          @Param("startDate") String startDate);

}