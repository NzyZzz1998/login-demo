package com.shixi.web;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";

        if(ServletFileUpload.isMultipartContent(request)){

            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                String path = null;
                for (FileItem f: list) {
                    if (f.isFormField()){
                        System.out.println("name: " + f.getFieldName());
                        System.out.println("value: " + f.getString("UTF-8"));
                        path = "E:\\shixi\\" + f.getString("UTF-8");
                        File tmpFile = new File(path);
                        if (!tmpFile.exists()){
                            tmpFile.mkdir();
                        }
                    }else {
                        System.out.println("name: " + f.getFieldName());
                        System.out.println("文件名: " + f.getName());

                        f.write(new File(path + "\\" + f.getName()));
                    }
                }
                message = "文件上传成功！";
            } catch (Exception e) {
                message= "文件上传失败！";
                e.printStackTrace();
            }
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
