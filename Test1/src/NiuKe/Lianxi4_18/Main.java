package NiuKe.Lianxi4_18;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i)) {
                }
                System.out.print(str1.replace(str1.charAt(str2.length()-j),str1.charAt(j)));
            }
        }
    }
}
