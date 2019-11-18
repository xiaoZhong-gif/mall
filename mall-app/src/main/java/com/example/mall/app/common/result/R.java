package com.example.mall.app.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回数据
 */
@NoArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    private int code;

    @Getter
    private String msg;

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return
     */
    public static <T> R<T> error() {
        return result(59000, "未知异常，请联系管理员", null);
    }

    /**
     * @param code
     * @param msg
     * @return
     */
    public static <T> R<T> error(int code, String msg) {
        return result(code, msg, null);
    }

    /**
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T> R<T> result(int code, String msg, T data) {
        return new R(code, msg, data);
    }

    /**
     * @param data
     * @return
     */
    public static <T> R<T> ok(String msg, T data) {
        return result(0, msg, data);
    }

    /**
     * @param data
     * @return
     */
    public static <T> R<T> ok(T data) {
        return result(0, "", data);
    }

    /**
     * @return
     */
    public static <T> R<T> ok() {
        return result(0, "", null);
    }
}
