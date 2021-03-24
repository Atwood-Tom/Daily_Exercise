public class MyBlockingQueue <E>{
    private volatile static int index;
    private final Object[] items;
    private int putIndex;//填入元素索引
    private int takeIndex;//弹出元素索引
    private int size;//长度
    public MyBlockingQueue(int capacity){
        items=new Object[capacity];
        putIndex=0;
        takeIndex=0;
        size=0;
    }
    private synchronized void put(E e) throws InterruptedException {
        while (size==items.length){//达到上限需要等待操作
            this.wait();
        }
        putIndex=(putIndex+1)%items.length;
        items[putIndex]=e;
        size++;
        notifyAll();
    }
    public synchronized E take () throws InterruptedException {
        while(size==0){
            this.wait();
        }
        takeIndex=(takeIndex+1)%items.length;
        size--;
        notifyAll();
        return (E)items[takeIndex];
    }
//    public static void main(String[] args) throws InterruptedException {
//        MyBlockingQueue<Integer> queue=new MyBlockingQueue(100);
//        for (int i = 0; i < 5; i++) {
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int j=0;j<100;j++){
//                            queue.put(finalI *100+j);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        while(true){
//            Integer num=queue.take();
//            System.out.println(index+":"+num);
//            index++;
//        }
//    }
}
