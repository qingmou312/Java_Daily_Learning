package 笔试.招商银行;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/15 21:07
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        if(l<0||r>1000000000){
            return;
        }
        if (l > r) {
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (i < j) {
                    int z = (i * j) % 2019;
                    min = Math.min(min, z);
                }
            }
        }
        System.out.println(min);
    }
}
