package 力扣;

/**
 * @author: lidan
 * @date: 2019/8/26 10:27
 * @Description:
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) {
            return "";
        }
        int[] arr = new int[n1 + n2 + 2];
        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int a = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //低位先相加
                a += arr[i + j + 1];//将结果与低位原本有的数相加
                arr[i + j] += a / 10;//低位的进位加到高位上，这里高位上的值可能会超过10,
                // 但是没有关系，这里的高位是之后另外两数相乘的低位，会先加这个结果再取余，就像上面两步。
                // 所以num1和num2从低位开始加就保证了i+j是从小到大的，保证了所有位上的数最终都不过超过10
                arr[i + j + 1] = a % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        //去掉前面的0
        while (i < arr.length - 1 && arr[i] == 0)
            i++;
        for (; i < arr.length; ++i)
            sb.append(arr[i]);
        return sb.toString();
    }
}
