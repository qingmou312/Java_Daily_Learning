package 牛客.字符串中连续最长的数字串;

import java.util.*;

/**
 * @author: lidan
 * @date: 2019/8/12 20:24
 * @Description:
 * 链接：https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d
 * 来源：牛客网
 * <p>
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 * <p>
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 * <p>
 * <p>
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1
 * 输入
 * abcd12345ed125ss123456789
 * 输出
 * 123456789
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int count = 0, max = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                System.out.println(str.charAt(i));
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }

        List<Integer> list = new ArrayList<>();
        System.out.println(str.substring(end - max + 1, end + 1));
    }
}