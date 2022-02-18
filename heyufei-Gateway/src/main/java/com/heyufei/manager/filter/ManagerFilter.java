package com.heyufei.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String filterType() {// 过滤器类型
        return "pre";// 前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;// 优先级，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 过滤器开关，true表示开启
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        System.out.println("Zuul过滤器内容: "+url+"  方法：  "+method);



        String authHeader = (String) request.getHeader("Authorization");// 获取头信息

        if(authHeader == null && method.contains("delete")){
            rc.setSendZuulResponse(false);// 终止运行
            rc.setResponseStatusCode(401);// http状态码
            rc.setResponseBody("无权访问");
            rc.getResponse().setContentType("text/html;charset=UTF-8");
        }
//            Claims claims = jwtUtil.parseJWT(authHeader);
//            if (claims != null) {
//                String roles = (String) claims.get("roles");
//                if ("admin".equals(roles) || "user".equals(roles)) {
//                    rc.addZuulRequestHeader("Authorization", authHeader);
//                    System.out.println("token 验证通过，添加了头" + authHeader);
//                    return authHeader;
//                }
//            }

        return null;

    }
}
