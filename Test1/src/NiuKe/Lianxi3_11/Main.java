package NiuKe.Lianxi3_11;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/11
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int w = in.nextInt();
//        int h = in.nextInt();
//        if (w%4==0||h%4==0) {
//            System.out.println(w*h/2);
//        }else{
//            System.out.println(w*h/2+1);
//        }
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = a % b;
        if (c == 0) {
            System.out.println(a);
        }
        int num=getMaxMult(a,b);
        System.out.println(a*b/num);
    }


    private static int getMaxMult(int a, int b) {
        int m = a % b;
        while (m != 0) {
            a = b;
            b = m;
            m = a % b;
        }
        return b;
    }
}
