import java.util.Scanner;

public class 锤子剪刀布 {
    //C锤子 B布 J剪刀
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        //甲胜           乙胜          平局
        int successA=0,successB=0,draw=0;
        //C锤子 B布 J剪刀
        //int[0] 布    int[1]  锤子  int[2]  剪刀
        int arrSuccessTimeA[]=new int[3];
        int arrSuccessTimeB[]=new int[3];
        for (int i=0;i<N;i++){
            String A=sc.next();
            String B=sc.next();
            if ("C".equals(A)&&"B".equals(B)){
                successB++;
                arrSuccessTimeB[0]++;
            }else if ("C".equals(A)&&"J".equals(B)){
                successA++;
                arrSuccessTimeA[1]++;
            }else if ("B".equals(A)&&"C".equals(B)){
                successA++;
                arrSuccessTimeA[0]++;
            }else if ("B".equals(A)&&"J".equals(B)){
                successB++;
                arrSuccessTimeB[2]++;
            }else if ("J".equals(A)&&"B".equals(B)){
                successA++;
                arrSuccessTimeA[2]++;
            }else if ("J".equals(A)&&"C".equals(B)){
                successB++;
                arrSuccessTimeB[1]++;
            }else {
                draw++;
            }
        }
        System.out.println(successA+" "+draw+" "+successB);
        System.out.println(successB+" "+draw+" "+successA);
        Solution(arrSuccessTimeA);
        System.out.print(" ");
        Solution(arrSuccessTimeB);
    }

    private static void Solution(int[] arrSuccessTimeA) {
        int max=0;
        for (int i=1;i<arrSuccessTimeA.length;i++){
            if (arrSuccessTimeA[i]>arrSuccessTimeA[max]){
                max=i;
            }
        }
        if (max==0){
            System.out.print("B");
        }else if (max==1){
            System.out.print("C");
        }else {
            System.out.print("J");
        }
    }
}
