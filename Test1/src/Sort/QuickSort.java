package Sort;

/**
 * Author:lidan
 * Created:2019/3/9
 */
public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        if (left == right) {
            //只有一个数，有序
            return;
        }
        if (left > right) {
            //没有数,不需要排序
            return;
        }
        int div = Partition(arr, left, right);
        quickSort(arr, left, div - 1);
        quickSort(arr, div + 1, right);

    }

    private int Partition(int[] arr, int left, int right) {
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
}
