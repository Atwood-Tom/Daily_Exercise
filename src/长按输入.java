public class 长按输入 {
    //链接:https://leetcode-cn.com/problems/long-pressed-name/
    public static boolean isLongPressedName(String name, String typed) {
        int i=0;int j=0;
        for (;i<name.length()&&j<typed.length();j++){
            if (name.charAt(i)==typed.charAt(j)){
                i++;
                continue;
            }else if (i-1>=0&&name.charAt(i-1)==typed.charAt(j)){
                continue;
            }else {
                return false;
            }
        }
        if (j<typed.length()){
            for (;j<typed.length();j++){
                if (name.charAt(i-1)!=typed.charAt(j)){
                    return false;
                }
            }
        }
        return i >= name.length();
    }

    public static void main(String[] args) {
        String name="";
        String typed="";
        name = "pyplrz"; typed = "ppyypllr";
        System.out.println(isLongPressedName(name,typed));
    }
}
