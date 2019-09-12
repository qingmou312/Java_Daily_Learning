package 笔试.VIPkid;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/3 16:18
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
//方法2
//            count++;
//            num = num & (num-1);
        }
        System.out.println(count);
    }
}
