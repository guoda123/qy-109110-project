package com.aaa.service;

import com.aaa.mapper.ProjectInfoMapper;
import com.aaa.model.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ManagementService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;
    /**
     * @author xxx
     * @description
     *      查询(项目管理)
     * @DATE 2020/7/16
     * @return
    */
    public List<ProjectInfo> SelectInfo(){
        List<ProjectInfo> list = new ArrayList();
        try {
            list = projectInfoMapper.selectAll();
            if (list.size()>0){
                return list;
            }else {
                System.out.println("数据库没信息");
            }
        }catch (Exception e){
            System.out.println("系统维护中");
        }
    return list;
    }
    /**
     * @author xxx
     * @description
     *      新增(项目管理)
     * @DATE 2020/7/16
     * @return
    */
    public ProjectInfo selectById(Long id){
        try {
            if (!"".equals(id)){
                //根据id获取项目信息
                ProjectInfo manProject = projectInfoMapper.selectByPrimaryKey(id);
                //判断是否存在该项目
                if (!"".equals(manProject) && null != manProject){
                    return manProject;
                }else {
                    return null;
                }
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
     *      修改(项目管理)
     * @DATE 2020/7/16
     * @return
    */
    public Integer updateById(ProjectInfo manProject){

        int i = 0;
        try {

            if (!"".equals(manProject)){
                //执行修改的方法 返回受影响的行数
                i = projectInfoMapper.updateByPrimaryKey(manProject);
                //判断受影响的行数
                if (i>0){
                    return i;
                }else {
                    //再次执行修改操作
                    int j = projectInfoMapper.updateByPrimaryKey(manProject);
                    if (j>0){
                        return j;
                    }
                }
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
     *      根据项目类型查询
     * @DATE 2020/7/16
     * @return
    */
    public List<ProjectInfo> getInfoByType(String projectType) {
        List<ProjectInfo> list = null;
        try {
            list = projectInfoMapper.getInfoByType(projectType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != list && list.size() > 0) {
            return list;
        }else {
            return null;
        }
    }
    /**
     * @author xxx
     * @description
     *      新增项目
     * @DATE 2020/7/16
     * @return
    */
    public int insertInfo(ProjectInfo projectInfo) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 19 ;i++){
            buffer.append(random.nextInt(10));
        }
        Long id =Long.parseLong(String.valueOf(buffer));
        projectInfo.setId(id);
        try {
            int i  = projectInfoMapper.insert(projectInfo);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
