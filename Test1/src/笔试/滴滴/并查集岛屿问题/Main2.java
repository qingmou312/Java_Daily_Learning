package 笔试.滴滴.并查集岛屿问题;

import java.util.Scanner;

/**
 * @author: lidan
 * @date: 2019/8/26 14:25
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/1ecd3d9e09664cde94919b65ea06b47c?f=discussion
 * 来源：牛客网
 * <p>
 * 给定一个m行n列的二维地图, 初始化每个单元都是水.
 * 操作addLand 把单元格(row,col)变成陆地.
 * 岛屿定义为一系列相连的被水单元包围的陆地单元, 横向或纵向相邻的陆地称为相连(斜对角不算).
 * 在一系列addLand的操作过程中, 给出每次addLand操作后岛屿的个数.
 * 二维地图的每条边界外侧假定都是水.
 * <p>
 * 输入描述:
 * 多组测试数据，请参考例题处理 每组数据k+3行, k表示addLand操作次数 第一行:表示行数m 第二行:表示列数n 第三行:表示addLand操作次数k 第4~k+3行:row col 表示addLand的坐标。注意超过边界的坐标是无效的。
 * <p>
 * <p>
 * 输出描述:
 * 一行,k个整数, 表示每次addLand操作后岛屿的个数, 用空格隔开，结尾无空格
 * 示例1
 * 输入
 * 3
 * 3
 * 4
 * 0 0
 * 0 1
 * 1 2
 * 2 1
 * 输出
 * 1 1 2 3
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] land = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    land[i][j] = -2;
            int res = 0;
            for (int k = sc.nextInt(); k > 0; k--) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (x < m && x >= 0 && y < n && y >= 0 && land[x][y] == -2) {
                    land[x][y] = -1;
                    res++;
                    if (x > 0 && land[x - 1][y] != -2 && merge(land, x, y, x - 1, y)) res--;
                    if (x < m - 1 && land[x + 1][y] != -2 && merge(land, x, y, x + 1, y)) res--;
                    if (y > 0 && land[x][y - 1] != -2 && merge(land, x, y, x, y - 1)) res--;
                    if (y < n - 1 && land[x][y + 1] != -2 && merge(land, x, y, x, y + 1)) res--;
                }
                if (k != 1) System.out.print(res + " ");
                else System.out.println(res);
            }
        }
        sc.close();
    }

    private static boolean merge(int[][] land, int x1, int y1, int x2, int y2) {
        int n = land[0].length;
        while (land[x2][y2] != -1) {
            int tmp = land[x2][y2];
            x2 = tmp / n;
            y2 = tmp % n;
        }
        if (x1 == x2 && y1 == y2) return false;
        else {
            land[x2][y2] = x1 * n + y1;
            return true;
        }
    }
}

//遍历数组，遇到陆地1的时候，递推访问它的上下左右相邻的陆地，然后将它们置为2，递推完成后岛屿个数加一。
//岛屿的数量
class Solution {
    public int numIslands(char[][] grid) {
        int islandNum = 0;//岛屿的数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    public void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
}
