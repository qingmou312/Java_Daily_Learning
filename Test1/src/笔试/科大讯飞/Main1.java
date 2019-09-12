package 笔试.科大讯飞;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/9/12 11:26
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        BigInteger num1 = new BigInteger(str1);
        BigInteger num2 = new BigInteger(str2);
        System.out.println(num1.add(num2));
    }
}
