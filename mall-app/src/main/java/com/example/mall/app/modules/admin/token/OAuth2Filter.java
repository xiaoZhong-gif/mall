package com.example.mall.app.modules.admin.token;


import com.example.mall.app.common.constant.TokenConstant;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * oauth2过滤器
 */
public class OAuth2Filter extends AuthenticatingFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        executeLogin(request, response);
        return true;
    }


    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String tokenId = (String) request.getAttribute(TokenConstant.ATTR_TOKEN_ID);
        return new OAuth2Token(tokenId);
    }


}
