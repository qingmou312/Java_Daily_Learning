package 牛客.Lianxi4_23;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/23
 */
public class Main2 {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String str1 = in.nextLine();
//            String[] strings = str1.split("[^a-zA-Z]");
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < strings.length; i++) {
//                sb.append(strings[strings.length - 1 - i]);
//                if (strings.length - 1 - i != 0) {
//                    sb.append(" ");
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            // 使用正则表达式作为分割符.
            String[] strArray = str.split("[^a-zA-Z]+");
            for (int i = strArray.length - 1; i >= 2; i--) {
                System.out.print(strArray[i] + ' ');
            }
            if (strArray[0].length() == 0)//如果字符串数组的第一个元素是空串，那么下标为1的元素就是最后一
                System.out.println(strArray[1]);
            else
                System.out.println(strArray[1] + ' ' + strArray[0]);
        }
    }


}
