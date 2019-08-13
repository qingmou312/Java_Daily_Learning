package 笔试.网易.秋季校园招聘2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/3
 * 链接：https://www.nowcoder.com/questionTerminal/83b419c027fa490aa60669b0e7dc06a3?f=discussion
 * 来源：牛客网
 * <p>
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * <p>
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * <p>
 * <p>
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 * 示例1
 * 输入
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * 输出
 * 1
 * 5
 * 3
 * <p>
 * 思路：在输入每堆苹果的同时，计算前面输入的和并放到数组中，再利用二分查找找到所属的堆
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            arr1[i] = input + a;
            a = arr1[i];
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int index = Arrays.binarySearch(arr1, arr2[i]);
            if (index > 0) {
                System.out.println(index + 1);
            } else {
                System.out.println(-index);
            }
        }
    }
}