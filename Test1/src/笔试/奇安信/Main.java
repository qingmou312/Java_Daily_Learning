package 笔试.奇安信;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/9 19:30
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num<=0){
            return;
        }
        if (num % 5 == 0) {
            System.out.println(num / 5);
        } else {
            int a = num / 5;
            int b = num % 5;
            int sum = 0;
            if (b == 1) {
                sum = a + 1;
            } else {
                sum = a + 2;
            }
            System.out.println(sum);
        }
    }
}
