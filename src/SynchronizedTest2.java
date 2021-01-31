public class SynchronizedTest2 {
    /**
     * 有一个教室,有座位50个,同时有三个老师安排学生的座位.
     * 每个老师安排100个同学到这个教室,模拟使用多线程实现
     */
    public static int SEAT=51;
    public static int stu=0;
    public synchronized static void number(){
        SEAT--;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread[]=new Thread[3];
        for (int i=0;i<thread.length;i++){
            thread[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (;SEAT>0;){
                        synchronized (SynchronizedTest2.class){
                           if (SEAT>0){
                               SEAT--;
                               stu++;
                               System.out.println(Thread.currentThread().getName()+"安排第"+stu+"个学生");
                               try {
                                   Thread.sleep(20);
                               } catch (InterruptedException e) {
                                   e.printStackTrace();
                               }
                           }
//                               number();
                        }
                    }
                }
            },"老师"+i);
        }
        for (int i=0;i<thread.length;i++){
            thread[i].start();
        }
        for(Thread t : thread){
            if(t != null)
                t.join();
        }
        System.out.println(SEAT);
    }
}
