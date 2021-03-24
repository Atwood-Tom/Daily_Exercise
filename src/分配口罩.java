import java.util.Scanner;

public class 分配口罩 {
    /**
     * 某市市长获得了若干批口罩，每一批口罩的数目如下：
     * 9090400
     * 8499400
     * 5926800
     * 8547000
     * 4958200
     * 4422600
     * 5751200
     * 4175600
     * 6309600
     * 5865200
     * 6604400
     * 4635000
     * 10663400
     * 8087200
     * 4554000
     * 现在市长要把口罩分配给市内的 2 所医院。由于物流限制，每一批口罩只
     * 能全部分配给其中一家医院。市长希望 2 所医院获得的口罩总数之差越小越好。
     * 请你计算这个差最小是多少？
     */
    static int sum;
    static int cnt = Integer.MAX_VALUE;
    static int[] value = new int[15];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 15; i++){
            sum += value[i] = in.nextInt();
        }
        dfs(0, 0);
        System.out.print(cnt);
    }

    static void dfs(int d, int v) {
        if (d == 15) cnt = Math.min(cnt, Math.abs(sum - v - v));
        else {
            dfs(d + 1, v + value[d]);
            dfs(d + 1, v);
        }
    }
}
