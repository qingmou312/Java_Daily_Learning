package 笔试.道通科技;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: lidan
 * @date: 2019/9/10 8:52
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num <= 0) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                set.add(jiou(i));
                if (num / i != 1) {
                    set.add(jiou(num / i));
                }
            }
        }
        int sum = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            sum += (int) iterator.next();
        }
        System.out.println(sum);
    }

    private static int jiou(int num) {
        if (num % 2 == 1) {
            return num;
        } else {
            return 0;
        }
    }

}
