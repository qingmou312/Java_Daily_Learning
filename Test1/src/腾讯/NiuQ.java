package 腾讯;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class NiuQ {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int s=in.nextInt();
        if(n<1||n>2000||s<1||s>2000){
            System.out.println("您的输入有误");
        }

    }
    public int isSuccess(int n,int m){//n是小q的牌，m是牛妹的牌
        if(n==m){
            return 0;
        }
        if(n==0&&m==1){
            return m;
        }
        if(n==0&&m==2){
            return n;
        }
        if(n==1&&m==2){
            return m;
        }
       return  0;
    }
}
