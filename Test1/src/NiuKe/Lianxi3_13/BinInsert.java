package NiuKe.Lianxi3_13;


/**
 * Author:lidan
 * Created:2019/3/13
 */
public class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        int mask = ~(((1 << (i - j + 1)) - 1) << j);  //111->111000->000111;对后面的没有影响
        n &= mask;  //i～j位置为0
        n |= (m << j);
        return n;
    }

    public static void main(String[] args) {
        BinInsert bin = new BinInsert();
        System.out.println(bin.binInsert(1024, 19, 2, 6));
    }
}
