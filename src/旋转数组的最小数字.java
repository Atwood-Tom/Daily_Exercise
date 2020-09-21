public class 旋转数组的最小数字 {
    //链接:https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
    public int minNumberInRotateArray(int [] numbers) {
        if (numbers.length==0){
            return 0;
        }
        int left=0;
        int right=numbers.length-1;
        int mid=0;
        while(left<right){
            if (right-left==1){
                return numbers[right];
            }
            mid=(left+right)/2;
            if (numbers[mid]==numbers[left]){
                int i=left;
                for (;numbers[i]<=numbers[i+1];i++);
                return numbers[i+1];
            }
            if (numbers[mid]>numbers[left]) {
                left=mid;
            }else {
                right=mid;
            }
        }
        return numbers[right];
    }
}
