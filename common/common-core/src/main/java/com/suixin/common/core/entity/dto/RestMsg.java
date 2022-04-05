package com.suixin.common.core.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装一个返回统一格式数据的结果集
 *
 * @author STARS
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestMsg<T> implements Serializable {

    private int code;

    private String msg;

    private T data;


    /**
     * 消息返回方法
     *
     * @param code the code
     * @param msg  the msg
     * @param data the data
     * @return result msg
     */
    public static <T> RestMsg<T> success(int code, String msg, T data) {
        return new RestMsg<>(code, msg, data);
    }

    /**
     * Fail result msg.
     *
     * @param code the code
     * @param msg  the msg
     * @param data the data
     * @return the result msg
     */
    public static <T> RestMsg<T> fail(int code, String msg, T data) {
        return new RestMsg<>(code, msg, data);
    }

    /**
     * Success result msg.
     *
     * @param data the data
     * @return the result msg
     */
    public static <T> RestMsg<T> success(T data) {
        return success(200, "操作成功", data);
    }

    /**
     * Success result msg.
     *
     * @param data the data
     * @return the result msg
     */
    public static <T> RestMsg<T> success(String msg, T data) {
        return success(200, msg, data);
    }


    /**
     * Fail result msg.
     *
     * @param msg the msg
     * @return the result msg
     */
    public static <T> RestMsg<T> fail(String msg) {
        return fail(400, msg, null);
    }

    /**
     * Fail result msg.
     *
     * @param msg  the msg
     * @param data the data
     * @return the result msg
     */
    public static <T> RestMsg<T> fail(String msg, T data) {
        return fail(400, msg, data);
    }

}
