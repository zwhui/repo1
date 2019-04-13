package com.itheima.Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/cookieTest")
public class cookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("test/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if(cookies == null && cookies.length == 0){
            Cookie lastCookie = cookieUtil.findCookie(cookies, "lastCookie");
            response.addCookie(lastCookie);
            response.getWriter().println("您是首次登陆！！");
        }else {
            Cookie lastCookie = cookieUtil.findCookie(cookies, "lastCookie");
            String value = lastCookie.getValue();
            value = URLDecoder.decode(value, "utf-8");
            Cookie cookie = new Cookie("lastCookie", value);
            response.getWriter().println("您上次访问的时间为"+cookie.getValue());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
