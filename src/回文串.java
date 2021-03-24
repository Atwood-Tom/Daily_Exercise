import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 回文串 {
    //链接:https://www.nowcoder.com/practice/655a43d702cd466093022383c24a38bf?tpId=49&tqId=29295&rp=2&ru=/ta/2016test&qru=/ta/2016test/question-ranking
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            if (Solution(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean Solution(String s) {
        Deque<Character> deque=new LinkedList<>();
        for (int i=0;i<s.length();i++){
            deque.addLast(s.charAt(i));
        }
        for (int i=0;i<=1;){
            if (deque.peekFirst()==deque.peekLast()){
                deque.pollFirst();
                if (deque.isEmpty()){
                    break;
                }
                deque.pollLast();
            }else if (deque.peekFirst()!=deque.peekLast()){
                i++;
                char a=deque.pollFirst();
                char b=deque.pollLast();
                if (a==deque.peekLast()){
                    deque.addFirst(a);
                }else if (b==deque.peekFirst()){
                    deque.addLast(b);
                }
            }
        }
        return deque.isEmpty();
    }
}
