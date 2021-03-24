import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *   先输入一个正整数N，再输入N个整数，要求对N个整数进行排序；先按长度从小到大排序，若长度一样，则按数值从小到大排。
 */
public class 按长度排序 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int N=sc.nextInt();
            String[] arr =new String[N];
            for (int i=0;i<N;i++){
                arr[i]=String.valueOf(sc.nextInt());
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length()==o2.length()) {
                        return Integer.parseInt(o1)-Integer.parseInt(o2);
                    }
                    return o1.length()-o2.length();
                }
            });
            for (int i=0;i<N;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
