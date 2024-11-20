package com.example.test;


import lombok.Data;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hejing
 * @date 2024/8/26:下午1:43
 */
@Data
public class SqlRunUtil {
    static {
        SqlRunUtil.isDebug = SqlRunUtil.isDebugMode();
    }

    private static boolean isDebug;


    private ActionEnum action;

    private StringBuilder select;

    private StringBuilder update;

    private StringBuilder delete;

    private StringBuilder count;

    private StringBuilder from;

    private StringBuilder where;

    private StringBuilder groupBy;

    private StringBuilder having;

    private StringBuilder orderBy;

    private List<Object> params = new ArrayList<>();

    /**
     * 获取一个SqlRunUtil 对象
     * @return SqlRunUtil obj;
     */
    public static SqlRunUtil getObj() {
        return new SqlRunUtil();
    }

    public void test() {
        System.out.println(isDebugMode());
    }

    /**
     * 获取程序运行是否是debug模式
     * @return boolean
     */
    public static boolean isDebugMode() {
        boolean isDebug = false;
        for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if (arg.contains("-agentlib:jdwp")) {
                isDebug = true;
                break;
            }
        }
        return isDebug;
    }

    //操作类型枚举
    private enum ActionEnum {
        ADD,
        DELETE,
        UPDATE,
        SELECT
    }

}
