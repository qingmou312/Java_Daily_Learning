package 牛客.剑指offer;

/**
 * Author:lidan
 * Created:2019/8/5
 * 思路：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
 * 时间复杂度O（logn）
 */
public class Solution7 {
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = Power(base, n >> 1);
        result *= result;
        if (n % 2 == 1) {
            result *= base;
        }
        if (exponent < 0)
            result = 1 / result;
        return result;
    }
}
