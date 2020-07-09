import java.util.Arrays;
import java.util.Scanner;

public class 风口的猪_中国的牛市 {

    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String arr[]=sc.nextLine().split(",");
        int x[]=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            x[i]=Integer.parseInt(arr[i]);
        }
        System.out.println(calculateMax(x));
    }
}
