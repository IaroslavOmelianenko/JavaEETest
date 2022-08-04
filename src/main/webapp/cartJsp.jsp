<%--
  Created by IntelliJ IDEA.
  User: Yara
  Date: 27.07.2022
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <%@ page import="com.omelianenko.javaeetest.classes.Cart" %>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p> Product: <%= cart.getProduct() %> </p>
    <p> Quantity: <%= cart.getQuantity() %> </p>
    <hr align="left" width="100" size="3" color="#ff9900" />
    <p><a href="/cart"> [ Back to Cart Servlet ]  </a></p>
</body>
</html>
