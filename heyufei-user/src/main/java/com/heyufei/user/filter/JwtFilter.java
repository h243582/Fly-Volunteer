package com.heyufei.user.filter;

import io.jsonwebtoken.Claims;
import org.apache.commons.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class JwtFilter extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("User的拦截器Authorization: " + request.getHeader("Authorization"));
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && !authHeader.equals("undefined")) {
            Claims claims = jwtUtil.parseJWT(authHeader);
            System.out.println("mobile:"+claims.getId());
            System.out.println("subject:"+claims.getSubject());
            System.out.println("IssuedAt:"+claims.getIssuedAt());

            if("admin".equals(claims.get("roles"))){//如果是管理员
                request.setAttribute("admin_claims", claims);
            }
            if("user".equals(claims.get("roles"))){//如果是用户
                request.setAttribute("user_claims", claims);
            }
        }
        return true;
    }
}
