import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//链接:https://leetcode-cn.com/problems/find-the-duplicate-number/
public class 寻找重复数 {
    //方法一:先排序,返回前后两个相同的值
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for (;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                break;
            }
        }
        return nums[i];
    }
    //方法二:快慢指针
    public static int findDuplicate1(int[] nums){
        if(nums.length <= 2){
            return nums[0];
        }
        //初始化i，j不应该为0.应该是指向第一个index与nums[index]不相等的位置.否则无法进行循环
        int i = 0,j = 0;
        int index = 0;
        for(; index<nums.length; index++){
            if(index != nums[index]){
                i = index;
                j = index;
                break;
            }
        }
        //快指针走两步,慢指针走一步.找到第一个相交点.
        while(true){
            i = nums[i];
            j = nums[nums[j]];
            if(i == j) break;
        }
        //慢指针返回起点
        i = index;
        //快指针走一步,慢指针走一步.相交点就是答案
        while(true){
            i = nums[i];
            j = nums[j];
            if(i == j) break;
        }
        return i;
    }
    //方法三:使用Map
    public static int findDuplicate2(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        for (;i<nums.length;i++){
            if (map.getOrDefault(nums[i],0)==0){
                map.put(nums[i],1);
            }else{
                break;
            }
        }
        return nums[i];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(" ");
        int[] arr =new int[s.length];
        for (int i=0;i<s.length;arr[i]=Integer.parseInt(s[i]),i++);
        System.out.println(findDuplicate2(arr));
    }
}
