<%--
  Created by IntelliJ IDEA.
  User: Yara
  Date: 24.07.2022
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test JSP</title>
</head>
<body>
<h1>Test JSP</h1>
<p>
    <% String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    %>

    <%
        if(name == null & surname == null){
            out.println("Hello!");
            out.println("<p><b><i> Your request body is empty, so i dont know your name and surname </i></b></p>");
            out.println("<p>Fill the request body with \"name\" and \"surname\" to test this servlet</p>");
            out.println("<p>for e.g.: <b>?name=James&surname=Hetfield</b> </p>");
        }
        else out.println("Hello, " + name + " " + surname);
    %>

<hr align="left" width="100" size="3" color="#ff9900" />

    <%@ page import="com.omelianenko.javaeetest.classes.ImportClass" %>
    <% ImportClass ic = new ImportClass(); %>
    <% out.println("<p>"+ ic.printTextFromImportClass() + "</p>"); %>

    <%@ page import="com.omelianenko.javaeetest.classes.PageNavigation" %>
    <% out.println(PageNavigation.getPageNavigation()); %>

</body>
</html>
