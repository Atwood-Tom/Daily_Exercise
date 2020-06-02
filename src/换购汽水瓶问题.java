import java.util.Scanner;

public class 换购汽水瓶问题 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=sc.nextInt();
            int sum=0;
            for (;x>=3;){
                sum=x/3+sum;
                x=x%3+x/3;
            }
            if (x==2){
                sum++;
            }
            System.out.println(sum);
        }
    }
}
