import java.util.Scanner;
import java.util.Stack;

public class 求回文串 {
    public static void main(String[] args) {
        //Solution1();
        Solution2();
    }

    private static void Solution2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.nextLine();
            int pre = -1;
            int next = -1;
            for (next = 0; next < x.length(); ) {
                if (x.charAt(next) >= 'A' && x.charAt(next) <= 'Z') {
                    if (pre < 0) {
                        int left = next - 1;
                        int right = next + 1;
                        for (; left >= 0 && right < x.length() && x.charAt(left) == x.charAt(right); left--, right++) ;
                        if (left == next - 1) {
                            pre = next;
                            next++;
                        } else {
                            next = 0;
                            pre = -1;
                            x = x.substring(0, left + 1) + x.substring(right, x.length());
                        }
                    } else {
                        int left = pre;
                        int right = next;
                        while (left < right) {
                            if (x.charAt(left) != x.charAt(right)) {
                                break;
                            }
                            left++;
                            right--;
                        }
                        if (left >= right) {
                            x = x.substring(0, pre) + x.substring(next + 1, x.length());
                            next = 0;
                            pre = -1;
                        } else {
                            left = next - 1;
                            right = next + 1;
                            for (; left >= 0 && right < x.length() && x.charAt(left) == x.charAt(right); left--, right++)
                                ;
                            if (left == next - 1) {
                                pre = next;
                                next++;
                            } else {
                                next = 0;
                                pre = -1;
                                x = x.substring(0, left + 1) + x.substring(right, x.length());
                            }
                        }
                    }
                } else {
                    next++;
                }
            }
            System.out.println("不删除小写字母"+x);
            x=Solution1(x);
            System.out.println("删除小写"+x);
        }
    }

    private static void Solution1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            int num = 0;
            char c = '0';
            for (int i = 0; i < x.length(); i++) {
                if (i == 0) {
                    c = x.charAt(i);
                    continue;
                }
                if (stack.isEmpty() && c != x.charAt(i)) {
                    stack.add(c);
                    c = x.charAt(i);
                    continue;
                }
                if (c == x.charAt(i) || x.charAt(i) == stack.peek()) {
                    num++;
                    continue;
                } else {
                    stack.add(c);
                    c = x.charAt(i);
                }
            }
            stack.add(c);
            String res = "";
            while (!stack.isEmpty()) {
                res = stack.pop() + res;
            }
            System.out.println(res + "  " + num);
        }
    }

    private static String Solution1(String x) {
        Stack<Character> stack = new Stack<>();
        int num = 0;
        char c = '0';
        for (int i = 0; i < x.length(); i++) {
            if (i == 0) {
                c = x.charAt(i);
                continue;
            }
            if (stack.isEmpty() && c != x.charAt(i)) {
                stack.add(c);
                c = x.charAt(i);
                continue;
            }
            if (c == x.charAt(i) || x.charAt(i) == stack.peek()) {
                num++;
                continue;
            } else {
                stack.add(c);
                c = x.charAt(i);
            }
        }
        stack.add(c);
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
