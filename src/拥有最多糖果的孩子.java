import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 拥有最多糖果的孩子 {
    //链接:https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> satisfy=new LinkedList<>();
        int max=candies[0];
        for (int i=1;i<candies.length;i++){
            if (max<candies[i]){
                max=candies[i];
            }
        }
        for (int i=0;i<candies.length;i++){
            if (candies[i]+extraCandies>=max){
                satisfy.add(true);
            }else {
                satisfy.add(false);
            }
        }
        return satisfy;
    }
}
