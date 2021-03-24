public class 矩形覆盖 {
    //链接:https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6
    public int RectCover(int target) {
        if (target<3){
            return target;
        }
        int[] arr =new int[target+1];
        arr[1]=1;
        arr[2]=2;
        for (int i=3;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[target];
    }
}
