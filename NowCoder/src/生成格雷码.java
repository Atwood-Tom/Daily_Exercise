import java.util.Arrays;
import java.util.Scanner;

public class 生成格雷码 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            String arr[]=getGray(n);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static String[] getGray(int n) {
        if (n == 1) {
            String[] result = new String[2];
            result[0] = "0";
            result[1] = "1";
            return result;
        } else {
            String[] temp = getGray(n - 1);
            String[] result = new String[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                result[i] = "0" + temp[i];
            }
            for (int i = 0; i < temp.length; i++) {
                result[i + temp.length] = "1" + temp[temp.length - i - 1];
            }
            return result;
        }
    }
}
