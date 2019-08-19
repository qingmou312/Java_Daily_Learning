package 排序;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class Sort {
    //快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left == right) {
            //只有一个数，有序
            return;
        }
        if (left > right) {
            //没有数,不需要排序
            return;
        }
        int div = Partition(arr, left, right);//找到基准值所在的下标
        quickSort(arr, left, div - 1);//递归排序基准值的左边
        quickSort(arr, div + 1, right);//递归排序基准值的右边

    }

    //此方法的目的是找到基准值所在的下标
    private static int Partition(int[] arr, int left, int right) {
        int begin = left;    // 不是 0
        int end = right;    // 不是 right - 1
        int pivot = arr[right];        // pivot 存的就是基准值

        while (begin < end) {
            // 如果基准值在最右边，想先动 begin
            // array[begin] 要 <= 不能 <
            while (begin < end && arr[begin] <= pivot) {
                begin++;
            }
            arr[end] = arr[begin];

            while (begin < end && arr[end] >= pivot) {
                end--;
            }
            arr[begin] = arr[end];
        }
        arr[begin] = pivot;
        return begin;
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        //控制排序要排几趟
        for (int i = 0; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            //控制要排序的书的个数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j; // 记录目前能找到的最小值元素的下标

                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        //从下标为1的元素开始
        for (int i = 1; i < arr.length; i++) {
            //记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];//j-1位置上的数放到j上面，往后搬数据
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        //建堆
        createHeap(arr);
        //减治处理
        for (int i = 0; i < arr.length; i++) {
            //最大的数是[0],最大的数应该放到下标是[length-1-i]
            Swap(arr, 0, arr.length - 1 - i);
            heapify(arr, arr.length - 1 - i, 0);
        }

    }


    private static void createHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    //向下调整
    private static void heapify(int[] arr, int size, int index) {
        while (2 * index + 1 < size) {
            int max = 2 * index + 1;
            if (max + 1 < size && arr[max + 1] > arr[max]) {
                max = 2 * index + 2;
            }
            if (arr[index] < arr[max]) {
                Swap(arr, index, max);
                index = max;
            } else {
                break;
            }
        }
    }

    private static void Swap(int[] arr, int index, int max) {
        int tmp = arr[index];
        arr[index] = arr[max];
        arr[max] = tmp;
    }

    // 希尔排序
    public static void ShellSort(int[] arr) {
        int gap = arr.length;
        while (true) {
            //gap = gap / 2;
            gap = gap / 3 + 1;
            shellSortWithGap(arr, gap);
            if (gap == 1) {
                break;
            }
        }
    }

    private static void shellSortWithGap(int[] arr, int gap) {
        //gap > 1 预排序
        //gap == 1 插排
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - gap; //用来卡每个分组的边界值，方便分组内的数进行交换
            for (; j >= 0 && key < arr[j]; j = j - gap) {
                arr[j + gap] = arr[j];//分组边界值交换
            }
            arr[j + gap] = key;
        }
    }

    //归并排序
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    //合并两个区间为一个区间
    protected static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 3, 8, 4, 5, 9, 7};
//        quickSort(arr, 0, 8);
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        ShellSort(arr);
        System.out.println(Arrays.toString(mergeSort(arr)));
    }


}

