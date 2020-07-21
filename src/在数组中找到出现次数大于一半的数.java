import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 在数组中找到出现次数大于一半的数 {
    public static void main(String[] args) {
        int end1=Solution1();
        System.out.println(end1);
    }
    private static int Solution1() {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x=sc.nextInt();
            if (hashMap.containsKey(x)){
                hashMap.replace(x,hashMap.get(x)+1);
            }else {
                hashMap.put(x,1);
            }
        }
        for (int y:hashMap.keySet()){
            if (hashMap.get(y)>(n/2)){
                return y;
            }
        }
        return -1;
    }
}
