package com.yang.utils;

import java.util.Random;

/**
 * @Auther: yang
 * @Date: 2018\6\27 0027 17:47
 * @Description:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式 时间戳+随机数
     */
    public static  synchronized  String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000) + 100000;
        return  System.currentTimeMillis()+String.valueOf(number);
    }


}
