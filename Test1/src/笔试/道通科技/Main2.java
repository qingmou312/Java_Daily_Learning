package 笔试.道通科技;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/10 9:21
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split(" ");
        int sum = 128 + strings.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Integer.toHexString(sum) + " ");
        stringBuffer.append(10 + " ");
        stringBuffer.append("F1 ");
        stringBuffer.append(string);
        System.out.print(stringBuffer.toString());
        String string1 = sum(stringBuffer.toString());
        System.out.print(" " + string1);
    }

    private static String sum(String str) {
        if (str == null || str.equals("")) {
            return "0";
        }
        str = str.replaceAll(" ", "");
        int total = 0;
        int len = str.length();
        if (len % 2 != 0) {
            return "0";
        }
        int num = 0;
        while (num < len) {
            String s = str.substring(num, num + 1);
            total += Integer.parseInt(s, 16);
            num = num + 2;
        }
        return hex2Int(total);
    }

    private static String hex2Int(int total) {
        int a = total / 256;
        int b = total % 256;
        if (a > 255) {
            return hex2Int(a) + Integer.toHexString(b);

        }
        return Integer.toHexString(a) + Integer.toHexString(b);
    }
}
