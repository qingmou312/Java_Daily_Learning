package 笔试.奇虎360;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/31 15:16
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            if (n >= 100 && n <= 999 && m > n) {
                int j = 0;
                for (int i = n; i <= m; i++) {
                    int bai = i / 100;
                    int shi = (i - bai * 100) / 10;
                    int ge = i - bai * 100 - shi * 10;

                    if (bai * bai * bai + shi * shi * shi + ge * ge * ge == i) {
                        j = j + 1;
                        if (j > 1) {
                            System.out.print(" " + i);
                        } else {
                            System.out.print(i);
                        }

                    }
                }
                if (j == 0) {
                    System.out.print("no");
                }
                System.out.println();
            }

        }
    }
}
