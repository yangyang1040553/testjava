package com.ruoyi.common.utils.uuid;

import com.ruoyi.common.utils.DateUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.ss.formula.functions.T;

import java.time.LocalTime;

/**
 * ID生成器工具类
 *
 * @author ruoyi
 */
public class IdUtils {


    public static String getIDStr() {
        int num = RandomUtils.nextInt(0, 99999) + 100000;
        return DateUtils.dateTimeNow("yyMMddHHmmss") + num;
    }

    public static String getID12Str() {
        int num = RandomUtils.nextInt(0, 99999) + 100000;
        return DateUtils.dateTimeNow("HHmmss") + num;
    }

    public static String getIDStr(Class<?> clazz) {
        int num = RandomUtils.nextInt(0, 99999) + 100000;
        char c = clazz.getSimpleName().charAt(0);
        return c + DateUtils.dateTimeNow("yyMMddHHmmss") + num;
    }

    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }

    public static void main(String[] args) {
        System.out.println(IdUtils.getID12Str());
        System.out.println(IdUtils.getIDStr());
        System.out.println(IdUtils.getIDStr(IdUtils.class));
    }
}
