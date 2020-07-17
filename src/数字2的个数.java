import java.util.Scanner;

import static java.lang.Math.pow;

public class 数字2的个数 {
    public static int mycountNumberOf2s(int n){
        int high=n,low=0,w;
        int end=0;
        for (int s=1;high!=0;s=s*10){
            high=n/s;
            low=n%s;
            w=high%10;
            high=high/10;
            if (w<2){
                end+=high*s;
            }else if (w==2){
                end+=low+high*s+1;
            }else {
                end+=(high+1)*s;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(mycountNumberOf2s(sc.nextInt()));
        }
    }
}
