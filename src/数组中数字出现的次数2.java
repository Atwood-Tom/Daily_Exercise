import java.util.HashMap;

public class 数组中数字出现的次数2 {
    //链接:https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
    public int singleNumber(int[] nums) {
        int result=-1;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int time=hashMap.getOrDefault(nums[i],0);
            hashMap.put(nums[i],time+1);
        }
        for (Integer i:hashMap.keySet()){
            if (hashMap.get(i)==1){
                result=i;
                return result;
            }
        }
        return result;
    }
}
