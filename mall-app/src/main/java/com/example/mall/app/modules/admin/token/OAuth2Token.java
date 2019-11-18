package com.example.mall.app.modules.admin.token;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 */
public class OAuth2Token implements AuthenticationToken {

    private String tokenId;


    public OAuth2Token(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenId() {
        return tokenId;
    }


    @Override
    public String getPrincipal() {
        return tokenId;
    }

    @Override
    public Object getCredentials() {
        return "123";
    }

}
