package NiuKe.Lianxi3_4;

import java.util.*;


/**
 * Author:lidan
 * Created:2019/3/4
 *
 * 对于一个字符串，和字符串中的某一位置，请设计一个算法，将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
 *
 * 给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。
 *
 * 测试样例：
 * "ABCDEFGH",8,4
 * 返回："FGHABCDE"
 */
public class StringRotation {
    public String rotateString(String A, int n, int p) {
        String B=A+A;
        String C=B.substring(p+1,p+n+1);
        return C;
    }

    public static void main(String[] args) {
        String A="ABCDEFGH";
        StringRotation stringRotation=new StringRotation();
        stringRotation.rotateString(A,8,4);
    }
}
