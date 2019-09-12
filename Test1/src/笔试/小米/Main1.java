package 笔试.小米;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/11 19:50
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            int sum = 0;
            for (int i = 1; i < num; i++) {
                sum = sum + i;
                if (sum == num) {
                    System.out.println(i);
                    break;
                } else if (sum > num) {
                    System.out.println("No");
                    break;
                }
            }
        }
    }
}
