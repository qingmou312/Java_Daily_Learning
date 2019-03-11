package Tencent.Tencent;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两行。
 * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 * <p>
 * 输出描述:
 * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 * <p>
 * 输入例子1:
 * 3
 * 2 7 4
 * <p>
 * 输出例子1:
 * 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int yangyang=0;
        int niuniu =0;
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        if (n < 1 || n > 105) {
            System.out.println("您的输入有误，请重新输入。");
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] < 1 || arr[i] > 109) {
                    System.out.println("您的输入有误，请重新输入。");
                }
            }
        }
        arr=BubbleSort(n,arr);
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                yangyang=arr[i]+yangyang;
            }
            else {
                niuniu =niuniu +arr[i];
            }
        }
        System.out.println(niuniu-yangyang);

    }

    public static int[]  BubbleSort(int n, int[] arr){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }
}
