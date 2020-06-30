import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 整数与IP地址间的转换 {
    //链接:https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea?commentTags=Java
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            //如果存在"." 则证明输入的是IP地址
            if (s.contains(".")){
                String x[]=s.split("\\.");
                solution1(x);
            }else {
                //如果不存在"," 则证明输入的是十进制型的IP地址
                solution2(s);
            }
        }
    }

    private static void solution1(String x[]) {
        Queue<Integer> queue=new LinkedList<>();
        for (int i=x.length-1;i>=0;i--){
            int y=Integer.parseInt(x[i]);
            for (int j=7;j>=0;j--){
                queue.add(y%2);
                y/=2;
            }
        }
        long i=1;
        long j=0;
        while(!queue.isEmpty()){
            j=j+i*queue.poll();
            i*=2;
        }
        System.out.println(j);
    }

    private static void solution2(String s) {
        String end="";
        long x=Integer.parseInt(s);
        Queue<Integer> queue=new LinkedList<>();
        for(;x>0;){
            int y= (int) (x%2);
            queue.add(y);
            x=x/2;
        }
        while(!queue.isEmpty()){
            long sum=0;
            long j=1;
            for (int i=0;i<8&&!queue.isEmpty();i++){
                sum=sum+j*queue.poll();
                j=j*2;
            }
            for (;sum>0;sum=sum/10) {
                end = sum % 10 + end;
            }
            if (queue.isEmpty()){
                System.out.println(end);
                break;
            }
            end="."+end;
        }
    }
}
