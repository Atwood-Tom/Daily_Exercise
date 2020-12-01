import java.util.*;

public class 删数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int time=sc.nextInt();
            System.out.println(Solution(time));
        }
    }

    private static int Solution(int time) {
        int result=0;
        Deque<Integer> deque=new LinkedList<>();
        for (int i=0;i<time;deque.addLast(i),i++);
        time=1;
        while(!deque.isEmpty()){
            result=deque.pollFirst();
            if (deque.isEmpty()){
                return result;
            }else if (time%3==0){
                time++;
                continue;
            }else {
                deque.addLast(result);
                time++;
                continue;
            }
        }
        return result;
    }
}
