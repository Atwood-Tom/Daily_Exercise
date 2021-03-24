import java.util.*;

public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=sc.nextInt();
        int[] arr =new int[nums];
        HashMap<Integer,Integer> helper=new HashMap<>();
        for (int i=0;i<nums;i++){
            arr[i]=sc.nextInt();
            helper.put(arr[i],helper.getOrDefault(arr[i],0)+1);
        }
        Solution(helper);
    }

    private static void Solution(HashMap<Integer, Integer> helper) {
        List<Integer> res=new ArrayList<>();
        for (Integer x:helper.keySet()){
            if (helper.get(x)%2==1){
                res.add(x);
            }
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0;i<res.size();i++){
            if (i==0){
                System.out.print(res.get(i));
            }else {
                System.out.print(" "+res.get(i));
            }
        }
    }
}
