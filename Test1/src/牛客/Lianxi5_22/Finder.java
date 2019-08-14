package 牛客.Lianxi5_22;

/**
 * Author:lidan
 * Created:2019/5/22
 */

public class Finder {
    public int findKth(int[] a, int n, int K) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        return a[K - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 2};
        Finder finder = new Finder();
        System.out.println(finder.findKth(a, 5, 3));
    }
}