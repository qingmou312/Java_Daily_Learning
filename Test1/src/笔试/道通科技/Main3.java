package 笔试.道通科技;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/10 10:41
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num <= 0 || num > 7) {
            System.out.println("999");
            return;
        }
        int count = 0;
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                count++;
            }
        }
        System.out.println(count);
        if (count > 49 || count < 0) {
            System.out.println("999");
            return;
        }
        System.out.println(find(num, arr));
    }

    private static int find(int num, int[][] arr) {
        if (arr[0][num - 1] == 1) {
            return 1;
        }
        return find(num, arr) + find(num - 1, arr);
    }
}
