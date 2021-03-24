import java.util.HashMap;

public class 最常见的单词 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase();
        paragraph=paragraph.replaceAll(","," ");
        paragraph=paragraph.replaceAll("\\."," ");
        paragraph=paragraph.replaceAll("!"," ");
        paragraph=paragraph.replaceAll("\\?"," ");
        paragraph=paragraph.replaceAll(";"," ");

        HashMap<String,Integer> hashMap=new HashMap<>();
        String result = null;
        int max=0;
        String[] node =paragraph.split(" ");
        for (int i=0;i<node.length;i++){
            if (!node[i].equals("")&&!inbanned(banned,node[i])){
                hashMap.put(node[i],hashMap.getOrDefault(node[i],0)+1);
            }
        }
        for (String x:hashMap.keySet()){
            if (max<hashMap.get(x)&&!inbanned(banned,x)){
                max=hashMap.get(x);
                result=x;
            }
        }
        return result;
    }

    private static boolean inbanned(String[] banned, String x) {
        for (int i=0;i<banned.length;i++){
            if (x.equals(banned[i])){
                return true;
            }
        }
        return false;
    }
}
