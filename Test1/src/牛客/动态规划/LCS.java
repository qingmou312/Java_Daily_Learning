package 牛客.动态规划;

/**
 * Author:lidan
 * Created:2019/8/6
 * 对于两个字符串，请设计一个高效算法，求他们的最长公共子序列的长度，
 * 这里的最长公共子序列定义为有两个序列U1,U2,U3...Un和V1,V2,V3...Vn,
 * 其中Ui&ltUi+1，Vi&ltVi+1。且A[Ui] == B[Vi]。
 * <p>
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * <p>
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                //如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
                if (A.charAt(i - 1) == B.charAt(j - 1)) {//A[0]==B[0],对应dp[1][1]
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[n][m];
    }
}
