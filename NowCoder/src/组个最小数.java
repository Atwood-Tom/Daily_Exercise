import java.util.Scanner;

public class 组个最小数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] arr =sc.nextLine().split(" ");
            int[] helper =new int[10];
            for (int i=0;i<helper.length;i++){
                helper[i]=Integer.parseInt(arr[i]);
            }
            System.out.println(Solution(helper));
        }
    }

    private static String Solution(int[] helper) {
        StringBuilder sb=new StringBuilder();
        for (int i=1;i<helper.length;i++){
            if (helper[i]!=0){
                helper[i]--;
                sb.append(i);
                break;
            }
        }
        for (int i=0;i<helper.length;){
            if (helper[i]==0){
                i++;
                continue;
            }else {
                helper[i]--;
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
