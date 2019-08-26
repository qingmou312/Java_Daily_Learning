package 笔试.哔哩哔哩;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/20 19:26
 * @Description:
 */
public class Mian2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        System.out.println(a.multiply(b));
    }
}
