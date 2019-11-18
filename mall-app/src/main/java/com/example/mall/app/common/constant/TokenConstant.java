package com.example.mall.app.common.constant;

/**
 * @author
 * @date
 */
public abstract class TokenConstant {

    /**
     * OAUTH密码
     */
    public final static String OAUTH_SECRET = "BeetleMeeting123";


    /**
     * 4天过期
     * OAUTH过期时间
     */
    public final static int OAUTH_EXPIRES_SECONDS = 7200 * 12 * 4;


    /**
     * OAUTH用户标识
     */
    public final static String OAUTH_TOKEN_ID = "tokenId";


    /**
     * OAUTH用户Id
     */
    public final static String OAUTH_USER_ID = "userId";

    /**
     * 保存到HttpServletRequest#setAttribute
     */
    public final static String ATTR_TOKEN_ID = TokenConstant.class.getName() + ".tokenId";

    /**
     * 保存到HttpServletRequest#setAttribute
     */
    public final static String ATTR_USER_CLAIM = TokenConstant.class.getName() + ".claim";


    /**
     * 管理平台密码
     */
    public final static String OAUTH_PLATFORM_SECRET = "BeetleMeetingPlatform123";


    /**
     * 4天过期
     * 管理平台OAUTH过期时间
     */
    public final static int OAUTH_PLATFORM_EXPIRES_SECONDS = 7200 * 12 * 4;


    /**
     * 管理平台OAUTH用户标识
     */
    public final static String OAUTH_PLATFORM_TOKEN_ID = "platformTokenId";


    /**
     * 管理平台OAUTH用户Id
     */
    public final static String OAUTH_PLATFORM_USER_ID = "platformUserId";

    /**
     * 保存到HttpServletRequest#setAttribute
     */
    public final static String ATTR_PLATFORM_TOKEN_ID = TokenConstant.class.getName() + ".platform.tokenId";

    /**
     * 保存到HttpServletRequest#setAttribute
     */
    public final static String ATTR_PLATFORM_USER_CLAIM = TokenConstant.class.getName() + ".platform.claim";


}
