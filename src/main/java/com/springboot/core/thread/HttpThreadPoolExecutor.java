package com.springboot.core.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpThreadPoolExecutor {
	
	private static ThreadPoolExecutor pool = null;
	
	//设置核心池大小
    private static int corePoolSize = 5;
    
    //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
    private static long keepActiveTime = 200;
    
    //设置时间单位，秒
    private static TimeUnit timeUnit = TimeUnit.SECONDS;
    
    //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
	
	public void init(){
		pool = new ThreadPoolExecutor(
				10, 20, 30, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(10));
	}
	
	public static ThreadPoolExecutor getExecutorService(){
		return pool;
	}
	
	public static void destroy(){
        if(pool != null) {  
            pool.shutdownNow();  
        }  
	}
	
	public static void main(String[] args) {
		ExecutorService pool2 = Executors.newCachedThreadPool();
	}
}
