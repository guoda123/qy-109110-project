package com.aaa.utils;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author xxx
 * @description
 *      json转换工具类
 * @DATE 2020/7/11
 * @return
*/
public class JSONUtils {
    //1. 定义私有静态常亮ObjectMapper
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    /**
     * @author xxx
     * @description
     *      把对象转换为json字符串
     * @DATE 2020/7/11
     * @return
    */
    public static String toJsonString(Object object){
        try{
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @author xxx
     * @description
     *      把json转换为指定的对象
     * @DATE 2020/7/11
     * @return
    */
    public static <T> T toObject(String jsonData,Class<T> beanType){
        try{
            T t = OBJECT_MAPPER.readValue(jsonData,beanType);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @author xxx
     * @description
     *      把json转换为list集合
     * @DATE 2020/7/11
     * @return
    */
    public static <T> T toList(String jsonData,Class<T> beanType){
        //1.为list集合添加一个指定的泛型
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class,beanType);
        try{
            List<T> list = OBJECT_MAPPER.readValue(jsonData,javaType);
            return (T) list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
