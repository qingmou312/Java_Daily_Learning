package 牛客.Lianxi3_24;


/**
 * Author:lidan
 * Created:2019/3/24
 */
public class Main {
    public static void main(String[] args) {

        Integer a = 0;
        double b = 0;
        for (int i = 1; i <= 30; i++) {
            a += 10;
            b = b + Math.pow(2, i - 1);
        }
        System.out.print(a + " " + b);
    }
}
