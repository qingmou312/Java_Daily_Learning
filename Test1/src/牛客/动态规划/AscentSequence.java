package 牛客.动态规划;

/**
 * Author:lidan
 * Created:2019/8/6
 * 最长递增子序列
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，
 * 返回该序列的最长上升子序列的长度，
 * 这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 * <p>
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 * <p>
 * 测试样例：
 * [2,1,4,3,1,5,6],7
 * 返回：4
 */


public class AscentSequence {
    public int findLongest(int[] A, int n) {
        int[] arr = new int[n];//A数组中前i个元素中最长递增子序列
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}


//    public static int findLongest(int[] A, int n) {
//        // 以[2,1,4,3,1,5,6]为例。使用i来表示当前遍历的位置：
//        // i = 1 时，最长递增序列为{1} ，序列长度为1
//        // i = 2时，1 < 2 所以得丢弃2 重新建立最长递增序列{1}，序列长度为1
//        // i = 3时，4>2,4>1 最长递增序列为{2，4} {1，4},长度为2
//        // 以此类推，可得：d[i+1] = max{1,d[k]+1},其中对于所有的k<= i ,A[i+1] > A[k]
//        // d[i] 表示A数组的前i个元素当中，最长递增序列的长度
//        int[] d = new int[n];
//        for (int i = 0; i < n; i++) {
//            d[i] = 1; // 初始化默认长度
//            for (int j = 0; j < i; j++) { // 前面最长的序列
//                if (A[i] > A[j] && d[j] + 1 > d[i]) { // 增加了当前的数之后，大于原来的长度，就更新
//                    d[i] = d[j] + 1;
//                }
//            }
//        }
//        int maxDis = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            if (d[i] > maxDis) {
//                maxDis = d[i];
//            }
//        }
//        return maxDis;
//    }.