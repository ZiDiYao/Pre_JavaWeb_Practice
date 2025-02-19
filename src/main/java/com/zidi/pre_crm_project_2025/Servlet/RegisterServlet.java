package com.zidi.pre_crm_project_2025.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    // 数据库连接信息
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rabbit_paradise?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // 获取表单数据
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                
                // 准备SQL语句
                String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password); // 注意：实际应用中应该对密码进行加密
                    pstmt.setString(3, email);
                    
                    // 执行SQL
                    int result = pstmt.executeUpdate();
                    
                    if (result > 0) {
                        out.println("{\"status\": \"success\", \"message\": \"注册成功\"}");
                    } else {
                        out.println("{\"status\": \"error\", \"message\": \"注册失败\"}");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            out.println("{\"status\": \"error\", \"message\": \"数据库驱动加载失败\"}");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("{\"status\": \"error\", \"message\": \"数据库操作失败\"}");
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }
}
