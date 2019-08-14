package 牛客.动态规划;

/**
 * Author:lidan
 * Created:2019/8/6
 * 对于两个字符串，请设计一个时间复杂度为O(m*n)的算法(这里的m和n为两串的长度)，
 * 求出两串的最长公共子串的长度。
 * 这里的最长公共子串的定义为两个序列U1,U2,..Un和V1,V2,...Vn，其中Ui + 1 == Ui+1,Vi + 1 == Vi+1，
 * 同时Ui == Vi。
 * <p>
 * 给定两个字符串A和B，同时给定两串的长度n和m。
 * <p>
 * 测试样例：
 * "1AB2345CD",9,"12345EF",7
 * 返回：4
 * <p>
 * 思路：https://www.cnblogs.com/anzhengyu/p/11166708.html
 */
public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int[][] arr = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                //如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
                if (A.charAt(i - 1) == B.charAt(j - 1)) {//A[0]==B[0],对应dp[1][1]
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    max = Math.max(max, arr[i][j]);
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        return max;
    }
}