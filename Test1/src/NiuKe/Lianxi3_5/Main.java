package NiuKe.Lianxi3_5;

/**
 * Author:lidan
 * Created:2019/3/5
 */
public class Main {
    public int[][] XuanZhuan(int[][] arr, int n) {
        int[][] a = new int[n][n];
        if (n < 300) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {
                    a[n-j-1][n-i-1] = arr[i][n-j-1];
                }
            }
            return a;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Main main1 = new Main();

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] a =main1.rotate(arr,3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(a[i][j]);
            }
        }
    }

    public int[][] rotate(int[][] a, int N){
        int[][] b = new int[N][N];
        for(int i = 0; i<N; i++){
            for(int j =0; j< N; j++){
                b[N-j-1][N-i-1] = a[i][N-1-j];
            }
        }
        return b;
    }


}
