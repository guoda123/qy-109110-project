package com.aaa.mapper;

import com.aaa.model.ProjectInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectInfoMapper extends Mapper<ProjectInfo> {
    /**
     * @author xxx
     * @description
     *      根据项目类型进行查询
     * @DATE 2020/7/16
     * @return
    */
    List<ProjectInfo> getInfoByType(String projectType);
}