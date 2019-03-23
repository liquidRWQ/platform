package com.enter.platform.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Liquid
 * @类名： ThreadPoolUtils
 * @描述：
 * @date 2019/3/21
 */
public class ThreadPoolUtils {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("singleThreadPool = " + Thread.currentThread().getName());
            }
        });
        singleThreadPool.shutdown();
    }
}
