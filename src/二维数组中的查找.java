public class 二维数组中的查找 {
    //链接:https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
    public boolean Find(int target, int [][] array) {
        int i=0;
        int j=array[0].length-1;
        for (;i<array.length&&j>=0;){
            if (array[i][j]>target){
                j--;
            }else if (array[i][j]<target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
