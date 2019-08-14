package 牛客.Lianxi4_23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String[] str2 = str1.split("_");
            StringBuffer sb = new StringBuffer();
            sb.append(str2[0]);
            for (int i = 1; i < str2.length; i++) {
                if (str2[i].toCharArray().length == 1) {
                    sb.append(str2[i].toUpperCase());
                } else {
                    sb.append(str2[i].substring(0, 1).toUpperCase() + str2[i].substring(1));
                }
            }
            System.out.println(sb.toString());
        }
    }
}