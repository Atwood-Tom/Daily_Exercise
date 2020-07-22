import java.util.HashMap;
import java.util.Scanner;

public class 第N个Fib {
    public static HashMap<Integer,Integer> hashMap=new HashMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        hashMap.put(0,0);
        hashMap.put(1,1);
        hashMap.put(2,1);
        while (sc.hasNextInt()){
            int x=sc.nextInt();
            int end=Solution(x);
            System.out.println(end);
            end=Solution1(x);
            System.out.println(end);
        }
    }

    private static Integer Solution(int x) {
        if (hashMap.containsKey(x)){
            return hashMap.get(x);
        }
        hashMap.put(x,Solution(x-1)+Solution(x-2));
        return hashMap.get(x);
    }

    private static int Solution1(int x) {
        if (x==0){
            return 0;
        }
        if (x==1||x==2){
            return 1;
        }
        return Solution1(x-1)+Solution1(x-2);
    }
}
