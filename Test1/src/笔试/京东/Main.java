package 笔试.京东;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/23 9:44
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/23a0c9e5b3eb4f37b9615766f0286e0c?f=discussion
 * 来源：牛客网
 * <p>
 * 现在有红，绿两种颜色的石头，现在我们需要用这两种石头搭建一个塔，塔需要满足如下三个条件：  1． 第1层应该包含1块石头，第2层应该包含两块，第 i 层需要包含 i 块石头。  2． 同一层的石头应该是同一个颜色（红或绿）。  3． 塔的层数尽可能多。  问在满足上面三个条件的前提下，有多少种不同的建造塔的方案，当塔中任意一个对应位置的石头颜色不同，我们就认为这两个方案不相同。石头可以不用完。
 * <p>
 * <p>
 * 输入描述:
 * 输入仅包含两个正整数，分别表示红和绿砖块的数量a，b（0<=a,b<=2*10^5,a+b>=1）。
 * <p>
 * <p>
 * 输出描述:
 * 输出和仅包含一个正整数，表示不同的方案数对1000000007取模的结果。
 * 示例1
 * 输入
 * 4 6
 * 输出
 * 2
 */


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int G = in.nextInt();
        int R = in.nextInt();
        int min = Math.min(R, G);
        int max = Math.max(R, G);
        R = min;
        G = max;
        int level = 1, sum = 0;
        /**
         * level 为最大层数
         */
        while (sum <= R + G) {
            level++;
            sum += level;
        }
        /**
         * array[i][j]表示前i层有j个绿色宝石的方案数
         * 那么可以得出递推式 array[i][j]=array[i-1][j-i]+array[i-1][j];
         * 针对第i层来说，如果第i层放置绿色宝石，那么前i-1层就只能放j-i个绿色宝石，所以为array[i-1][j-i]
         * 如果第i层不放置绿色宝石，而放红色宝石，那么前i-1层就放j个绿色宝石，为array[i-1][j]
         * 所以没有必要保存所有的状态，只需要保存上一层和当前层的状态即可
         */
        int[][] array = new int[2][G + 1];
        int answer = 0;
        if (G > 0) {
            array[1][1] = 1;
            answer++;
        }
        if (R > 0) {
            array[1][0] = 1;
            answer++;
        }
        int total = 1;
        int result;
        /**
         * total是前lev层所需要的石头总数量，不分颜***r />          */
        for (int lev = 2; lev < level; lev++) {
            total += lev;
            result = 0;
            /**
             * one代表当前层
             * two代表上一层
             */
            int one = lev % 2;
            int two = (lev - 1) % 2;
            /**
             * 遍历在当前层放置的绿色宝石的数量
             */
            for (int i = 0; i <= total && i <= G; i++) {
                array[one][i] = 0;
                /**
                 * 当放在第lev层是绿色宝石的时候，那么
                 * array[one][i]+=array[two][i-lev]
                 * 因为本来就只有i颗绿色宝石，你在lev层放置了lev颗之后，那么前lev-1层只能放置i-lev颗绿色宝石
                 * 而前lev-1层只能放置i-lev颗绿色宝石为array[two][i-lev]
                 */
                if (i >= lev && R >= total - i) {
                    array[one][i] += array[two][i - lev];
                    if (array[one][i] >= 1000000007) {
                        array[one][i] %= 1000000007;
                    }

                }
                /**
                 * 当放在第lev层是红色宝石的时候，那么
                 * array[one][i]+=array[two][i]
                 * 因为本来就只有i颗绿色宝石，你在lev层没有放置绿色宝石，那么就是说在lev-1层放置了lev颗绿色宝石
                 * 而前lev-1层只能放置lev颗绿色宝石为array[two][lev]
                 */
                if (total - i <= R) {
                    array[one][i] += array[two][i];
                    if (array[one][i] >= 1000000007) {
                        array[one][i] %= 1000000007;
                    }
                }
                /**
                 * 因为one代表的是当前层，所以把它累加起来即可得出最终结果
                 */
                if (array[one][i] != 0) {
                    result += array[one][i];
                    if (result >= 1000000007) {
                        result %= 1000000007;
                    }
                }
            }
            answer = result;
        }
        System.out.println(answer);
        in.close();
    }
}