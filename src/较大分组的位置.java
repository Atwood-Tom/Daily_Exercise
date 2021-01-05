import java.util.LinkedList;
import java.util.List;

public class 较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        int start=0;
        int end=0;
        List<List<Integer>> res=new LinkedList<>();
        for (;end<s.length();){
            if (s.charAt(end)==s.charAt(start)){
                end++;
            }else {
                if (end-start>=3){
                    List<Integer> list=new LinkedList<>();
                    list.add(start);
                    list.add(end-1);
                    res.add(list);
                }
                start=end;
            }
        }
        if (end-start>=3){
            List<Integer> list=new LinkedList<>();
            list.add(start);
            list.add(end-1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        较大分组的位置 x=new 较大分组的位置();
        List<List<Integer>> res=x.largeGroupPositions("abbxxxxzzy");
        for (int i=0;i<res.size();i++){
            for (int j=0;j<res.get(i).size();j++){
                System.out.println(res.get(i).get(j));
            }
        }
    }
}
