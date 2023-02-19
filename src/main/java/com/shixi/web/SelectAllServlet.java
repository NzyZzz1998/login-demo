package com.shixi.web;


import com.shixi.pojo.Product;
import com.shixi.pojo.User;
import com.shixi.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        //1. 调用BrandService完成查询
        List<Product> products = service.selectAll();

        //2. 存入request域中
        request.setAttribute("products",products);

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        User u = (User) user;

        if (u.getStatus() == 1){
            request.getRequestDispatcher("/product1.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/product0.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}