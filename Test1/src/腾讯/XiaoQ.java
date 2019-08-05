package 腾讯;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class XiaoQ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer q = in.nextInt();
        if (q < 1 || q > 100000) {
            System.out.println("您的输入有误，请重新输入");
        } else {
            Integer[][] arr = new Integer[q][2];
            Integer []sum = new Integer[ q];
            for (Integer i = 0; i < q; i++) {
                Integer l = in.nextInt();
                Integer r = in.nextInt();
                if (l < 1 || l > 1000000000 || r < 1 || r > 1000000000 || l > r) {
                    System.out.println("您的输入有误，请重新输入");
                    break;
                }
                arr[i][0] = l;
                arr[i][1] = r;
                sum[i]=(arr[i][0] +arr[ i][1])/2;
                if ((l % 2 != 0) && (r % 2 != 0)) {
                    sum[i]=-sum[i];
                }
            }
            for (Integer j=0; j < q; j++) {
                System.out.println(sum[ j]);
            }
        }
    }
}
