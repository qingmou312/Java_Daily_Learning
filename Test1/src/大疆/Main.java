package 大疆;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        String[] numStr = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿"};
        char[] numArray = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            String val = arr[i] + "";
            int m = Integer.valueOf(val);
            boolean isZero = m == 0;
            String unit = numStr[(len - 1) - i];
            if (isZero) {
                if ('0' == arr[i - 1]) {
                    continue;
                } else {
                    if (arr[len - 1] != '0') {
                        sb.append(numArray[m]);
                    }
                }
            } else {
                sb.append(numArray[m]);
                sb.append(unit);
            }
        }
        System.out.println(sb.toString());
    }
}