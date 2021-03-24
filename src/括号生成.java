import java.util.*;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        HashMap<String,Boolean> hashMap=new HashMap<>();
        List<String> res=new ArrayList<>();
        int time=2*n;
        int left=0;
        boolean[] arr =new boolean[time];
        String help="";
        Solution(res,arr,help,0,time,hashMap,left);
        return res;
    }

    private void Solution(List<String> res, boolean[] arr, String help, int x, int time,HashMap<String,Boolean> hash,int left) {
        if (x==time&&hash.getOrDefault(help,true)){
            res.add(help);
            hash.put(help,false);
            return;
        }
        for (int i=0;i<time;i++){
            if (!arr[i]){
                if (i<(time/2)){
                    left++;
                    help+='(';
                }else {
                    if (left-1>=0) {
                        left--;
                        help += ')';
                    } else {
                        return;
                    }
                }
                arr[i]=true;
                Solution(res,arr,help,x+1,time,hash,left);
                arr[i]=false;
                help=help.substring(0,help.length()-1);
                left--;
            }
        }
    }

//    private boolean isTrue(String help) {
//        Stack<Character> stack=new Stack<>();
//        for (int i=0;i<help.length();i++){
//            if (help.charAt(i)=='('){
//                stack.add('(');
//            }else {
//                if (stack.isEmpty()){
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//        if (stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        括号生成 x=new 括号生成();
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        List<String> res=x.generateParenthesis(a);
        for (String y:res){
            System.out.println(y);
        }
    }
}
