package com.shixi.web;

import com.shixi.pojo.Product;
import com.shixi.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private ProductService service = new ProductService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String brandName = request.getParameter("brandName");
        String name = request.getParameter("name");
        String count = request.getParameter("count");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装
        Product product = new Product();
        product.setBrandName(brandName);
        product.setName(name);
        product.setCount(Integer.parseInt(count));
        product.setDescription(description);
        product.setStatus(Integer.parseInt(status));

        service.add(product);

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}