package 牛客.Lianxi3_4;

/**
 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
 * <p>
 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
 * <p>
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
 * 返回：[1,2,3,6,5,4,7,8,9,12,11,10]
 * <p>
 * Author:lidan
 * Created:2019/3/4
 */
public class Printer {
    public int[] printMatrix(int[][] mat, int n, int m) {
        int[] arr= new int[n*m];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    arr[m*i+j]=mat[i][j];
                }
            }else {
                for (int j = 0; j < m; j++) {
                    arr[m*i+j]=mat[i][m-j-1];
                }
            }
        }

        for (int z = 0; z < n * m; z++) {
            System.out.println(arr[z]);
        }
        return arr;
    }

    public static void main(String[] args) {

        Printer printer = new Printer();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        printer.printMatrix(mat, 4, 3);
    }
}
