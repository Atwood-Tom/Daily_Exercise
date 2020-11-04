import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class MyDate {
    public void schedule(Runnable task,long delay,long period) throws InterruptedException {

    }
    public static void main(String[] args) throws InterruptedException {
//        new MyDate().schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("起床了");
//            }
//        },3000,1000);
        //ExecutorService pool= Executors.newSingleThreadExecutor();//线程池的员工就是一个
//        ExecutorService pool=Executors.newFixedThreadPool(4);//线程池中线程有4个,没有临时线程
//        ExecutorService pool1=Executors.newScheduledThreadPool(4);//正式线程有4个
//        ExecutorService pool2=Executors.newCachedThreadPool();//正式线程为0,临时线程数量不限制
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(4);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了");
            }
        },1,1,TimeUnit.SECONDS);
    }
}
