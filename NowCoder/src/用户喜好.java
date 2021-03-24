import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 用户喜好 {
    //链接:https://www.nowcoder.com/practice/d25162386a3140cbbe6dc071e1eb6ed6?tpId=137&&tqId=33885&rp=1&ru=/ta/exam-bytedance&qru=/ta/exam-bytedance/question-ranking
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> hashMap=new HashMap<>();
        for (int i=0;i<size;i++){
            int key=sc.nextInt();
            if (!hashMap.containsKey(key)){
                hashMap.put(key,new ArrayList<>());
            }
            hashMap.get(key).add(i+1);
        }
        int time=sc.nextInt();
        int[] result =new int[time];
        for (int i=0;i<time;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();
            int k=sc.nextInt();
            result[i]=helper(hashMap,l,r,k);
        }
        for (int i=0;i<time;i++){
            System.out.println(result[i]);
        }
    }

    private static int helper(HashMap<Integer, ArrayList<Integer>> hashMap, int l, int r, int k) {
        int size=0;
        ArrayList<Integer> finder=hashMap.get(k);
        int p=0;int q=finder.size()-1;
        while(p<q){
            int mid=(p+q)/2;
            if (finder.get(mid)<l){
                p=mid+1;
            }else if (finder.get(mid)>l){
                q=mid-1;
            }else{
                q=mid;
                break;
            }
        }
        while (q < finder.size()-1) {
            if(q >= 0 && finder.get(q) >= l && finder.get(q) <= r){
                size++;
            }
            if(q >= 0 && finder.get(q) > r){
                break;
            }
            q++;
        }
        return size;
    }
}
