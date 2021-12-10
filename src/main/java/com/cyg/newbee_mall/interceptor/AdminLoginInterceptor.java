package com.cyg.newbee_mall.interceptor;

import com.cyg.newbee_mall.pojo.AdminUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CuiYuangeng
 * @create 2021-12-09-11:10
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        String uri = request.getRequestURI();
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (uri.startsWith("/admin") && loginUser == null) {
            request.getSession().setAttribute("errorMsg", "请登录");
            System.out.println("已拦截");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            System.out.println("放行");
            return true;
        }
    }
}
