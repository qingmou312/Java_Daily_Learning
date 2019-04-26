package Sort;

/**
 * Author:lidan
 * Created:2019/4/25
 */
public class SelectSort {
//    private static void selectSort(int[] array) {
//        /**
//         * 每次选择一个最大的数，放到无序部分的最后
//         * 需要选n(或者n-1)次
//         */
//        for (int i = 0; i < array.length; i++) {
//            int max = 0;
//            for (int j = 0; j < array.length - i; j++) {
//                if (array[j] < array[max]) {
//                    max = j;
//                }
//            }
//
//        }
//    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            
            for (int j = 0; j < i; j++) {

            }

        }

    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
