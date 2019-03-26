package NiuKe.Lianxi3_9;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class Shulie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = in.nextInt();
        int k = 2;
        int sum = 2;
        if (j < 1) {
            System.out.println(-1);
        } else {
            if (j == 1) {
                System.out.println(sum);
            } else {
                for (int i = 1; i < j; i++) {
                    k = k + 3;
                    sum = (j * (2 + k)) / 2;
                    System.out.println(sum);
                }
            }
        }
    }
}
