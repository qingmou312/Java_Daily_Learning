package 笔试.网易.秋季校园招聘2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/3
 * 链接：https://www.nowcoder.com/questionTerminal/3e483fe3c0bb447bb17ffb3eeeca78ba?answerType=1&f=discussion
 * 来源：牛客网
 * <p>
 * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 * 1
 * 2
 * 3
 * 4
 * 1+2*3=7
 * 1*(2+3)=5
 * 1*2*3=6
 * (1+2)*3=9
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 * <p>
 * 输入描述:
 * 一行三个数a，b，c (1 <= a, b, c <= 10)
 * <p>
 * <p>
 * 输出描述:
 * 能够获得的最大值
 * 示例1
 * 输入
 * 1 2 3
 * 输出
 * 9
 *
 *
 * 思路:最大值*剩余两数加或乘的最大值
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int max = arr[2];
        int sum = max * ((arr[0] * arr[1]) > (arr[0] + arr[1]) ? (arr[0] * arr[1]) : (arr[0] + arr[1]));
        System.out.println(sum);
    }
}
