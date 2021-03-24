import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 两个数组的交集2 {
    //链接:https://leetcode-cn.com/problems/intersection-of-two-arrays/
     public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            hashSet.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++){
            if (hashSet.contains(nums2[i])&&!result.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] arr =new int[result.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=result.get(i);
        }
        return arr;
    }
}
