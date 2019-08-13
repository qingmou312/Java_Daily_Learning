package 笔试.网易.秋季校园招聘2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/3
 * 小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
 * 荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
 * 有一天，小易又开了一局游戏，当玩到第 m 个方块落下时他觉得太无聊就关掉了，
 * 小易希望你告诉他这局游戏他获得的分数。
 *
 * 链接：https://www.nowcoder.com/questionTerminal/9407e24a70b04fedba4ab3bd3ae29704?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 输入描述:
 * 第一行两个数 n, m
 * 第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
 * 其中 1 <= n, m <= 1000, 1 <= ci <= n
 *
 *
 * 输出描述:
 * 小易这局游戏获得的分数
 * 示例1
 * 输入
 * 3 9
 * 1 1 2 2 2 3 1 2 3
 * 输出
 * 2链接：https://www.nowcoder.com/questionTerminal/9407e24a70b04fedba4ab3bd3ae29704?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 输入描述:
 * 第一行两个数 n, m
 * 第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
 * 其中 1 <= n, m <= 1000, 1 <= ci <= n
 *
 *
 * 输出描述:
 * 小易这局游戏获得的分数
 * 示例1
 * 输入
 * 3 9
 * 1 1 2 2 2 3 1 2 3
 * 输出
 * 2
 *
 * 思路：在小易输入的一组数据中找每列出现的个数，放到列的数组里，找到最小值，就是小易获得的最小值。
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        int min = 0;
        for (int i = 0; i < m; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < m; j++) {
                if (arr1[j] == (i + 1)) {
                    k = k + 1;
                }
            }
            arr2[i] = k;
        }
        Arrays.sort(arr2);
        System.out.println(arr2[0]);

    }
}
