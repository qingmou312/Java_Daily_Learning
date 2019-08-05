package 网易.练习2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/2
 * 牛牛起床
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * <p>
 * <p>
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * <p>
 * 示例1
 * 输入
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * 输出
 * 6 0
 * 思路：把时间都转换为分钟计数，上课时间-路上时间得到最晚起床时间，
 * 把所有闹钟时间排序后，二分查找最晚起床时间。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int h = 0, m = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            h = in.nextInt();
            m = in.nextInt();
            arr[i] = h * 60 + m;
        }
        int x = in.nextInt();
        h = in.nextInt();
        m = in.nextInt();
        int p=h*60+m-x;
        Arrays.sort(arr);
        x = Arrays.binarySearch(arr,p);
        if(x <0) x = -(x+2);
        h = arr[x]/60;
        m = arr[x]%60;
        System.out.print(h+" "+m);
    }
}
