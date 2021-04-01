public class threadexercise {
    static Object lock =new Object();
    static boolean flag=true;
    public static class thread1 implements Runnable{
        @Override
        public void run() {
            while(true){
                if (flag){
                    synchronized (lock){
                        if (flag){
                            System.out.println("A");
                            flag=false;
                        }
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static class thread2 implements Runnable{
        @Override
        public void run() {
            while(true){
                if (!flag){
                    synchronized (lock){
                        if (!flag){
                            System.out.println("B");
                            flag=true;
                        }
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread thread1=new Thread(new thread1());
        Thread thread2=new Thread(new thread2());
        thread1.start();
        thread2.start();
    }

}
