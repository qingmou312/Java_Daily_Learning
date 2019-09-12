package 笔试.途家;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/6 22:17
 * @Description:
 *
 * 题目描述：
 * 法师住在喜马拉雅上脚下的一个村庄，突然一天，发生大雪崩，很快村庄就要被掩埋，所有人将会遇难。
 *
 * 法师的跑步的速度为13m/s,以这样的速度，是无法逃离雪崩的。但是，法师有闪跳技能，可在1s内移动50m,每次使用技能后，会消耗10点魔法值。魔法值的恢复速度为4点/s,只有在原地休息状态时才能够恢复。
 *
 * 现已知法师初始值为M,所在位置与安全区域的距离为S,雪崩到达村庄的时间为T。
 *
 * 编写一个程序，计算法师如何在最短的时间内到达安全区域，如不能够逃脱，输出法师在时间内走的最远距离。
 *
 * 输入
 * 输入一行，包括空格隔开的三个非负整数M，S，T。
 *
 * 输出
 * 输出两行:
 *
 * 第1行为字符串"Yes"或"No" (区分大小写)，即守望者是否能逃离荒岛。
 *
 * 第2行包含一个整数，第一行为"Yes" (区分大小写）时表示守望着逃离荒岛的最短时间
 *
 * 第一行为"No" (区分大小写) 时表示守望者能走的最远距离。
 *
 *
 * 样例输入
 * 36 255 10
 * 样例输出
 * Yes 10
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int M = in.nextInt();
//        int S = in.nextInt();
//        int T = in.nextInt();
//        int a = 0;
//        int b = 0;
//        for (int i = 1; i <= T; i++) {
//            a += 13;
//            if (M >= 10) {
//                M -= 10;
//                b += 50;
//            } else {
//                M += 4;
//            }
//            a = Math.max(a, b);
//            if (a >= S) {
//                System.out.println("Yes " + i);
//                return;
//            }
//        }
//        System.out.println("No " + a);
//    }
//}
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int S = in.nextInt();
        int T = in.nextInt();
        int d1 = 0;
        int d2 = 0;
        for (int i = 1; i <= T; i++) {
            if (M >= 10) {
                d1 += 50;
                M -= 10;
            } else {
                M += 4;
            }
            d2 += 13;
            d2 = Math.max(d1, d2);
            if (d2 >= S) {
                System.out.println("Yes " + i);
                return;
            }
        }
        System.out.println("NO " + d2);
        return;
    }
}
