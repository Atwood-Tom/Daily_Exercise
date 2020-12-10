public class 柠檬水找零 {
    //链接:https://leetcode-cn.com/problems/lemonade-change/
    public boolean lemonadeChange(int[] bills) {
        int arr[]=new int[3];
        for (int i=0;i<bills.length;i++){
            if (bills[i]==5){
                arr[0]++;
                continue;
            }else if (bills[i]==10){
                if (arr[0]>0){
                    arr[0]--;
                    arr[1]++;
                    continue;
                }else {
                    return false;
                }
            }else if (bills[i]==20){
                if (arr[1]>0&&arr[0]>0){
                    arr[1]--;
                    arr[0]--;
                    arr[2]++;
                    continue;
                }else if (arr[0]>=3){
                    arr[0]-=3;
                    arr[2]++;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        柠檬水找零 x=new 柠檬水找零();
        System.out.println(x.lemonadeChange(new int[]{5,5,5,10,20}));
    }
}
