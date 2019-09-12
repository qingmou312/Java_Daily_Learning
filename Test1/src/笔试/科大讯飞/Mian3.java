package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/12 11:34
 * @Description:
 */
public class Mian3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char arr0 = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr0) {
                count++;
                continue;
            } else {
                if (count == 1) {
                    sb.append(arr0);
                    arr0 = arr[i];
                    count = 1;
                } else {
                    sb.append(count);
                    sb.append(arr0);
                    arr0 = arr[i];
                    count = 1;
                }
            }
        }
        if (count != 1) {
            sb.append(count);
            sb.append(arr0);
        } else {
            sb.append(arr0);
        }
        System.out.println(sb.toString());
    }
}
