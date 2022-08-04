package com.omelianenko.javaeetest;

import com.omelianenko.javaeetest.classes.PageNavigation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "MoviesServlet", value = "/movies")
public class TestDataBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        //calling postgresql driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //opening db connection
        printWriter.println("<html>");
        printWriter.println("<h1> Movies Data Base </h1>");
        try {
            Connection connection = DriverManager.getConnection(
                             "jdbc:postgresql://localhost:5432/java_ee_test",
                            "postgres",
                        "postgres");
            Statement statement = connection.createStatement(); //creating request object
            ResultSet resultSet = statement.executeQuery("SELECT * FROM java_ee_test_movies");

            while (resultSet.next()){
                printWriter.println("<p>" + resultSet.getString("title") +
                        ", created by: " + resultSet.getString("creator") +
                        ", number of seasons: " + resultSet.getString("quantity") + "</p>");
            }
            statement.close(); //closing db connection

        } catch (SQLException e) {
            printWriter.println("Failed to connect to database");
            throw new RuntimeException(e);
        }
        finally {
            printWriter.println(PageNavigation.getPageNavigation());
            printWriter.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
