package CVTE;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/4/15
 */
public class Copy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String msg = in.nextLine();
        int count = in.nextInt();
        char[] msgArr = msg.toCharArray();
        char[] newMsg = new char[msgArr.length];
        int[] key = {1, 2, 0};
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < key.length; j++) {
                newMsg[j] = msgArr[key[j]];
            }
            msgArr = newMsg;
        }
        System.out.println(msgArr);
    }

}

