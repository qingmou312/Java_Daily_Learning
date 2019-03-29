package com.github.qingmou312.everything.core.interceptor.impl;

import com.github.qingmou312.everything.core.DAO.FileDAO;
import com.github.qingmou312.everything.core.interceptor.ThingInterceptor;
import com.github.qingmou312.everything.core.model.Thing;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Author:lidan
 * Created:2019/3/21
 */
public class ThingClearInterceptor implements ThingInterceptor, Runnable {

    private Queue<Thing> queue = new ArrayBlockingQueue<>(1024);

    private final FileDAO fileIndexDAO;

    public ThingClearInterceptor(FileDAO fileIndexDAO) {
        this.queue = queue;
        this.fileIndexDAO = fileIndexDAO;
    }

    @Override
    public void apply(Thing thing) {
        this.queue.add(thing);
    }

    @Override
    public void run() {
        while (true) {
            Thing thing = this.queue.poll();
            if (thing != null) {
                fileIndexDAO.delete(thing);
            }
            //优化点：批量删除
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
