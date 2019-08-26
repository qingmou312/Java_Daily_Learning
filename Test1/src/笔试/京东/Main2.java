package 笔试.京东;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/24 19:32
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        int count = 1;
        if (n == 1) {
            if (isBig(str)) {
                System.out.println("2");
            } else {
                System.out.println("1");
            }
        } else {
            for (int i = 0; i < str.length() - 2; i++) {
                String string = String.valueOf(str.charAt(i));
                String string1 = String.valueOf(str.charAt(i + 1));
                String string2 = String.valueOf(str.charAt(i + 2));
                if (isBig(string)) {
                    if (!isBig(string1)) {
                        if (isBig(string2)) {
                            count += 1;
                        } else {
                            count += 2;
                        }
                    } else {
                        if (i == 0) {
                            count = count + 1;
                        }
                        count += 1;
                    }
                } else {
                    if (isBig(string1)) {
                        count += 2;
                        if (!isBig(string2)) {
                            count += 1;
                        }
                    } else {
                        count += 1;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isBig(String str) {
        if (str.toUpperCase().equals(str)) {
            return true;
        } else {
            return false;
        }
    }
}
