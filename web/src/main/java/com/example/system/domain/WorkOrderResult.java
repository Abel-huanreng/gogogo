package com.example.system.domain;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author tw
 */
public class WorkOrderResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String STATUS_TAG = "status";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public WorkOrderResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public WorkOrderResult(Boolean code, String msg) {
        super.put(STATUS_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public WorkOrderResult(Boolean code, String msg, Object data) {
        super.put(STATUS_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static WorkOrderResult success() {
        return WorkOrderResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static WorkOrderResult success(Object data) {
        return WorkOrderResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static WorkOrderResult success(String msg) {
        return WorkOrderResult.success("操作成功", msg);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static WorkOrderResult success(String msg, Object data) {
        return new WorkOrderResult(true, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static WorkOrderResult error() {
        return WorkOrderResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static WorkOrderResult error(String msg) {
        return WorkOrderResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static WorkOrderResult error(String msg, Object data) {
        return new WorkOrderResult(false, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static WorkOrderResult error(Boolean code, String msg) {
        return new WorkOrderResult(code, msg, null);
    }


    public Object getData() {

        return super.get(DATA_TAG);
    }
}
