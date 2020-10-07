import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class 头条校招 {
    //链接:https://www.nowcoder.com/practice/57cf0b1050834901933e9b48daafbb9a?tpId=137&&tqId=34094&rp=1&ru=/ta/exam-bytedance&qru=/ta/exam-bytedance/question-ranking
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for(int i = 0; i < ints.length; i++){
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        int index = 0;
        int pre = -1, size = 0, cnt = 0;
        while (index < n) {
//            System.out.println("pre " + pre + " size " + size);
            if(size == 0){
                pre = ints[index];
                size = 1;
            }else if(size == 1){
                if(ints[index] - pre <= 10){
                    pre = ints[index];
                    size = 2;
                }else{
                    pre = ints[index];
                    cnt += 2;
                    size = 1;
                }
            }else{
                if(ints[index] - pre <= 10){
                    pre = -1;
                    size = 0;
                }else{
                    pre = ints[index];
                    cnt++;
                    size = 1;
                }
            }
            index++;
        }
        if(size == 2){
            cnt++;
        }else if(size == 1){
            cnt += 2;
        }
        System.out.println(cnt);
    }
}

