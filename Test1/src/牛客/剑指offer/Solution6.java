package 牛客.剑指offer;

/**
 * Author:lidan
 * Created:2019/8/5
 */
public class Solution6 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
//方法2
//            count++;
//            n = n & (n-1);
        }
        return count;
    }
}
