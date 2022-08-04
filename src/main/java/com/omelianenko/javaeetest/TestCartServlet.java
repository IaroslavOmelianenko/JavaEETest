package com.omelianenko.javaeetest;

import com.omelianenko.javaeetest.classes.Cart;
import com.omelianenko.javaeetest.classes.PageNavigation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestCartServlet", value = "/cart")
public class TestCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();

        HttpSession session = request.getSession(); //getting session object for the current request

        //cart
        Cart cart = (Cart) session.getAttribute("cart");

        if (request.getParameter("product") == null || request.getParameter("quantity") == null){
            printWriter.println("<html>");
            printWriter.println("<h1> Cart Servlet </h1>");
            printWriter.println("<p>Fill the request body with \"product\" and \"quantity\" to test this servlet</p>");
            printWriter.println("<p>for e.g.: <b>?product=Apple&quantity=1</b> </p>");
            printWriter.println(PageNavigation.getPageNavigation());
            printWriter.println("</html>");
        }
        else{
            String product = request.getParameter("product");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            if (cart == null) {
                cart = new Cart();
            }
            cart.setProduct(product);
            cart.setQuantity(quantity);
            session.setAttribute("cart", cart); //remember cart for this session

            printWriter.println("<html>");
            printWriter.println("<p><a href=\"/cartJsp.jsp\"> [ Show Cart ]  </a></p>");
            printWriter.println(PageNavigation.getPageNavigation());
            printWriter.println("</html>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
