package 笔试.同城;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/12 20:26
 * @Description:
 */

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String ss = scanner.next();
//        count(ss);
//    }
//
//    public static void count(String ss) {
//        String[] strings = ss.split(",");
//        Map<String, Integer> map = new HashMap<>();
//        String string = "";
//        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].endsWith("e") || strings[i].endsWith("d")) {
//                string = strings[i];
//                if (map.containsKey(string)) {
//                    Integer num = map.get(string);
//                    num++;
//                    map.put(string, num);
//                } else {
//                    map.put(string, 1);
//                }
//            }
//        }
//        System.out.println(map.toString());
//    }
//}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        statisticSubStr(input);
    }

    public static void statisticSubStr(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int k = 0;
        int i = 0;
        while (i < arr.length) {
            count = 0;
            char a = arr[i];
            for (int j = i + k - 1; j < arr.length; j++) {
                if (a == arr[j]) {
                    count++;
                }
            }
            if (a == arr[i + 1]) {
                k++;
            }
            i = i + k - 1;
//            if (arr[i] == arr0) {
//                count++;
//                continue;
//            } else {
//                System.out.println(arr0 + ":" + count);
//                arr0 = arr[i];
//                count = 1;
//            }
            System.out.println(a + ":" + count);
        }
//        System.out.println(arr0 + ":" + count);
    }
}
