import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 独一无二的出现次数 {
    //独一无二的出现次数
    //https://leetcode-cn.com/problems/unique-number-of-occurrences/
    public boolean uniqueOccurrences(int[] arr) {
        int size=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (!hashMap.containsKey(arr[i])){
                size++;
            }
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> hashSet=new HashSet<>();
        for (int times:hashMap.keySet()){
            if (!hashSet.add(hashMap.get(times))){
                return false;
            }
        }
        return true;
    }
}
