package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 * @description
 *      项目交汇
 * @DATE 2020/7/17
 * @return
*/
@Service
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
     * @author xxx
     * @description
     *      查询所有已提交的项目信息
     * @DATE 2020/7/17
     * @return
    */
    public List<MappingProject> selectAllMappingProject(){
        List<MappingProject> projectList = null;
        try{
            //调用mappingProjectMapper中的selectAllMappingProject方法，返回查询结果
            projectList = mappingProjectMapper.selectAllMappingProject();
        }catch (Exception e){
            e.printStackTrace();
        }
        // 判断 如果结果不为空并且结果的个数大于0，返回拿到的数据
        if (null != projectList && projectList.size() > 0) {
            // 说明查询到了结果，返回查询的数据
            return projectList;
        }else {
            // 返回null
            return null;
        }
    }

    /**
     * @author xxx
     * @description
     *      根据项目类型进行查询
     * @DATE 2020/7/17
     * @return
    */
    public List<MappingProject> selectAllByProjectType(String projectType){
        List<MappingProject> allByProjectType = null;
        try{
            //调用mappingProjectMapper中的selectAllProjectType方法获取数据
            allByProjectType = mappingProjectMapper.selectAllByProjectType(projectType);
        }catch (Exception e){
            e.printStackTrace();
        }
        //判断 如果结果不为空并且结果的个数大于0，返回数据
        if (null != allByProjectType && allByProjectType.size()>0){
            return allByProjectType;
        }else {
            return null;
        }
    }
    /**
     * @author xxx
     * @description
     *      分页查询，根据所提交的项目进行分页
     * @DATE 2020/7/17
     * @return
    */
    public PageInfo selectAllByType(MappingProject mappingProject, Integer pageNo, Integer pageSize){
        PageInfo<MappingProject> projectPageInfo = null;
        try{
            projectPageInfo = queryListByPage(mappingProject , pageNo , pageSize);
        } catch (Exception e ){
            e.printStackTrace();
        }
        if (null == projectPageInfo&&"".equals(projectPageInfo)){
            //查询结果为空，返回null
            return null;
        }else {
            return projectPageInfo;
        }
    }
    /**
     * @author xxx
     * @description
     *      分页查询方法
     * @DATE 2020/7/17
     * @return
    */
    public PageInfo<MappingProject> queryListByPage(MappingProject mappingProject, Integer pageNo, Integer pageSize){
        List<MappingProject> select = null;
        PageInfo<MappingProject> pageInfo = null;
        try{
            //设置分页，pageNo为当前页数，pageSize为每页的数据个数
            PageHelper.startPage(pageNo,pageSize);
            //使用自定义sql语句，返回查询结果
            select = mappingProjectMapper.selectAllMappingProject();
            //将查询结果进行分页
            pageInfo = new PageInfo<MappingProject>(select);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        //判断是否为空
        if (null == pageInfo &&"".equals(pageInfo)){
            //结果为空，返回null
            return null;
        }else {
            return pageInfo;
        }
    }
}
