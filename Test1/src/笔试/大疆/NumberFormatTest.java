package 笔试.大疆;

/**
 * Author:lidan
 * Created:2019/8/9
 */
public class NumberFormatTest {

    static String[] units = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿",
            "十亿", "百亿", "千亿", "万亿"};
    static char[] numArray = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};

    public static void main(String[] args) {
        int num = 10000;
        String numStr = foematInteger(num);
        System.out.println( "num= " + num + ", 转换结果: " + numStr);
    }

    private static String foematInteger(int num) {
        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;
        System.out.println("----" + len);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String m = val[i] + "";
            int n = Integer.valueOf(m);
            boolean isZero = n == 0;
            String unit = units[(len - 1) - i];
            if (isZero) {
                if ('0' == val[i - 1]) {
                    //当前val[i]的下一个值val[i-1]为0则不输出零
                    continue;
                } else {
                    //只有当当前val[i]的下一个值val[i-1]不为0才输出零
                    sb.append(numArray[n]);
                }
            } else {
                sb.append(numArray[n]);
                sb.append(unit);
            }
        }
        return sb.toString();
    }
}