package NiuKe.Lianxi3_8;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/8
 */
public class Main {
    public int buyApple(int n) {
        if (n < 6 || n % 2 != 0 || n == 10) {
            return -1;
        }
        int i = n / 8;
        int j = n % 8;
        if (j == 0) {
            return i;
        } else {
            return 1 + n / 8;
        }
        }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k = main.buyApple(n);
        System.out.println(k);
    }
}

//public class AscentSequence {
//    public static void main(String[] args) {
//        int n=20;
//        int min=n;
//        if(n%2==1) System.out.println("-1");
//        else{
//            for(int i=1;i<n/6;i++){
//                if((n-6*i)%8==0){
//                    int j=(n-6*i)/8;
//                    min=min>(i+j)?(i+j):min;
//                }
//            }
//        }
//
//        System.out.println(min);
//    }
//}
