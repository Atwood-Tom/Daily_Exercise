import java.util.Arrays;
import java.util.Scanner;

public class 风口的猪_中国的牛市 {

    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
//方法一
        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }
//方法二
    public int calculateMax1(int[] prices) {
        if(prices==null || prices.length<2)return 0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
            int temp=getMax1(prices,0,i)+getMax1(prices,i+1,prices.length-1);
            if(temp>sum)sum=temp;
        }
        return sum;
    }
    public static int getMax1(int[] prices,int left,int right){
        if(left>=prices.length)return 0;
        int Min=prices[left];
        int ret=0;
        for(int i=left+1;i<=right;i++){
            Min=Math.min(prices[i],Min);
            ret=Math.max(ret,prices[i]-Min);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] arr =sc.nextLine().split(",");
        int[] x =new int[arr.length];
        for (int i=0;i<arr.length;i++){
            x[i]=Integer.parseInt(arr[i]);
        }
        System.out.println(calculateMax(x));
    }
}
