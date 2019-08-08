package 大疆;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        char[] arr = num.toCharArray();
        if (arr.length <= 1) {
            String str=coverNum(arr[0]);
        }
        if (arr.length > 1 && arr.length <= 2) {
            System.out.println(coverShi(arr[0], arr[1]));
        }
        if (arr.length > 2 && arr.length <= 4) {
            System.out.println(coverQian(arr));
        }
        if (arr.length > 4 && arr.length < 9) {
            System.out.println(coverQian(arr) + "万" + coverQian(arr));
        }
        if (arr.length > 9) {
            System.out.println(coverNum(arr[0]) + "亿");
        }
    }

    public static String coverQian(char[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append(coverNum(arr[0]) + "千");
        sb.append(coverNum(arr[1]) + "百");
        sb.append(coverShi(arr[2], arr[3]));
        return sb.toString();
    }

    public static String coverBai(char num1, char num2, char num3) {
        StringBuffer sb = new StringBuffer();
        if (num2 != 0 && num3 != 0) {
            sb.append(coverNum(num1) + "百" + coverNum(num2) + coverNum(num3));
        }
        if (num2 == 0 && num3 == 0) {
            sb.append(coverNum(num1) + "百");
        }
        return sb.toString();
    }

    public static String coverShi(char num1, char num2) {
        StringBuffer sb = new StringBuffer();
        if (num2 != 0) {
            sb.append(coverNum(num1) + "十" + coverNum(num2));
        } else {
            sb.append(coverNum(num1) + "十");
        }
        return sb.toString();
    }

    private static String coverNum(char num) {
        if (num == 0) {
            System.out.println(num);
            return "零";
        } else if (num == 1) {
            return "一";
        } else if (num == 2) {
            return "二";
        } else if (num == 3) {
            return "三";
        } else if (num == 4) {
            return "四";
        } else if (num == 5) {
            return "五";
        } else if (num == 6) {
            return "五";
        } else if (num == 7) {
            return "五";
        } else if (num == 8) {
            return "五";
        } else if (num == 9) {
            return "九";
        } else {
            return String.valueOf(num);
        }
    }
}
