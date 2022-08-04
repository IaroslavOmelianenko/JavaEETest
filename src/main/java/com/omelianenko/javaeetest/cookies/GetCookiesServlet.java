package com.omelianenko.javaeetest.cookies;

import com.omelianenko.javaeetest.classes.PageNavigation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookiesServlet", value = "/get-cookies")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies(); //receiving cookies from client

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Get Cookies Servlet</h1>");
            for (Cookie cookie : cookies) {
                if (!cookie.getName().equals("JSESSIONID")) { //ignoring JSESSIONID cookie
                    printWriter.println("<p><b>" + cookie.getName() + " " + cookie.getValue() + "</b></p>");
                }
            }
        printWriter.println("<p><a href=\"/set-cookies\"> [ Set Cookies ]  </a></p>");
        printWriter.println("<p><a href=\"/delete-cookies\"> [ Delete Cookies ]  </a></p>");
        printWriter.println(PageNavigation.getPageNavigation());
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
