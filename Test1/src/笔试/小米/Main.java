package 笔试.小米;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/11 19:34
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        if (str1 == null || str2 == null) {
            return;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars2.length; i++) {
            hashMap.put(chars2[i], 1);
        }
        for (int i = 0; i < chars1.length; i++) {
            if (!hashMap.containsKey(chars1[i])) {
                stringBuilder.append(chars1[i]);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
