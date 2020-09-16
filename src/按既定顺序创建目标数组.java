import java.util.ArrayList;
import java.util.List;

public class 按既定顺序创建目标数组 {
    //链接:https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
    //方法一:
    public int[] createTargetArray(int[] nums, int[] index) {
        int result[]=new int[index.length];
        for (int i=0;i<index.length;i++){
            insert(nums,index,result,i);
        }
        return result;
    }

    private void insert(int[] nums, int[] index, int[] result, int i) {
        for (int j=result.length-2;j>=index[i];j--){
            result[j+1]=result[j];
        }
        result[index[i]]=nums[i];
    }
    //方法二:
    public int[] createTargetArray1(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < index.length;i++){
            list.add(index[i],nums[i]);
        }
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
