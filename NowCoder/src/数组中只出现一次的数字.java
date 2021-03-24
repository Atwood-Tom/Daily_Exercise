import java.util.HashMap;

public class 数组中只出现一次的数字 {
    //链接:https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=188&&tqId=35515&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    public void FindNumsAppearOnce(int [] array, int[] num1, int[] num2) {
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        for (int i=0;i<array.length;i++){
            hashmap.put(array[i],hashmap.getOrDefault(array[i],0)+1);
        }
        int j=0;
        for (int i=0;i<array.length&&j<2;i++){
            if(hashmap.get(array[i])==1){
                if (j==0){
                    num1[0]=array[i];
                    j++;
                }else {
                    num2[0]=array[i];
                    j++;
                }
            }
        }
    }
}
