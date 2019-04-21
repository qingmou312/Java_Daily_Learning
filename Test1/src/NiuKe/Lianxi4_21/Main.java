package NiuKe.Lianxi4_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/21
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            list1.add(num);
        }
        System.out.println(list1);
        while (list1 != null) {
            int size = list1.size() - 1;
            for (int i = 0; i < size - 1; i++) {
                list2.add(list1.get(size - i));
                System.out.println(list2);
            }
        }
    }
}
