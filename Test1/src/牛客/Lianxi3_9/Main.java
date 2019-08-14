package 牛客.Lianxi3_9;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class Main {
    public int[] square(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入数组的长度：");
        int k=in.nextInt();
        int[] arr= new int [k];
        System.out.print("请输入数组的元素:");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }
        Main main = new Main();
        int[] a = main.square(arr);
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j]+" ");
        }
    }
}
