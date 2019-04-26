package Java5.Heap;

/**
 * Author:lidan
 * Created:2019/4/25
 */
public class Heap {
    /**
     * 向下调整
     * 必须满足可以向下调整的前提：只有一个位置不满足堆
     *
     * @param tree  看成二叉树的数组
     * @param index 要调整位置的下标
     */
    private static void heapif(int[] tree, int index) {
        /**
         * 1.判断index位置是不是叶子节点
         * 完全二叉树，只要判断有没有左孩子
         * 转换成数组下标越界的问题去判断
         */
        int left = 2 * index + 1;
        if (left >= tree.length) {
            return;
        }

        /**
         * 不是叶子节点，意味着一定有左孩子，但不一定有右孩子
         * 2.找到最大的一个孩子
         */
        int right = 2 * index + 2;
        int max = left;
        if (right < tree.length && tree[right] > tree[max]) {
            max = right;
        }
        /**
         * 3.交换
         */
        if (tree[index] > tree[max]) {
            return;
        } else {
            int tmp = tree[index];
            tree[index] = tree[max];
            tree[max] = tmp;
        }
        heapif(tree, max);
    }

    /**
     * 向上调整
     * @param array
     * @param size
     * @param index
     */

    public void adjustUp(int[] array, int size, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (parent < 0) {
                return;
            }
            if (array[parent] >= array[index]) {
                break;
            }
            int tmp = array[parent];
            array[parent] = array[index];
            array[index] = tmp;
            index = parent;
        }
    }

    public static void main(String[] args) {
        int[] arr = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
    }
}
