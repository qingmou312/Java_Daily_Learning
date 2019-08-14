package 牛客.Lianxi3_12;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/12
 */
public class LCA {
    public int getLCA(int a, int b) {
        while (a!=b){
            if(a>b){
                a=a/2;
            }
            if(a<b){
                b=b/2;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        LCA lca = new LCA();
        System.out.println(lca.getLCA(a, b));
    }
}
