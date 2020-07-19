
import java.util.Scanner;
public class 电话号码 {
    static class Tel{
        Tel next;
        String mynumber="";
        String out="";
        public Tel(String x){
            out="";
            mynumber=x;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
           int time=sc.nextInt();
           Tel newhead=new Tel("");
           String mynumber[]=new String[time];
           for (int i=0;i<mynumber.length;i++){
               mynumber[i]=sc.next();
           }
           for (int i=0;i<time;i++){
               Tel newTel=new Tel(mynumber[i]);
               if (qualified(newTel)){
                   deal(newTel);
                   Sort(newTel,newhead);
               }
           }
           for (Tel p=newhead.next;p!=null;p=p.next){
               System.out.println(p.out);
           }
        }
    }

    private static void Sort(Tel tel, Tel newhead) {
        if (newhead.next==null){
            newhead.next=tel;
            return;
        }else {
            Tel p=newhead;
            for (;p.next!=null;p=p.next){
                if (tel.out.equals(p.next.out)){
                    return;
                }
                if (Integer.parseInt(p.next.out.substring(0,3))>Integer.parseInt(tel.out.substring(0,3))){
                    tel.next=p.next;
                    p.next=tel;
                    return;
                }else if (Integer.parseInt(p.next.out.substring(0,3))==Integer.parseInt(tel.out.substring(0,3))){
                    if (Integer.parseInt(p.next.out.substring(4,8))==Integer.parseInt(tel.out.substring(4,8))){
                        tel.next=p.next;
                        p.next=tel;
                        return;
                    }
                }
            }
            p.next=tel;
        }
    }

    private static void deal(Tel p) {
        for (int i=0;i<p.mynumber.length();i++){
            char x=p.mynumber.charAt(i);
            if(i==3){
                p.out+="-";
            }
            if (x<='9'&&x>='0'){
                p.out+=p.mynumber.charAt(i);
            }else {
                if (x=='A'||x=='B'||x=='C'){
                    p.out+="2";
                }else if (x=='D'||x=='E'||x=='F'){
                    p.out+="3";
                }else if (x=='G'||x=='H'||x=='I'){
                    p.out+="4";
                }else if (x=='J'||x=='K'||x=='L'){
                    p.out+="5";
                }else if (x=='M'||x=='N'||x=='O'){
                    p.out+="6";
                }else if (x=='P'||x=='Q'||x=='R'||x=='S'){
                    p.out+="7";
                }else if (x=='T'||x=='U'||x=='V'){
                    p.out+="8";
                }else if (x=='W'||x=='X'||x=='Y'||x=='Z'){
                    p.out+="9";
                }
            }
        }
    }

    private static boolean qualified(Tel p) {
        p.mynumber=p.mynumber.replaceAll("-","");
        if (p.mynumber.length()!=7){
            return false;
        }
        return true;
    }
}
