package com.zidi.pre_crm_project_2025.Servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain; charset=UTF-8");
        System.out.println("进入到 HelloServlet");
        PrintWriter out = response.getWriter();
        out.print("Hello World!");
        out.flush();
        out.close();
    }


    public void destroy() {
        // 清理资源和连接
        try {
            // 关闭数据库连接等资源
            System.out.println("正在清理 HelloServlet 的资源...");
            // TODO: 在这里添加数据库连接池的清理代码
        } catch (Exception e) {
            System.err.println("清理资源时发生错误: " + e.getMessage());
        } finally {
            System.out.println("HelloServlet 已完全销毁");
        }
    }
}