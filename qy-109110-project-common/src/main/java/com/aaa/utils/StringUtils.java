package com.aaa.utils;


import org.springframework.util.DigestUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/**
 * @author xxx
 * @description
 *      字符串工具类
 * @DATE 2020/7/13
 * @return
*/
public class StringUtils {
    /**
     * @author xxx
     * @description
     *      MD5
     * @DATE 2020/7/13
     * @return
    */
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    /**
     * @author xxx
     * @description
     *      杀空函数，将“null”和null对象转换为“”
     *      str 输入字符串
     * @DATE 2020/7/14
     * @return 输出字符串
    */
    public static String killNull(String str){
        String returnStr;
        if (str == null || "null".equalsIgnoreCase(str)){
            returnStr = "";
        }else {
            returnStr = str;
        }
        return returnStr;
    }
    /**
     * @author xxx
     * @description
     *      去除字符串两边的空格并处理空字符串
     * @DATE 2020/7/14
     * @return
    */
    public static String trim(String str){
        String returnStr;
        returnStr = killNull(str);
        returnStr = returnStr.trim();
        return returnStr;
    }
    /**
     * @author xxx
     * @description
     *      判断字符串是否为空
     * @DATE 2020/7/14
     * @return
    */
    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }
    /**
     * @author xxx
     * @description
     *      判断字符串是否不为空
     * @DATE 2020/7/14
     * @return
    */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    /**
     * @author xxx
     * @description
     *      获取指定长度的随机字母和数字组合
     * @DATE 2020/7/14
     * @return 指定长度的随机字母和数字组合
    */
    public static String getCharAndNum(int length){
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            //输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
             //字符串
            if ("char".equalsIgnoreCase(charOrNum)){
                //取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 :97;
                str += (char)(choice + random.nextInt(26));
            }else if (("num".equalsIgnoreCase(charOrNum))){
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }
    /**
     * @author xxx
     * @description
     *      将byte[] 数组转为base64文本
     * @DATE 2020/7/14
     * @return
    */
    public static final String byteToBase64(byte[] decByte)throws Exception{
        if (decByte == null)
            return "";
        String str = "";
        try{
            str = new sun.misc.BASE64Encoder().encodeBuffer(decByte);
        }catch (Exception e){
            str = "";
        }
        return str.replace("\r","").replace("\n","");
    }
    /**
     * @author xxx
     * @description
     *      将base64文本转换为 byte[]数组
     * @DATE 2020/7/14
     * @return
    */
    public static final byte[] base64ToByte(String str) throws Exception {
        if (str == null)
            return null;
        byte[] decByte = null;
        try {
            decByte = new sun.misc.BASE64Decoder().decodeBuffer(str);
        } catch (Exception e) {
            decByte = null;
        }
        return decByte;
    }

    /**
     * 将ErrorStack转化为String.
     */
    public static String getExceptionAsString(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
