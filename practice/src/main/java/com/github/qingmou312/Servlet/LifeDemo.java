package com.github.qingmou312.Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:lidan
 * Created:2019/4/28
 */
public class LifeDemo extends HttpServlet {
   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/

    public LifeDemo() {
        System.out.println("servlet对象被创建了。。。。。");
    }


    /**
     * 初始化
     * init方法的使用
     *
     * @param config servlet的配置信息：初始化参数，或者servlet的加载机制
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet被初始化了");
    }


    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet的业务服务方法被调用了。。。");
    }

    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet被销毁。。。");
    }
}
