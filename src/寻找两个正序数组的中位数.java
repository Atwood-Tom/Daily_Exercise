public class 寻找两个正序数组的中位数 {
    //链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res=0;
        int time=(nums1.length+nums2.length)%2==0?2:1;
        int size=time;
        int x=(nums1.length+nums2.length)/2-1+(nums1.length+nums2.length)%2;
        int i=0;
        int j=0;
        for (;i<nums1.length&&j<nums2.length&&size>0;){
            if (x>0){
                if (nums1[i]>nums2[j]){
                    j++;
                }else {
                    i++;
                }
                x--;
            }else {
                if (nums1[i]>nums2[j]){
                    res+=nums2[j];
                    j++;
                }else {
                    res+=nums1[i];
                    i++;
                }
                size--;
            }
        }
        if (size>0){
            if (i<nums1.length){
                for (;x>0;x--,i++);
                for (;size>0;size--,i++){
                    res+=nums1[i];
                }
            }else {
                for (;x>0;x--,j++);
                for (;size>0;size--,j++){
                    res+=nums2[j];
                }
            }
        }
        return res/time;
    }

    public static void main(String[] args) {
        寻找两个正序数组的中位数 x=new 寻找两个正序数组的中位数();
        System.out.println(x.findMedianSortedArrays(new int[]{},new int[]{1,2,3,4}));
    }
}
