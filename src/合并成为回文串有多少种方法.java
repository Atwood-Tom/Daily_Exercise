import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 合并成为回文串有多少种方法 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int x=Solution(a,b);
        System.out.println(x);
    }

    private static int Solution(String a, String b) {
        int time=0;
        for (int i=0;i<=a.length();i++){
            if (Creat(a,i,b)){
                time++;
            }
        }
        return time;
    }

    private static boolean Creat(String a,int i, String b) {
        Deque<Character> deque=new LinkedList<>();
        for (int j=0;j<a.length();j++){
            deque.addLast(a.charAt(j));
        }
        String x="";
        for (int j=0;j<i;j++){
            x=deque.pollLast()+x;
        }
        for (int j=0;j<b.length();j++){
            deque.addLast(b.charAt(j));
        }
        for (int j=0;j<x.length();j++){
            deque.addLast(x.charAt(j));
        }
        return isPalindrome(deque);
    }

    private static boolean isPalindrome(Deque<Character> deque) {
        while(!deque.isEmpty()){
            char a=deque.pollFirst();
            if (deque.isEmpty()){
                return true;
            }
            char b=deque.pollLast();
            if (a!=b){
                return false;
            }
        }
        return true;
    }
}
