package com.github.bjlhx15.datastructure.algorithm.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {

    public static void main(String[] args) {
//        testnewFixedThreadPool();
        testThreadPoolExecutor();
    }

    public static void testThreadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            TestThread myTask = new TestThread(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    public static void testnewFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            fixedThreadPool.submit(new TestThread((i + 1)));
        }

        fixedThreadPool.shutdown();
    }


    public static void testnewSingleThreadExecutor() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 50; i++) {
            singleThreadPool.submit(new TestThread((i + 1)));
        }
        singleThreadPool.shutdown();
    }

    public static void testnewScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //定时
//        scheduledThreadPool.schedule(new Runnable() {
//            @Override
//            public void run() {
//                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                System.out.println("thread:" + Thread.currentThread().getName() + ",time:" + sdf1.format(new Date()));
//            }
//        }, 3, TimeUnit.SECONDS);

        //循环周期执行
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    public static  void testFeture() throws ExecutionException, InterruptedException {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,1000, TimeUnit.SECONDS,queue);

        Future<String> future = poolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "hello";
            }
        });
        String result = future.get();
        System.out.println(result);
    }
}
