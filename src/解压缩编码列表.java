import java.util.LinkedList;
import java.util.List;

public class 解压缩编码列表 {
    //链接:https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
    public int[] decompressRLElist1(int[] nums) {
        List<Integer> list=new LinkedList<>();
        for (int i=0;i<nums.length;i+=2){
            for (int j=0;j<nums[i];j++){
                list.add(nums[i+1]);
            }
        }
        int arr[]=new int[list.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            len += nums[i];
        }
        int[] result = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i]; j++) {
                result[index] = nums[i+1];
                index++;
            }
        }
        return result;
    }
}
