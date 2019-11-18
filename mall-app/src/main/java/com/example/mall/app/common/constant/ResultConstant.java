package com.example.mall.app.common.constant;

/**
 * @author
 * 全局返回状态代码自定
 * @author
 * @date
 */
public final class ResultConstant {

    public ResultConstant() {

    }

    /**
     * 业务全局返回码
     * 50XX
     */
    @SuppressWarnings("AlibabaClassNamingShouldBeCamel")
    public static class B {

    }

    /***
     * 系统级别返回码
     * 90xx系统出错码
     * 91xxToken相关
     */
    @SuppressWarnings("AlibabaClassNamingShouldBeCamel")
    public static class S {


        /**
         * 全局成功
         */
        public static final int SUCCESS = 0;


        /**
         * 全局异常
         */
        public static final int EXCEPTION_UNKNOWN = 9000;


        /**
         * 权限异常
         */
        public static final int EXCEPTION_AUTHORIZATION = 9001;

        /**
         * 参数异常
         */
        public static final int EXCEPTION_PARAM = 9002;


        /**
         * token为空
         */
        public static final int TOKEN_ERROR_EMPTY = 9105;

        /**
         * token过期
         */
        public static final int TOKEN_ERROR_EXPIRES = 9106;

        /**
         * tokenId不存在
         */
        public static final int TOKEN_ERROR_OPEN_ID_EMPTY = 9107;

        /**
         * userId不存在
         */
        public static final int TOKEN_ERROR_USER_ID_EMPTY = 9108;

        /**
         * token非法
         */
        public static final int TOKEN_ERROR_ILLEGAL = 9109;


    }

}
