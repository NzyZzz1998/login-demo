package com.shixi.web;

import com.shixi.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("filename");
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        User u = (User) user;
        String path = "E:\\shixi\\" + u.getUsername() + "\\" + fileName;
        //文件路径
        File file = new File(path);
        //如文件不存在
        if(!file.exists()){
            req.setAttribute("message", "您要下载的资源已被删除！！");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
            return;
        }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_")+1);
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //文件输入流
        FileInputStream in = new FileInputStream(path);
        //创建输出流
        OutputStream out = resp.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        while((len=in.read(buffer))>0){
            out.write(buffer, 0, len);
        }
        //关闭
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
