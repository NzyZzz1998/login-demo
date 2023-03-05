package com.shixi.web;

import com.shixi.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/fileListServlet")
public class FileListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //文件目录
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        User u = (User) user;
        String path = "E:\\shixi\\" + u.getUsername();
        //文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        listfile(new File(path),fileNameMap);
        //显示
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/listfile.jsp").forward(request, response);
    }

    public void listfile(File file,Map<String,String> map){
        //file是一个目录
        if(!file.isFile()){
            File files[] = file.listFiles();
            for(File f : files){
                listfile(f,map);
            }
        }else{
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            map.put(file.getName(), realName);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
