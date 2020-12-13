public class 使用多线程交叉打印 {
    public static int x=0;
    public static volatile long time;


    public static void main(String[] args) {
        Solution1();
        System.out.println("结束");
        Solution2();
        System.out.println("结束");
    }

    private static void Solution1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(x<100){
                    synchronized (this.getClass()){
                        time++;
                        if (x%2==1){
                            System.out.println(Thread.currentThread().getName()+x);
                            System.out.println(time);
                            x++;
                        }
                    }
                }
            }
        },"奇数打印").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(x<100){
                    synchronized (this.getClass()){
                        time++;
                        if (x%2==0){
                            System.out.println(Thread.currentThread().getName()+x);
                            System.out.println(time);
                            x++;
                        }
                    }
                }
            }
        },"偶数打印").start();
        while (Thread.activeCount()>2){
            continue;
        }
    }

    private static void Solution2() {
        MyRun r=new MyRun();
        Thread a1=new Thread(r,"偶数打印");
        Thread a2=new Thread(r,"奇数打印");
        r.setX(x);
        r.setTime(0);
        a1.start();
        a2.start();
        while(Thread.activeCount()>3){
            continue;
        }
        System.out.println(r.getTime());
    }

}

class MyRun implements Runnable{
    int x=0;
    int time=0;
    public void setX(int x) {
        this.x = x;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        while(x<100){
            time++;
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+x++);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
