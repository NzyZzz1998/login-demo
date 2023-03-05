package com.shixi.web;

import com.shixi.pojo.User;
import com.shixi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //service查询
        User user = service.login(username, password);

        if(user != null){
            if("1".equals(remember)){
                //勾选了，发送Cookie
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //存一周
                c_username.setMaxAge( 60 * 60 * 24 * 7);
                c_password.setMaxAge( 60 * 60 * 24 * 7);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            if (user.getStatus() == 1){
                String contextPath = request.getContextPath();
                request.getRequestDispatcher("/success1.jsp").forward(request,response);
            }else
            {
                String contextPath = request.getContextPath();
                request.getRequestDispatcher("/success0.jsp").forward(request,response);
            }




        }else {
            // 登录失败,
            request.setAttribute("login_msg","用户名或密码错误");
            // 跳转login
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}