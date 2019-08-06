package NiuKe.剑指offer;

/**
 * Author:lidan
 * Created:2019/8/5
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 采用循环
 */
public class Solution2 {
    public int Fibonacci(int n) {
        int a = 1;
        int b = 0;
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = a + b;
            b = a;
            a = result;

        }
        return result;
    }
}
