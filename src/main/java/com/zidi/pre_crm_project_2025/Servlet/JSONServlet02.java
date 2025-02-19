package com.zidi.pre_crm_project_2025.Servlet;

import com.zidi.pre_crm_project_2025.domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/JSONServlet")
public class JSONServlet02 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        System.out.println("进入到 JSON SERVLET02");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // create new student
        Student s1 = new Student("A0001","zs",23);
        Student s2 = new Student("A0002","zidi",24);
        // Jackson
        // {"str1":"aaa","str2":"bbb"}
        String str = "{\"str1\":\"aaa\",\"str2\":\"bbb\"}";
        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();

    }

}
