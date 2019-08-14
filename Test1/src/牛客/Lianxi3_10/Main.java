package 牛客.Lianxi3_10;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        float A = 0f;
        float B = 0f;
        float C = 0f;
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            A = (a + c) / 2f;
            B = (c - a) / 2f;
            C = (d - b) / 2f;
            if ((A - ((a + c) / 2)) != 0) {
                System.out.print("No");
                return;
            }
            if ((B - ((c - a) / 2) != 0) || (B != ((b + d) / 2))) {
                System.out.print("No");
                return;
            }
            if ((C - ((d - b) / 2)) != 0) {
                System.out.print("No");
                return;
            }
            System.out.print((int) A + " " + (int) B + " " + (int) C);
        }
    }
}
