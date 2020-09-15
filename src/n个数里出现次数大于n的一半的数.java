import java.util.HashMap;
import java.util.Scanner;
//链接:https://www.nowcoder.com/questionTerminal/eac8c671a0c345b38aa0c07aba40097b?orderByHotValue=0&page=1&onlyReference=false
public class n个数里出现次数大于n的一半的数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int arr[]=new int[s.length];
        for (int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        SolutionByHashMap(arr);
    }
    private static void Solution(int[] arr) {
        //记录数字出现的次数
        int right=arr.length-1;
        int left=arr.length-1;
        //待排序区间(arr.length-i,arr.length]
        for (int i=0;i<arr.length;i++){
            int max=0;
            for (int j=0;j<arr.length-i;j++){
                if (arr[j]>arr[max]){
                    max=j;
                }
            }
            int x=arr[max];
            arr[max]=arr[arr.length-i-1];
            arr[arr.length-i-1]=x;
            if (arr[arr.length-i-1]==arr[right]){
                left=arr.length-i-1;
            }else{
                if (right-left+1>=arr.length/2){
                    System.out.print(arr[right]);
                }
                right=left=arr.length-i-1;
            }
        }
        if (left==0&&right-left+1>=arr.length/2){
            System.out.println(arr[right]);
        }
    }
    private  static void SolutionByHashMap(int arr[]){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (hashMap.containsKey(arr[i])){
                int x=hashMap.get(arr[i]);
                hashMap.replace(arr[i],x+1);
            }else{
                hashMap.put(arr[i],1);
            }
        }
        for (Integer key: hashMap.keySet()){
            if (hashMap.get(key)>arr.length/2){
                System.out.print(key);
            }
        }
    }
}
