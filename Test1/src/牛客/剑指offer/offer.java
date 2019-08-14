//package 牛客;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Author:lidan
// * Created:2019/7/31
// */
//public class offer {
//    //在一个二维数组中（每个一维数组的长度相同），
//    // 每一行都按照从左到右递增的顺序排序，
//    // 每一列都按照从上到下递增的顺序排序。
//    // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//    public class Solution {
//        public boolean Find(int target, int[][] array) {
//            int i = 0;
//            int j = 0;
//            boolean result = false;
//            for (i = 0; i < array.length; i++) {
//                for (j = 0; j < array[i].length; j++) {
//                    if (target == array[i][j]) {
//                        result = true;
//                        return result;
//                    }
//                }
//            }
//            return result;
//        }
//    }
//
//    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。
//    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
//    public class Solution {
//        public String replaceSpace(StringBuffer str) {
//            char[] chars = str.toString().toCharArray();
//            StringBuffer stringBuffer = new StringBuffer();
//            for (int i = 0; i < str.length(); i++) {
//                String tmp = String.valueOf(chars[i]);
//                if (tmp.equals(" ")) {
//                    tmp = "%20";
//                }
//                stringBuffer.append(tmp);
//            }
//            return stringBuffer.toString();
//        }
//    }
//    //输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
//    import java.util.ArrayList;
//
//    public class Solution {
//        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//            ArrayList<Integer> arrayList = new ArrayList<>();
//            if (listNode != null) {
//                this.printListFromTailToHead(listNode.next);
//                arrayList.add(listNode.val);
//            }
//            return arrayList;
//        }
//    }
//    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
//
//    /**
//     * Definition for binary tree
//     * public class TreeNode {
//     * int val;
//     * TreeNode left;
//     * TreeNode right;
//     * Tret't'ttteNode(int x) { val = x; }
//     * }
//     */
//
//    public class Solution {
//        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//            TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
//            return root;
//        }
//
//        private TreeNode reConstructBinaryTree(int[] pre, int preStar, int preEnd, int[] in, int inStar, int inEnd) {
//            if (preStar > preEnd || inStar > inEnd) {
//                return null;
//            }
//            TreeNode root = new TreeNode(pre[preStar]);
//            for (int i = inStar; i <= inEnd; i++) {
//                if (in[i] == pre[preStar]) {
//                    root.left = reConstructBinaryTree(pre, preStar + 1, preStar + i - inStar, in, inStar, i - 1);
//                    root.right = reConstructBinaryTree(pre, i - inStar + preStar + 1, preEnd, in, i + 1, inEnd);
//                    break;
//                }
//            }
//            return root;
//        }
//    }
//
//    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//    import java.util.Stack;
//
//    public class Solution {
//        Stack<Integer> stack1 = new Stack<Integer>();
//        Stack<Integer> stack2 = new Stack<Integer>();
//
//        public void push(int node) {
//            stack1.push(node);
//        }
//
//        public int pop() {
//            if (stack2.isEmpty()) {
//                while (!stack1.empty()) {
//                    stack2.push(stack1.pop());
//                }
//            }
//            return stack2.pop();
//        }
//    }
//}
