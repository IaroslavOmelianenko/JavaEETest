package com.omelianenko.javaeetest;

import com.omelianenko.javaeetest.classes.PageNavigation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/test-servlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();

        HttpSession session = request.getSession(); //getting session object for the current request

        //Session counter
        Integer count = (Integer) session.getAttribute("count"); //will be null for the first visit
        if(count == null){
            session.setAttribute("count", 1); //add new attribute for this session
            count = 1;
        }
        else
            session.setAttribute("count", count +1);


        //Request parameters
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");


        printWriter.println("<html>");
        printWriter.println("<h1> Test Servlet </h1>");
        if (name == null & surname == null){
            printWriter.println("<p>Hello!</p>");
            printWriter.println("<p><b><i> Your request body is empty, so i dont know your name and surname </i></b></p>");
            printWriter.println("<p>Fill the request body with \"name\" and \"surname\" to test this servlet</p>");
            printWriter.println("<p>for e.g.: <b>?name=James&surname=Hetfield</b> </p>");
        }
        else printWriter.println("Hello, " + name + " " + surname);

        //counter
        printWriter.println("<hr align=\"left\" width=\"100\" size=\"3\" color=\"#ff9900\" />");
        printWriter.println("<p><h3> Your session counter value is: " + count +" </h3></p>");
        printWriter.println("<p><i> Refresh this page to increment the counter value </i></p>");
        printWriter.println(PageNavigation.getPageNavigation());
        printWriter.println("</html>");


        //redirect
        //response.sendRedirect("/testJsp.jsp");

        //forward
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/testJsp.jsp");
        //requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
