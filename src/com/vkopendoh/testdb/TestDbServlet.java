package com.vkopendoh.testdb;

import javax.servlet.ServletException;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

public class TestDbServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //setup connection vars
        String user = "springstudent";
        String pass = "springstudent";
        String url = "jdbc:mysql://127.0.0.1:3306/web_customer_tracker?serverTimezone=UTC";
        //get connection to db

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to db:  "+ url);
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,user,pass);

            out.println("<br><br>Connection succeful!");

            conn.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
