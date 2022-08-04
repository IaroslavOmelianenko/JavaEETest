package com.omelianenko.javaeetest.classes;

public class PageNavigation {
    public static String getPageNavigation() {
        return "<hr align=\"left\" width=\"100\" size=\"3\" color=\"#ff9900\" /> " +
                "<p><a href=\"/test-servlet\"> [ Test Servlet ]  </a></p>" +
                "<p><a href=\"/testJsp.jsp\"> [ Test JSP ]  </a></p>" +
                "<p><a href=\"/cart\"> [ Test Cart ]  </a></p>" +
                "<p><a href=\"/get-cookies\"> [ Test Cookies ]  </a></p>" +
                "<p><a href=\"/movies\"> [ Test Data Base ]  </a></p>";
    }
}
