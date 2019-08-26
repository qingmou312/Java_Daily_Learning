package Java5.Tree;


import java.util.*;

/**
 * Author:lidan
 * Created:2019/4/18
 */
public class Tree {
    public class Node {
        public Node node;
        Integer value;
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
//
//    private int find(char[] inorder, char rootValue) {
//        int i = 0;
//        for (i = 0; i < inorder.length; i++) {
//            if (inorder[i] == rootValue) {
//                return i;
//            }
//        }
//        return -1;
//    }

    //二叉树的前序遍历
    List<Integer> preOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.value);
        List<Integer> left = preOrder(root.left);
        List<Integer> right = preOrder(root.right);

        list.addAll(left);
        list.addAll(right);
        return list;
    }

    //求二叉树节点个数
    int node(Node root) {
        if (root == null) {
            return 0;
        }
        int left = node(root.left);
        int right = node(root.right);
        return left + right + 1;
    }

//    //求二叉树的高度
//    int height(Node root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = node(root.left);
//        int right = node(root.right);
//    }

    //求第K层节点的个数
    int kLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int left = kLevel(root.left, k - 1);
        int right = kLevel(root.right, k - 1);
        return left + right;
    }


    //层序遍历
    void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.println(front.value);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    //中序和后序创建二叉树
    Node buildTree(List<Integer> in, List<Integer> post) {
        int rootValue = post.get(post.size() - 1);

        //左子树的节点个数
        int left = in.indexOf(rootValue);

        List<Integer> leftIn = in.subList(0, left);
        List<Integer> leftPost = post.subList(0, left);

        List<Integer> rightIn = in.subList(left + 1, in.size());
        List<Integer> rightPost = post.subList(left + 1, in.size());

        Node root = new Node();
        root.value = rootValue;
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);

        return root;
    }
}
