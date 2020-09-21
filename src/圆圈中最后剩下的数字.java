import java.util.ArrayList;
import java.util.LinkedList;

public class 圆圈中最后剩下的数字 {
    //链接:https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
    //方法一:
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int start=0;
        while(n>1){
            start+=m-1;
            start%=n;
            arrayList.remove(start);
            n--;
        }
        return arrayList.remove(0);
    }
}
