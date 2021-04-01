import java.util.Arrays;
import java.util.Scanner;

public class TestFind {
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.sort(arr);
        Scanner sc=new Scanner(System.in);
        int find=sc.nextInt();
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]==find){
                System.out.println(mid);
                break;
            }else if(arr[mid]>find){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }

    }
}
