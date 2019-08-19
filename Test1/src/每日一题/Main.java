//package EverydayTest.day40;
//
//import java.util.Scanner;
//
///**
// * Author:lidan
// * Created:2019/7/20
// */
//public class AscentSequence {
//    public String Reverse(String sentence) {
//        String[] str1 = sentence.split(" ");
//        StringBuffer str2 = new StringBuffer();
//        for (int i = str1.length - 1; i >= 0; i--) {
//            System.out.println(str1[i]);
//            str2.append(str1[i]);
//            if (i != 0) {
//                str2.append(" ");
//            }
//        }
//        System.out.println(str2.toString());
//        return str2.toString();
//    }
//
//    public static void main(String[] args) {
//        AscentSequence hello = new AscentSequence();
//        Scanner in = new Scanner(System.in);
//        String string = in.nextLine();
//        System.out.println(hello.Reverse(string));
//    }
//}
//
//
//public class Solution {
//    public String replaceSpace(StringBuffer str) {
//        char[] chars = str.toString().toCharArray();
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            String tmp = String.valueOf(chars[i]);
//            if (tmp.equals(" ")) {
//                tmp = "%20";
//            }
//            stringBuffer.append(tmp);
//        }
//        return stringBuffer.toString();
//    }
//}

//
//华老师的n个学生参加了一次模拟测验，考出来的分数很糟糕，但是华老师可以将成绩修改为[0,100]中的任意值，所以他想知道，如果要使所有人的成绩的平均分不少于X分，至少要改动多少个人的分数？
//
//        输入
//
//        第一行一个数T，共T组数据（T≤10）
//
//        接下来对于每组数据：
//
//        第一行两个整数n和X。（1≤n≤1000,0≤X≤100）
//
//        第二行n个整数，第i个数Ai表示第i个学生的成绩。（0≤Ai≤100）
//
//        输出
//
//        共T行，每行一个整数，代表最少的人数。
//
//        样例输入
//        2
//        5 60
//        59 20 30 90 100
//        5 60
//        59 20 10 10 100
//        样例输出
//        1 2

///**
// * 改成绩
// */
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = sc.nextInt();
//            int X = sc.nextInt();
//            int[] record = new int[n];
//            for (int j = 0; j < n; j++) {
//                record[j] = sc.nextInt();
//            }
//            System.out.println(updateNum(record, n, X));
//        }
//    }
//
//    //修改成绩的次数
//    private static int updateNum(int[] record, int n, int x) {
//        int count = 0;
//        while (judge(record, n) < x) {
//            count++;
//            int index = minRecordIndex(record);
//            record[index] = 100;
//        }
//        return count;
//    }
//
//    //找出数组中最小数字的下标
//    private static int minRecordIndex(int[] record) {
//        int index = 0;
//        for (int i = 0; i < record.length; i++) {
//            if (record[index] > record[i])
//                index = i;
//        }
//        return index;
//    }
//
//    //返回平均分
//    private static int judge(int[] record, int n) {
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result += record[i];
//        }
//        return result / n;
//    }
//}


//有n个杀手排成一行，每个杀手都有一个不同的编号(编号为1-n)，在每个夜晚，杀手都会行动，如果某个杀手编号大于他右边的杀手的编号，他就会杀死他右边的杀手，杀手是的行动是瞬间的，因此一个人可能某一个夜晚既杀死了别人又被别人杀死，例如3,2,1这个顺序，在第一个夜晚2会杀死1，同时3也会杀死2。显而易见，一段时间之后，就不会有人杀或被杀，平安夜也就到来了，请问在平安夜之前有多少个夜晚。
//
//        输入
//
//        输入第一行是一个整数n（1≤n≤100000）,表示杀手的数量。
//
//        接下来一行有n个数，是一个1-n的全排列。
//
//        输出
//
//        输出包含一个整数，表示平安夜之前经历了多少个夜晚。
//
//        样例输入
//        10
//
//        10 9 7 8 6 5 3 4 2 1
//        样例输出
//        2
//
//        补充样例
//        输入样例2：
//
//        6
//
//        1 2 3 4 5 6
//        输出样例2 ：
//
//        0
//
//        样例解释： 样例1中杀手的变化为[10 9 7 8 6 5 3 4 2 1]->[10 8 4]->[10]，故答案为2。
//

///**
// * 杀手
// */
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] killer = new int[n];
//        for (int i = 0; i < n; i++) {
//            killer[i] = sc.nextInt();
//        }
//        System.out.println(nightCount(killer, n));
//    }
//
//    private static int nightCount(int[] killer, int n) {
//        int count = 0;
//        while (judge(killer)) {
//            count++;
//            int j = 0;//记录被杀死的人数
//            for (int i = killer.length - 1; i > 0; i--) {
//                if (killer[i] < killer[i - 1]) {
//                    //如果被杀死，置为-1
//                    killer[i] = -1;
//                    j++;
//                }
//            }
//            killer = change(killer, killer.length - j);
//        }
//        return count;
//    }
//
//    //将没有被杀死的人放在数组最前面
//    private static int[] change(int[] killer, int num) {
//        int[] newKiller = new int[num];
//        for (int i = 0, k = 0; i < killer.length; i++) {
//            if (killer[i] != -1) {
//                newKiller[k] = killer[i];
//                k++;
//            }
//        }
//        return newKiller;
//    }
//
//    //判断是否杀人
//    private static boolean judge(int[] killer) {
//        boolean flag = false;
//        for (int i = 1; i < killer.length; i++) {
//            if (killer[i] == -1)
//                continue;
//            if (killer[i - 1] > killer[i]) {
//                flag = true;
//            }
//        }
//        return flag;
//    }
//}