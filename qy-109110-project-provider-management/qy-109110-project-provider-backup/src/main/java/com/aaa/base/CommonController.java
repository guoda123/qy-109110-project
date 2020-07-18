package com.aaa.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xxx
 * @description
 * @DATE 2020/7/9
 * @return
*/
public abstract class CommonController<T> extends BaseController {

    /**
     * @author xxx
     * @description
     *      钩子函数
     *      在新增之前去执行某些操作
     * @date 2020/7/9
     * @return
    **/
    protected void beforeAdd(Map map) {
        // TODO AddMethod Before to do something
    }

    /**
     * @author xxx
     * @description
     *      钩子函数
     *      是在新增之后去执行
     *      int result = insertOrder(Order order)
     *      if(result > 0) {
     *          insertOrderDetail(OrderDetail orderDetail);
     *      }
     * @date 2020/7/9
     * @return
    **/
    protected void afterAdd(Map map) {
        // TODO AddMethod After to do something
    }

    public abstract BaseService<T> getBaseService();

    /**
     * @author xxx
     * @description
     *      通用的新增方法
     * @date 2020/7/9
     * @return
    **/
    public ResultData add(@RequestBody Map map) {
        // 因为根据咱们的封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        // 但是controller是一个Map类型
        beforeAdd(map);
        // 1.Map转实体类
        T instance = getBaseService().newInstance(map);
        // 2.通用service
        Integer addResult = getBaseService().add(instance);

        if(addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author xxx
     * @description
     *      删除操作
     * @date 2020/7/9
     * @return
    **/
    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author xxx
     * @description
     *      批量删除
     * @date 2020/7/9
     * @return
    **/
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author xxx
     * @description
     *      更新操作
     * @DATE 2020/7/10
     * @return
    */
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer update = getBaseService().update(instance);
        if (update > 0){
            return super.updateOperation();
        }
        return super.operationFailed();
    }

    //TODO:批量修改未写


    /**
     * @author xxx
     * @description
     *      查询一条数据
     * @DATE 2020/7/10
     * @return
    */
    public ResultData selectOne(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        T selectOne = getBaseService().selectOne(instance);
        if (null != selectOne && "".equals(selectOne)){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * @author xxx
     * @description
     *      查询集合，条件查询
     * @DATE 2020/7/10
     * @return
    */
    public ResultData selectList(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        List<T> list = getBaseService().selectList(instance);
        if (list.size() > 0 && list != null){
            return super.operationFailed();
        }
        return super.operationFailed();

    }
    /**
     * @author xxx
     * @description
     *      带分页不带条件查询
     * @DATE 2020/7/10
     * @return
    */
    public ResultData selectListPage(T t, Integer pageNo,Integer pageSize){
        try{
            PageInfo<T> pageInfo = getBaseService().selectListByPage(t,pageNo,pageSize);
            if (pageInfo != null && pageInfo.getPageSize()>0){
                return super.operationSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.operationFailed();
    }
}
