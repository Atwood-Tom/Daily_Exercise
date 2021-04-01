import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 商旅出行优惠套餐计算最低成本 {
    /**
     *
     * 商旅出行优惠套餐计算最低成本
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 携程商旅最近上线了一批优惠权益套餐，作为公司的一名采购, 为了降低公司差旅出行成本,  你决定购买员工使用频率较高的各项权益, 因此需要决定购买哪些套餐，不仅需要覆盖要求的具体权益项， 同时确保成本最低.
     * 携程商旅提供n种不同的权益: 酒店优惠券、接送机立减券、超级会员等, value[0], value[1], ... , value[n-1]。
     * 将各类权益组合成权益包进行出售，package[0], package[1], ... , package[m-1]每种权益包可能包含一种或多种权益。
     * 权益包对应的价格分别为price[0], price[1], ... , price[m-1]，price[i]为一个整数，代表第i个权益包对应的价格。
     * 用户指定需要覆盖的k种权益, value[0], value[1], ... , value[k-1]（1<=k<=n）
     * 计算出所需最低花费，即从m个权益包中选取出一种组合，能够满足需要的k种权益，同时成本最低。
     *         如果提供的权益包组合不能满足需要的k种权益，则输出 -1
     * 输入描述
     * 第一行：n(如3种权益, 分别为: 1,2,3, 1<n<10000);
     * 第二行：package[](权益包之间空格隔开，权益之间逗号隔开)；
     * 第三行：price[](权益包对应的价格)；
     * 第四行：value[](用户需要覆盖的具体权益)
     * 输出描述
     * 5(权益包1 + 权益包3，满足需要的权益1,2,3， 对应价格分别为3,2成本最低)
     * 样例输入
     * 3
     * 1,2 2,3 1,3
     * 3 4 2
     * 1 2 3
     * 样例输出
     * 5
     * 提示
     * 样例一共有3种权益 1,2,3；有三种权益组合：(1,2)，(2,3)，(1,3)对应的价格为：3,4,2；你需要的权益为1,2,3。
     * 满足权益组合: 包1 + 包2 = 3 + 4 = 7元， 包1 + 包3 = 3 + 2 = 5元.
     * 满足最低成本: 包1 + 包3 = 3+2
     * 最终输出结果: 5
     *
     */
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        String x=sc.nextLine();
        String y[]=sc.nextLine().split(" ");
        int price[]=new int[y.length];
        for(int i=0;i<price.length;i++){
            price[i]=Integer.parseInt(y[i]);
        }
        String v=sc.nextLine();
        String k[]=v.split(" ");
        int value[]=new int[k.length];
        for(int i=0;i<value.length;i++){
            value[i]=Integer.parseInt(k[i]);
            hashMap.put(value[i],1);
        }
        boolean flag[]=new boolean[arr.length];
        for(int i=0;i<flag.length;i++){
            flag[i]=false;
        }
        int res=Solution(arr,price,value,hashMap,0,flag,v);
        if(res==0){
            System.out.println(-1);
            return;
        }
        System.out.println(Solution(arr,price,value,hashMap,0,flag,v));
    }

    private static int Solution(String[] arr, int[] price, int[] value, HashMap<Integer, Integer> hashMap, int minValue, boolean[] flag, String v) {
        if(Helper(hashMap)){
            return minValue;
        }
        for(int i=0;i<arr.length;i++){
            if(!flag[i]){
                flag[i]=true;
                minValue+=price[i];
                String x[]=arr[i].split(",");
                List<Integer> list=new ArrayList<>();
                for(int o=0;o<x.length;o++){
                    int mid=Integer.parseInt(x[o]);
                    if(v.indexOf(x[o])!=-1&&hashMap.get(mid)!=0){
                        hashMap.put(mid,0);
                        list.add(mid);
                    }
                }
                if(list.size()==0){
                    flag[i]=false;
                    minValue-=price[i];
                    continue;
                }
                res=Math.min(res,Solution(arr,price,value,hashMap,minValue,flag,v));
                flag[i]=false;
                minValue-=price[i];
                for(int o=0;o<list.size();o++){
                    int mid=list.get(o);
                    hashMap.put(mid,1);
                }
            }
        }
        return res;
    }

    private static boolean Helper(HashMap<Integer, Integer> hashMap) {
        for(int key:hashMap.keySet()){
            if(hashMap.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}
