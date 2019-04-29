package Java5;

import java.util.Arrays;

/**
 * Author:lidan
 * Created:2019/4/27
 */
public class Sort {
    /**
     * 直接插入
     * 时间复杂度
     * 最好O(n)
     * 平均O(n^2)
     * 最坏O(n^2)
     * <p>
     * 空间复杂度
     * O(1)
     *
     * @param array
     */
    public static void insertSort1(int[] array) {
        //1.最外层循环，一次让一个数有序，所以需要length
        for (int i = 0; i < array.length; i++) {
            /**
             * 有序[0,i)
             * 无序[i,array.length)
             */
            //2.在有序区间遍历查找到合适的位置,从后往前
            int j;
            //把array[i]所在的数据插入并找到的合适的位置处
            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {
            }
            int pos = j + 1;
            int key = array[i];
            //数据往后搬
            for (int k = i; k > j + 1; k--) {
                array[k] = array[k - 1];
            }
            array[pos] = key;
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //有序 [0,i)
            // 无序[i,array.length)

            //1. 在有序区间遍历查找，从后往前
            int j;
            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {
            }
            //1. j + 1  就是要插入的数据下标
            //2. 插入数据，从后往前搬移数据
            int pos = j + 1;
            int key = array[i];
            for (int k = i; k > pos; k--) {
                array[k] = array[k - 1];
            }
            array[pos] = key;
        }
    }

    //重点
    public static void insertSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }

    //希尔排序
    public static void insertSort3(int[] array, int gap) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0 && key < array[j]; j = j - gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度
     * 最好情况O(n)
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
    }


    public static void Swap(int[] array, int min, int i) {
        int tmp = array[min];
        array[min] = array[i];
        array[i] = tmp;

    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            //最终交换一次
            Swap(array, min, i);
        }

    }


    /**
     * 向下调整
     *
     * @param array
     * @param size
     * @param index
     */
    private static void heapify(int[] array, int size, int index) {
        while (2 * index + 1 < size) {
            int max = 2 * index + 1;
            if (max + 1 < size && array[max + 1] > array[max]) {
                max = 2 * index + 2;
            }
            if (array[index] < array[max]) {
                Swap(array, index, max);
                index = max;
            } else {
                break;
            }

        }
    }

//    private static void heapify(int[] tree, int size, int index) {
//        /**
//         * 1.判断index位置是不是叶子节点
//         * 完全二叉树，只要判断有没有左孩子
//         * 转换成数组下标越界的问题去判断
//         */
//        int left = 2 * index + 1;
//        if (left >= tree.length) {
//            return;
//        }
//
//        /**
//         * 不是叶子节点，意味着一定有左孩子，但不一定有右孩子
//         * 2.找到最大的一个孩子
//         */
//        int right = 2 * index + 2;
//        int max = left;
//        if (right < tree.length && tree[right] > tree[max]) {
//            max = right;
//        }
//        /**
//         * 3.交换
//         */
//        if (tree[index] > tree[max]) {
//            return;
//        } else {
//            int tmp = tree[index];
//            tree[index] = tree[max];
//            tree[max] = tmp;
//        }
//        heapify(tree, tree.length, max);
//    }

    /**
     * 建堆
     *
     * @param array
     */
    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }

    }


    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        //建堆
        createHeap(array);
        //减治处理
        for (int i = 0; i < array.length; i++) {
            //最大的数是[0],最大的数应该放到下标是[length-1-i]
            Swap(array, 0, array.length - 1 - i);
            heapify(array, array.length - 1 - i, 0);
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSort = true;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    Swap(array, j, j - 1);
                    isSort = false;
                }
            }
            if (isSort == true) {
                break;
            }
        }

    }

    /**
     * 快速排序
     * 1.选择基准值(选择区间最右边的数作为基准)
     * 2.遍历整个区间，每个数都和基准值做比较，并且发生一定交换
     * 遍历结束后，使得
     * 比基准值大的数（包括等于）都在基准值的右边
     * 比基准值小的数（包括等于）都在基准值的左边
     * 3.分治算法
     * 分别对左右两个小区间进行同样的方式处理
     * 知道小区间的size==0或者小区间的size==1(有序)
     * <p>
     * 如何小的放左，大的放右  Partition(分段)
     * 1.Hover:基准值在右，从左边先走
     * 2.挖坑
     * 3.前后下标
     *
     * @param array
     */
    public static void quickSort(int[] array, int left, int right) {
//        if (left > right) {
//            return;
//        }
        quickSortInner(array, 0, array.length - 1);
    }

    private static void quickSortInner(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSortInner(array, left, pivotIndex - 1);
        quickSortInner(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            Swap(array, begin, end);
        }
        Swap(array, begin, right);
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 8, 2, 4, 7, 3};
        System.out.println(Arrays.toString(arr));
//        insertSort1(arr);
//        selectSort(arr);
//        bubbleSort(arr);
//        heapSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
