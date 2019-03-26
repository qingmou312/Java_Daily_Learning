package NiuKe.Lianxi3_7;

/**
 * Author:lidan
 * Created:2019/3/7
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4
 * 来源：牛客网
 * <p>
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * <p>
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * <p>
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        int count=0;
        char[] arr = A.toCharArray();
        boolean isParenthesis=true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            }
            if (arr[i]==')') {
                count--;
            }
        }
        if (count!=0) {
            return false;
        }
        return  isParenthesis;
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        boolean id = parenthesis.chkParenthesis("(()())", 6);
        System.out.println(id);
    }
}
