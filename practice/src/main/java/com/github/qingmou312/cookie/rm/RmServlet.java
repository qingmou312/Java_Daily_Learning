package com.github.qingmou312.cookie.rm;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:lidan
 * Created:2019/5/8
 */
public class RmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();

        Cookie c = getCookieByName("lastTime", request.getCookies());


    }

    private Cookie getCookieByName(String name, Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }
}
