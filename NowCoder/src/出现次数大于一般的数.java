import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 出现次数大于一般的数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()) {
            String[] y = sc.nextLine().split(" ");
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            for (int i=0;i<y.length;i++){
                hashMap.put(Integer.parseInt(y[i]),hashMap.getOrDefault(Integer.parseInt(y[i]),0)+1);
            }
            for (Integer i:hashMap.keySet()){
                if (hashMap.get(i)>=y.length/2){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
