package com.github.qingmou312.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:lidan
 * Created:2019/4/28
 * <p>
 * Servlet是一个单实例多线程的
 *
 * 单例模式：（设计模式的重点）
 * 1）将属性私有化
 * 2）提供公共的对外方法----》返回值就是该类的对象
 *     饿汉式/懒汉式（懒加载/多线程安全问题）
 *
 * <p>
 * 检验多线程安全问题的标准：
 * 1)是否有多线程环境
 * 2)是否有共享数据
 * 3)是否有多条语句对共享数据操作
 * <p>
 * 同步锁：
 * 1)可以是任意的java对象
 * 2)如果使用同步方法（非静态的），锁对象就是this
 * 3)如果使用静态的同步方法，锁对象类名.class
 *
 *
 * 数字越大，访问的优先级越低
 */
public class ThreadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
