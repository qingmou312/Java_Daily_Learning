package 笔试.数美;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: lidan
 * @date: 2019/9/12 18:14
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("D:/test.txt");
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] s = str.split("\t");
            System.out.println(s[1]);
        }
        bf.close();
    }
}