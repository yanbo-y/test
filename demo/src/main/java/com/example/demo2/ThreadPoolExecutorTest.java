package com.example.demo2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {
    private static final int taskCount = 50;//任务数
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,//核心线程数
                20,//最大线程数
                5,//非核心回收超时时间
                TimeUnit.SECONDS,//超时时间单位
                new ArrayBlockingQueue<>(30)
                //任务队列
                 );
                System.out.println("总任务数：" + taskCount);
        long start = System.currentTimeMillis();
        //模拟任务提交
        for (int i = 0; i < taskCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);//模拟执行耗时
                    System.out.println("已执行" + integer.addAndGet(1) + "个任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            });
            try {
                //注意这里我try起来了，默认拒绝策略会报错
                executor.execute(thread);


            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("已报错" + integer.addAndGet(1) + "个任务");
            }
        }
        long end = 0;
        while (executor.getCompletedTaskCount() < 50) {
            end = System.currentTimeMillis();
        }
        System.out.println("任务总耗时：" + (end - start));
    }
}
