package NiuKe.Lianxi3_13;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int d = in.nextInt();
            for (int a = 0; a < 100 / 5; a++) {
                for (int b = 0; b < 100 / 3; b++) {
                    for (int c = 0; c < 100; c += 3) {
                        if ((5 * a + 3 * b + c / 3 == 100) && a + b + c == 100) {
                            System.out.println(a + " " + b + " " + c);
                        }
                    }
                }
            }
            in.close();
        }
    }
}
