package com.aaa.utils;

import java.util.Random;

/**
 * @author xxx
 * @description
 * @DATE 2020/7/11
 * @return
*/
public class FileNameUtils {
    private FileNameUtils() {
    }

        /**
         * @author xxx
         * @description
         *      文件名生成
         * @DATE 2020/7/11
         * @return
        */

    public static String getFileName() {
        //1.获取当前系统时间的毫秒数
        long currentTimeMillis = System.currentTimeMillis();
        //2.创建随机数对象
        Random redom = new Random();
        //3.随机从0-999之间随机
        int number = redom.nextInt(999);
        //4.生成最终的文件名
        return currentTimeMillis + String.format("%03d",number);
    }
}
