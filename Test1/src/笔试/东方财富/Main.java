package 笔试.东方财富;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/8/6
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y1) * (y1 - y2));
        double b = Math.sqrt(x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
        double c = Math.sqrt(x1 - x3) * (x1 - x3) + (y1 - y3) + (y1 - y3);
        if (a + b > c && a - b < c) {
            double C = a + b + c;
            System.out.println(String.format("%.2Cf", C));
        } else if (a + c > b && a - c < b) {
            double C = a + b + c;
            System.out.println(String.format("%.2Cf", C));
        } else if (b + c > a && b - c > a) {
            double C = a + b + c;
            System.out.println(String.format("%.2Cf", C));

        } else {
            System.out.println("Impossible");
        }
    }
}
