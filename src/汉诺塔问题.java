import java.util.List;

public class 汉诺塔问题 {
    //链接:https://leetcode-cn.com/problems/hanota-lcci/
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        while(!A.isEmpty()){
            int mid=A.remove(A.size()-1);
            if (A.isEmpty()){
                C.add(mid);
                break;
            }else {
                B.add(mid);
            }
        }
        while(!B.isEmpty()){
            C.add(B.remove(B.size()-1));
        }
    }
}
