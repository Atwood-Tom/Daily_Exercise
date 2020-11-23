public class 数组中的逆序对 {
    public int count(int[] A, int n) {
        // write code here
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (A[i]>A[j]){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        数组中的逆序对 x=new 数组中的逆序对();
        System.out.println(x.count(new int[]{1,2,3,4,5,6,7,0},8));
    }
}
