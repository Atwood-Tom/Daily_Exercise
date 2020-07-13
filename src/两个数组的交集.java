import java.util.Arrays;
import java.util.HashMap;

public class 两个数组的交集 {
    //链接:https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
    public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int j=0;
        int arr[]=new int[nums1.length>nums2.length?nums2.length:nums1.length];
        for (int i=0;i<nums1.length;i++){
            if (hashMap.containsKey(nums1[i])){
                hashMap.replace(nums1[i],hashMap.get(nums1[i])+1);
            }else {
                hashMap.put(nums1[i],1);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if (hashMap.containsKey(nums2[i])&&hashMap.get(nums2[i])>=1){
                arr[j++]=nums2[i];
                hashMap.replace(nums2[i],hashMap.get(nums2[i])-1);
            }
        }
        int result[]=new int[j];
        for (int i=0;i<j;i++){
            result[i]=arr[i];
        }
        return result;
    }
    public int[] intersect2(int[] nums1, int[] nums2){
        int arr[]=new int[nums1.length>nums2.length?nums2.length:nums1.length];
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i=0,k=0;i<nums1.length&&k<nums2.length;){
            if (nums1[i]<nums2[k]){
                i++;
            }else if (nums1[i]==nums2[k]){
                arr[j++]=nums1[i];
                i++;
                k++;
            }else {
                k++;
            }
        }
        int result[]=new int[j];
        for (int i=0;i<j;i++){
            result[i]=arr[i];
        }
        return result;
    }
}
