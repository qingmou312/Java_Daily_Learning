package Test1;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/2/19
 */
public class XiaoYi {
    public static void main(String[] args) {
        int count = 1;
        int x=0;
        Scanner in = new Scanner(System.in);
        while(count<=100000){
            System.out.println("请输入位置（范围为1--1000000006）：");
            x=in.nextInt();
            x= 4*x+3;
            if(x/1000000007==0){
                System.out.println(count);
                break;
            }else{
                x=8*x+7;
                if(x/1000000007==0){
                    System.out.println(count);
                    break;
                }
            }
            count++;
        }
        if(count>100000){
        System.out.println("-1");
        }
    }
}
