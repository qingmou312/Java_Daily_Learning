package NiuKe.剑指offer;

/**
 * Author:lidan
 * Created:2019/8/5
 * 链接：https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1?f=discussion
 * 来源：牛客网
 * <p>
 * 解题思路：
 * 1.需利用逻辑与的短路特性实现递归终止。
 * 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
 * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
 * public int Sum_Solution(int n) {
 * int sum = n;
 * boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
 * return sum;
 * }
 */
public class Solution8 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
