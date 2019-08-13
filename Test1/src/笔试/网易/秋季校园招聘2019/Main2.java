package 笔试.网易.秋季校园招聘2019;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:lidan
 * Created:2019/8/3
 * 链接：https://www.nowcoder.com/questionTerminal/93f2c11daeaf45959bb47e7894047085?f=discussion
 * 来源：牛客网
 * <p>
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * <p>
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * <p>
 * <p>
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 * 示例1
 * 输入
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 * 输出
 * 16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        Stack sum = new Stack();
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr2[i] == 1) {
                sum.push(arr1[i]);
            } else {
                for (int j = 0; j < k; j++) {
                    sum.push(arr1[i + j]);
                    if((i+j)>=n){
                        break;
                    }
                }
                i = i + k;
            }
        }
        max += (int)sum.pop();
        System.out.println(max);
    }
}
