package com.shixi.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问资源路径
        String[] urls = {"/login.jsp","/loginServlet","/register.jsp","/registerServlet"};
        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //判断
        for (String u : urls) {
            if(url.contains(u)){
                chain.doFilter(request, response);

                return;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if(user != null){
            //放行
            chain.doFilter(request, response);
        }else {
            // 跳转到登录页面
            req.setAttribute("login_msg","您尚未登陆！");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
