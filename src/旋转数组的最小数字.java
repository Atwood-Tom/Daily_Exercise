public class 旋转数组的最小数字 {
    //链接:https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(left<right){
            if (right-left==1){
                return array[right];
            }
            mid=(left+right)/2;
            if (array[mid]==array[left]){
                int i=left;
                for (;array[i]<=array[i+1];i++);
                return array[i+1];
            }
            if (array[mid]>array[left]) {
                left=mid;
            }else {
                right=mid;
            }
        }
        return array[right];
    }
}
