import java.util.HashMap;
import java.util.Scanner;

public class SQL结构分析 {
    /**
     * SQL结构分析
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 给定一个完整的SQL，请编写一个函数，找出SQL中的表名。部分SQL中可能生成了中间表，请不要输出这些表名。同一个表名只输出一次即可。
     * 输入描述
     * 完整的SQL，以两个换行结尾。
     * 输出描述
     * SQL中所有的原始表名，每行一个表名。
     * 如果有多个表名，按照出现的先后顺序输出。
     * 样例输入
     * select t.id, t.name, t.tag_id
     * from (
     *     select user.id, user.name, tag.tag_id
     *     from user
     *     inner join user_tag
     * ) t
     * 样例输出
     * user
     * user_tag
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int time=0;
        HashMap<String,Integer> hashMap=new HashMap<>();
        while(sc.hasNextLine()&&time<2){
            String x=sc.nextLine();
            if(x.length()==0){
                time++;
                continue;
            }
            int index=0;
            for(index=x.indexOf("from",0);index!=-1;index=x.indexOf("from",index+4)){
                if(index!=-1){
                    StringBuffer sb=new StringBuffer("");
                    boolean flag=false;
                    for(int i=index+4;i<x.length();i++){
                        if(!flag&&x.charAt(i)==' '){
                            flag=true;
                            continue;
                        }
                        if(x.charAt(i)==' '){
                            break;
                        }
                        if(x.charAt(i)=='('){
                            break;
                        }
                        sb.append(x.charAt(i));
                    }
                    if(x.indexOf(',')==-1){
                        if(hashMap.getOrDefault(sb.toString(),0)==0){
                            hashMap.put(sb.toString(),1);
                        }
                    }else{
                        String help[]=sb.toString().split(",");
                        for(int i=0;i<help.length;i++){
                            if(hashMap.getOrDefault(help[i],0)==0){
                                hashMap.put(help[i],1);
                            }
                        }
                    }
                }
            }
            for(index=x.indexOf("join",0);index!=-1;index=x.indexOf("join",index+4)){
                if(index!=-1){
                    StringBuffer sb=new StringBuffer("");
                    boolean flag=false;
                    for(int i=index+4;i<x.length();i++){
                        if(!flag&&x.charAt(i)==' '){
                            flag=true;
                            continue;
                        }
                        if(x.charAt(i)==' '){
                            break;
                        }
                        if(x.charAt(i)=='('){
                            break;
                        }
                        sb.append(x.charAt(i));
                    }
                    if(x.indexOf(',')==-1){
                        if(hashMap.getOrDefault(sb.toString(),0)==0){
                            hashMap.put(sb.toString(),1);
                        }
                    }else{
                        String help[]=sb.toString().split(",");
                        for(int i=0;i<help.length;i++){
                            if(hashMap.getOrDefault(help[i],0)==0){
                                hashMap.put(help[i],1);
                            }
                        }
                    }
                }
            }
        }
        for(String res:hashMap.keySet()){
            System.out.println(res);
        }
    }
}