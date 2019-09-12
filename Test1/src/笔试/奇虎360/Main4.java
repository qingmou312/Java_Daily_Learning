package 笔试.奇虎360;


import java.util.*;

/**
 * @author: lidan
 * @date: 2019/8/31 16:29
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            arr[tmp - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i );
        }
        System.out.println(max);
    }
}
