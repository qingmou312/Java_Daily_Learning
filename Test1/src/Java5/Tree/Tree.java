package Java5.Tree;


import java.util.Arrays;

/**
 * Author:lidan
 * Created:2019/4/18
 */
public class Tree {
    public class Node {
        public Node node;
        char value;
        public Node left;
        public Node right;

        public Node root;
        public int used;
    }

    /**
     * 利用前序+中序构建二叉树
     * 1.在前序中找到根的值preOrder[0]
     * 2.在中序中找到根节点的值所在的下标
     *                   左子树的节点个数
     * 3.切除左子树的前序+中序
     * preOrder跳过1，长度是下标
     *
     *
     */

    /**
     * 利用中序+后序构建二叉树
     * 1.在后序中找到根节点的值preOrder[posterOrder-1]
     * 2.在中序中找到根节点的值所在的
     */

//    Node buildTree(char[] inorder, char[] postorder) {
//        char rootValue = postorder[postorder.length - 1];
//        Node root = new Node(rootValue);
//        int leftSize = find(inorder, rootValue);
//
//        char[] leftInorder= Arrays.copyOfRange(inorder,0,leftSize);
//        char[] leftPostorder=Arrays.copyOfRange(postorder,0,leftSize);
//
//        root.left=buildTree(leftInorder,leftPostorder);
//
//        char[] rightInorder=Arrays.copyOfRange(inorder,)
//
//
//    }

    private int find(char[] inorder, char rootValue) {
        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }
}
