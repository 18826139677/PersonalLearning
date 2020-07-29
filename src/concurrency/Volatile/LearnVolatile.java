package concurrency.Volatile;

public class LearnVolatile extends Thread{
    //确保可见性，当被volatile修饰的变量，线程会把主内存拷贝到工作内存，即从java堆中靠近虚拟机栈
    //然后这个变量会给JVM一个特殊约定，其他线程被修改会立即被其他线程感知，从而不会出现数据脏读
    //如果对声明了volatile的变量进行写操作，JVM就会向处理器发送一条Lock前缀的指令，Lock前缀的指令会引起处理器缓存写回内存；
    // 一个处理器的缓存回写到内存会导致其他处理器的缓存失效；当处理器发现本地缓存失效后，就会从内存中重读该变量数据，即可以获取当前最新值。
    public volatile boolean exit=false;
    public void run(){
        while (!exit){

        }
    }

    public static void main(String[] args) {
        LearnVolatile learnVolatile = new LearnVolatile();
        //如果本来是阻塞的直接抛出异常break
        //如果非阻塞，会把isInterrupted()置为true
//        while (!isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
//            try{
//                Thread.sleep(5*1000);//阻塞过程捕获中断异常来退出
//            }catch(InterruptedException e){
//                e.printStackTrace();
//                break;//捕获到异常之后，执行 break 跳出循环
//            }
//    }
        learnVolatile.interrupt();
    }
}
