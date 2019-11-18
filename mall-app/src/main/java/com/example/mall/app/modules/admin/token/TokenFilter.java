package com.example.mall.app.modules.admin.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.mall.app.common.constant.ResultConstant;
import com.example.mall.app.common.constant.TokenConstant;
import com.example.mall.app.common.result.R;
import com.example.mall.app.service.CacheOperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 *
 */
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    CacheOperationService cacheOperationService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        R r = vidToken(request);
        if (r.getCode() > 0) {
            writeError(request, response, r);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    /**
     * @param request
     * @return
     */
    private R vidToken(HttpServletRequest request) {
        String token = getRequestValue(request, "token");
        if (StringUtils.isBlank(token)) {
            return R.error(ResultConstant.S.TOKEN_ERROR_EMPTY, "token为空");
        }

        //检查Token是否正确
        String openId = null;
        String userId = null;
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(TokenConstant.OAUTH_SECRET)).build().verify(token);
            if (decodedJWT.getExpiresAt().before(new Date())) {
                return R.error(ResultConstant.S.TOKEN_ERROR_EXPIRES, "token过期");
            }
            openId = decodedJWT.getClaim(TokenConstant.OAUTH_TOKEN_ID).asString();
            if (StringUtils.isBlank(openId)) {
                return R.error(ResultConstant.S.TOKEN_ERROR_OPEN_ID_EMPTY, "token非法");
            }
            userId = decodedJWT.getClaim(TokenConstant.OAUTH_USER_ID).asString();
            if (StringUtils.isBlank(userId)) {
                return R.error(ResultConstant.S.TOKEN_ERROR_USER_ID_EMPTY, "token非法");
            }
        } catch (Exception ex) {
            return R.error(ResultConstant.S.TOKEN_ERROR_ILLEGAL, "token非法");
        }

        //redis 是否过期
        if (!cacheOperationService.hasToken(openId)) {
            return R.error(ResultConstant.S.TOKEN_ERROR_EXPIRES, "token过期");
        }

        //把openId保存到request中
        request.setAttribute(TokenConstant.ATTR_TOKEN_ID, openId);

        return R.ok(null);
    }

    /**
     * @param request
     * @param response
     * @param code
     */
    private void writeError(HttpServletRequest request, HttpServletResponse response, R code) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json;charset=UTF-8");
        String json = objectMapper.writeValueAsString(code);
        response.getWriter().print(json);
    }

    /**
     * 获取请求的token
     */
    private String getRequestValue(HttpServletRequest httpRequest, String key) {
        //从header中获取token
        String value = httpRequest.getHeader(key);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(value)) {
            value = httpRequest.getParameter("__" + key);
        }
        return value;
    }

}
