package concurrency.Thread;

import java.util.concurrent.*;

//创建线程的第一种方式
//public class LearnThread extends Thread{
//    public void run(){
//        System.out.println("start");
//    }
//
//    public static void main(String[] args) {
//        LearnThread learnThread=new LearnThread();
//        learnThread.start();
//    }
//}


//创建线程的第二种方式
//public class LearnThread implements Runnable{
//    public void run(){
//        System.out.println("start");
//    }
//
//    public static void main(String[] args) {
//        Thread thread=new Thread(new LearnThread());
//        thread.start();
//    }
//}


//创建线程的第三种方式
public class LearnThread implements Callable{
    public Object call(){
        return "Callable";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LearnThread learnThread=new LearnThread();
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future future=service.submit(learnThread);
        System.out.println(future.get());
        service.shutdown();
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始线程");
            }
        });
        Thread.sleep(1000);
    }
    //四种创建线程池的方法
    //创建一个可以根据需要创建线程的线程池，长期不使用的线程池不会占用资源
    ExecutorService executorService=Executors.newCachedThreadPool();
    //创建一个可重用的固定线程数的线程池
    ExecutorService executorService1=Executors.newFixedThreadPool(1);
    //创建一个可安排给定延时后运行命令或定期地执行(延时一秒)
    ExecutorService executorService2=Executors.newScheduledThreadPool(1);
    //创建只有一个线程的线程池
    ExecutorService executorService3=Executors.newSingleThreadExecutor();
}