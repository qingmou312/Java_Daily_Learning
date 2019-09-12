package 笔试.奇虎360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/15 20:33
 * @Description:
 */
public class Main2 {

    public static void main(String args[]) {
        int m;
        double sum, n;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum = sum + n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }
    }
}
