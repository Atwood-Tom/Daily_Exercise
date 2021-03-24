import java.util.*;
public class 全排列 {
    //链接:https://leetcode-cn.com/problems/permutations/

    //方法一
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            //swap(List<?> list, int i, int j)
            //交换指定列表中指定位置的元素。
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    //方法二
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        Deque<Integer> helper=new ArrayDeque<>();
        Boolean[] arr =new Boolean[nums.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=false;
        }
        dfs(nums,arr,res,helper,nums.length,0);
        return res;
    }

    private void dfs(int[] nums, Boolean[] arr, List<List<Integer>> res, Deque<Integer> helper, int length, int time) {
        if (time==length){
            res.add(new ArrayList<>(helper));
            return;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]){
                continue;
            }
            arr[i]=true;
            helper.addLast(nums[i]);
            dfs(nums,arr,res,helper,length,time+1);
            arr[i]=false;
            helper.pollLast();
        }
    }


    public static void main(String[] args) {
        全排列 x=new 全排列();
        List<List<Integer>> res=x.permute(new int[]{1,2,3});
        for (List<Integer> i:res){
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}
