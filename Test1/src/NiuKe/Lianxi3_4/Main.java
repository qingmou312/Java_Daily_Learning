package NiuKe.Lianxi3_4;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/4
 */
public class Main {

    public boolean isEasy() {
        Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int length = 0;
        while (in.hasNext()) {
            for (int i = 1; i <= first; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (a == 1) {
                    length = length + b;
                }
                if (a == 2) {
                    length = length - b;
                }
            }
        }
        return false;
    }
}
