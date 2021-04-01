import java.util.*;

public class aLibabaText1 {
    public static void main(String[] args) {
        Solution11();
    }
    public static ArrayList<String> arrayListx;
    public static ArrayList<String> arrayListy;
    private static void Solution11() {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char arr[]=new char[n];
        int xtime=0;
        int ytime=0;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<n;i++){
            String x=sc.next();
            arr[i]=x.charAt(0);
            if(arr[i]>='0'&&arr[i]<='9'){
                xtime++;
            }else {
                ytime++;
            }
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        if(ytime<2){
            return;
        }
        Arrays.sort(arr);
        Set<String> set=new HashSet<>();
        int count=0;
        for(int i=1;i<=m-2&&i<=xtime;i++){
            arrayListx=new ArrayList<>();
            arrayListy=new ArrayList<>();
            thisHelper(0,xtime,"",i,hashMap,arr);
            thisHelpery(xtime,arr.length-1,"",m-i,hashMap,arr);
            for(int j=0;j<arrayListx.size();j++){
                String a=arrayListx.get(j);
                for(int k=0;k<arrayListy.size();k++){
                    String res=a+arrayListy.get(k);
                    if(set.contains(res)){
                        continue;
                    }
                    System.out.println(res);
                    set.add(res);
                    count++;
                    if(count>=6666666){
                        return;
                    }
                }
                if(count>=6666666){
                    return;
                }
            }
        }
    }

    private static void thisHelpery(int start, int end, String s, int time, HashMap<Character, Integer> hashMap, char[] arr) {
        if(s.length()==time){
            arrayListy.add(s);
            return;
        }
        for(int i=start;i<=end;i++){
            if(hashMap.get(arr[i])>=1){
                s=s+arr[i];
                hashMap.put(arr[i],hashMap.get(arr[i])-1);
                thisHelpery(i,end,s,time,hashMap,arr);
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
                s=s.substring(0,s.length()-1);
            }
        }
    }

    private static void thisHelper(int start, int end, String s, int time, HashMap<Character, Integer> hashMap, char[] arr) {
        if(s.length()==time){
            arrayListx.add(s);
            return;
        }
        for(int i=start;i<end;i++){
            if(hashMap.get(arr[i])>=1){
                s=s+arr[i];
                hashMap.put(arr[i],hashMap.get(arr[i])-1);
                thisHelper(i,end,s,time,hashMap,arr);
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
                s=s.substring(0,s.length()-1);
            }
        }
    }

}
