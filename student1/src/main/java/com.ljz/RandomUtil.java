package com.ljz;

import java.util.Random;

/**
 * @ClassName : RandomUtil
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/11  16:51
 */

public class RandomUtil {
    /**
     * 生成指定长度的字符串
     * @param length
     * @return
     */
    public static String createString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuilder.toString();
    }

    /**
     * 随机生成 1 到 100 的数
     * @return
     */
    public static int createNum(){
        Random random = new Random();
        return random.nextInt(101);
    }

    /**
     * 随机生成 male 和 female
     * @return
     */
    public static String createSex(){
        String[] str = {"male", "female"};
        Random random = new Random();
        return str[random.nextInt(2)];
    }
}
