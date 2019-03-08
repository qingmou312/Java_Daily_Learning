package NiuKe.Lianxi3_4.Lianxi3_8;

/**
 * Author:lidan
 * Created:2019/3/8
 */
public class Transform {
    public String trans(String s, int n) {
        String[] str = s.split("\\ ");
        for (int i = 0; i < str.length; i++) {
            StringBuffer sb = new StringBuffer(str[i]);
            for (int j = 0; j < str[i].length(); j++) {
                char c = str[i].charAt(i);
                if (!Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            sb.toString();
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        String str = transform.trans("Hello World", 11);
        System.out.println(str);
    }
}
