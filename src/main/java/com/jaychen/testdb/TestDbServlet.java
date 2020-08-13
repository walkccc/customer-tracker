package com.jaychen.testdb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;

public class TestDbServlet extends javax.servlet.http.HttpServlet {
  protected void doPost(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response) {}

  protected void doGet(
      javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException {
    // setup connection variables
    final String username = "springstudent";
    final String password = "springstudent";
    final String jdbcUrl =
        "jdbc:mysql://localhost:3306/customer_tracker?useSSL=false&serverTimezone=UTC";
    final String driver = "com.mysql.jdbc.Driver";

    // try to connect to the db
    try {
      PrintWriter out = response.getWriter();
      out.println("Connecting to database: " + jdbcUrl);
      Class.forName(driver);
      Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
      out.println("SUCCESS!");
      conn.close();
    } catch (Exception exc) {
      exc.printStackTrace();
      throw new ServletException(exc);
    }
  }
}
