import java.util.Scanner;

public class 两种排序方法 {
    //链接:https://www.nowcoder.com/practice/839f681bf36c486fbcc5fcb977ffe432?tpId=182&&tqId=34294&rp=1&ru=/ta/exam-all&qru=/ta/exam-all/question-ranking
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        String[] helper =new String[x];
        for (int i=0;i < x;helper[i]=sc.next(),i++);
        Boolean a=lengths(helper);
        Boolean b=lexicographically(helper);
        if (b && a){
            System.out.println("both");
        }else if (b){
            System.out.println("lexicographically");
        }else if (a){
            System.out.println("lengths");
        }else {
            System.out.println("none");
        }
    }

    private static Boolean lexicographically(String[] helper) {
        for (int i = 0; i < helper.length -1; i++) {
            if (helper[i].compareTo(helper[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    private static Boolean lengths(String[] helper) {
        for (int i=0;i+1<helper.length;i++){
            int a=helper[i].length();
            int b=helper[i+1].length();
            if (b<a){
                return false;
            }
        }
        return true;
    }
}
