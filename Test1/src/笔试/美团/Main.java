package 笔试.美团;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: lidan
 * @date: 2019/9/11 15:56
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res = "";
        while (in.hasNext()) {
            String str = in.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            if(str.length()==1){
                System.out.println(str);
                continue;
            }
            for (int i = 0; i < str.length() - 3; i++) {
                String a = str.substring(i, i + 1);
                String b = str.substring(i + 1, i + 2);
                if (a.equals(b)) {
                    continue;
                } else {
                    String c = str.substring(i + 2, i + 3);
                    if (c.equals(b)) {
                        continue;
                    } else {
                        stringBuffer.append(b);
                    }
                }
            }
            if (stringBuffer.length() == 0) {
                System.out.println("no");
            } else
                System.out.println(stringBuffer.toString());
        }
    }
}
