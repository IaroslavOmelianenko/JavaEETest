package com.omelianenko.javaeetest.cookies;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCookiesServlet", value = "/delete-cookies")
public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("some_id", ""); //rewriting existing cookie "some_id"
        Cookie cookie2 = new Cookie("some_name", "");
        cookie1.setMaxAge(0); //setting expired exist time, so cookie will be deleted immediately
        cookie2.setMaxAge(0);
//        cookie.setMaxAge(-1) //deleting cookie when browser is closed
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.sendRedirect("/get-cookies");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
