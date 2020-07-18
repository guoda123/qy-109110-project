package com.aaa.base;

import com.aaa.utils.Map2BeanUtils;
import com.aaa.utils.SpringContextUtils;
import com.aaa.staticproperties.OrderStatic;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public abstract class BaseService<T> {

    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper() {
        return mapper;
    }

    /**
     * @author xxx
     * @description
     *      新增数据
     * @date 2020/7/9
     * @return
    **/
    public Integer add(T t) {
        return mapper.insert(t);
    }

    /**
     * @author xxx
     * @description
     *      根据主键进行删除
     * @date 2020/7/9
     * @return
    **/
    public Integer delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * @author xxx
     * @description
     *      根据主键进行批量删除
     * @date 2020/7/9
     * @throws
    **/
    public Integer deleteByIds(List<Integer> ids) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * @author xxx
     * @description
     *      更新操作
     * @date 2020/7/9
     * @return
    **/
    public Integer update(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * @author xxx
     * @description
     *      update username = ?  from user where id in (1,2,3,4,5,6,7)
     * @date 2020/7/9
     * @throws
    **/
    public Integer batchUpdate(T t, Integer[] ids) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }

    /**
     * @author xxx
     * @description
     *      查询一条数据
     *      形参中的t所传递的数据--->主键，唯一键(username, phone number....)
     * @date 2020/7/9
     * @throws
    **/
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }


    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds) {
        return (T) selectByFileds(null, null, where, orderByFiled, null, fileds).get(0);
    }

    /**
     * @author xxx
     * @description
     *      通过条件查询一个列表
     * @date 2020/7/9
     * @throws
    **/
    public List<T> selectListByFiled(Sqls where, String orderByField, String... fields) {
        return selectByFileds(null, null, where, orderByField, null, fields);
    }

    /**
     * @author xxx
     * @description
     *      实现条件查询的分页
     * @date 2020/7/9
     * @return
    **/
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }

    /**
     * @author xxx
     * @description
     *      查询集合，条件查询
     * @date 2020/7/9
     * @return
    **/
    public List<T> selectList(T t) {
        return mapper.select(t);
    }

    /**
     * @author xxx
     * @description
     *      查询集合，分页查询
     * @date 2020/7/9
     * @return
    **/
    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * @author xxx
     * @description
     *      Map转换实体类型
     * @date 2020/7/9
     * @return
    **/
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }

    /**
     * @author xxx
     * @description
     *      实现查询通用
     * @date 2020/7/9
     * @return
    **/
    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds) {
        Example.Builder builder = null;
        if(null == fileds || fileds.length == 0) {
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if(where != null) {
            // 说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(OrderStatic.DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(OrderStatic.ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * @author xxx
     * @description
     *      获取子类泛型类型
     * @date 2020/7/9
     * @return
    **/
    public Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * @author Seven Lee
     * @description
     *      获取spring容器/获取spring的上下文
     * @date 2020/7/9
     * @return
    **/
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }
}
