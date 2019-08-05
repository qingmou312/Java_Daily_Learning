package 腾讯;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class Niuniu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  max = in.nextInt();
        int  price = in.nextInt();
        System.out.println(min(max,price));
//        if (n < 1 || n > 100000 || m < 1 || m > 1000000000) {
//            System.out.println("请重新输入");
//        } else {
//            if(m%n==0){
//                System.out.println(m/n);
//            }else {
//                System.out.println((m/n)+1);
//            }
//        }
    }
    public static int min(int max,int price) {

        if (price <= max) {
            return 1;
        }
        else {
            return price/max+min(max,price%max);
        }
    }
}
