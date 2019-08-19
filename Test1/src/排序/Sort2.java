//package 排序;
//
///**
// * @author: lidan
// * @date: 2019/8/16 9:59
// * @Description:
// */
//public class Sort {
//    //几个排序
////快排  堆排序 希尔排序  归并排序 插入排序，选择排序
//
////快速排序
////以下所有的排序都是从小到大排序
//
//    //不稳定 时间复杂度O(nlgn)空间复杂度O(1) 最坏时间复杂度O(n^2)当序列基本或者完全趋于有序
//    void qsort(int a[].int low, int high) {
//        int privot = partition(a, low, high);          //找到枢轴
//        qsort(a, low, privot - 1);                        //先递归快速排序枢轴的左面
//        qsort(a, privot + 1, high);                       //后递归快速排序枢轴的右面
//    }
//
//    //这个函数的目的是找到枢轴的位置
//    int partition(int a[], int low, int high) {
//        int k = a[low];                               //这里记录下枢轴这里以a[low]作为枢轴，这里有个技巧就是一直左右扫描
//        //把枢轴的位置记录下来之后再原数组刚好缺一个空位，
//        //所以一直把high位置的放在low位置上
//        //同样把low位置的放在high位置上最后会有一个空位置放上枢轴
//        while (low < high) {
//            while (low < high && a[high] >= k) --high;    //从后往前扫描当扫描到第一个比他小的数字停下来
//            a[low] = a[high];                          //把high位置上找到的那个比枢轴小的数放在low位置上/第一次放在枢轴的位置
//            while (low < high && a[low] <= k) ++low;      //从前往后扫描当扫描到第一个比比他大的停下来
//            a[high] = a[low];                          //把low位置上找到的那个比枢轴大的数放在high位置上
//        }
//        a[low] = k;                                     //把枢轴放到正确的位置上
//        return low;                                     //返回枢轴的正确位置的下标
//    }
//
//    //堆排序                                              这里演示的是大根堆
//// 不稳定 时间复杂度O(nlgn) 空间复杂度O(1)
//    void heapsort(int a[], int length) {
//        buildmaxheap(a, length);                         //初始化堆这个时候第一个元素是最大值
//        for (int i = length; i >= 1; --i) {
//            swap(a[1], a[i]);
//            //每次都把第一个元素和建好的大根堆的最后一个元素互换这样
//            //就把堆中最大的元素放到最后面去了
//            adjust(a, 1, i - 1);                            //换完之后再继续调整堆
//        }
//    }
//
//    void buildmaxheap(int a[], int length)               //这里是初始化堆的代码 这里是从下往上调整堆
//    {
//        for (int i = length / 2; i >= 1; --i)                //这里为什么是length/2因为在完全二叉树中第一个双亲节点的下标是length/2
//        {
//            adjust(a, i, length);                         //从第一个双亲节点一直到根节点调整堆
//        }
//    }
//
//
//    //希尔排序
////不稳定 时间复杂度为O(n^1.3) 空间复杂度O(1)
//    void shellsort(int a[], int length) {
//        for (int dk = length / 2; dk >= 1; dk = dk / 2)        //这里是用dk表示的是步长，而希尔说步长为length/2最好，以后每次为原来的一半
//        {                                               //从这里开始其实就是插入排序只不过他是分开以dk为步长的系统的插入排序
//            for (int i = dk + 1; i < length; ++i)            //这里记录的是步长之外的第二部分
//            {
//                int num = a[i];                         //这里记录一下要插入的元素用num记录一下
//                int j;                                  //这里的j是为了记录插入的位置
//                if (a[i] < a[i - dk])                      //当发现i位置的元素小于他前面的系统的元素就需要往前移
//                {
//                    for (j = i - dk; j >= 1 && num < a[j]; j = j - dk) //这里就是移动元素的代码 把比a[i]大的通通往后移动
//                    {
//                        a[j + dk] = a[j];
//                    }
//                }
//                a[j + dk] = num;                           //把num放在它合适的位置
//
//            }
//        }
//    }
//
//    //归并排序
////稳定  时间复杂度O(nlgn)   空间复杂度O(n)
//    void mergesort(int a[], int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2                    //找到中间的位置
//            mergesort(a, low, mid);                       //递归的归并排序前半部分
//            mergesort(a, mid + 1, high);                    //递归的归并排序后半部分
//            merge(a, low, mid, high);                      //把前半部分和后半部分合并排序
//        }
//    }
//
//    void merge(int a[], int low, int mid, int high)        //这里是合并的代码
//    {
//        int b[ maxsize];                                 //用一个辅助的数组存储原来的数组的数
//        int t = 0;                                      //这里是用来记录a数组新排序的元素的下标
//        for (int k = low; k < high; ++k)                     //把a数组元素复制到b数组中
//            b[k] = a[k];
//        int i = low;                                    //i 从low开始到mid这个是归并的前半部分
//        int j = mid + 1;                                 //j 从mid+1开始到high这个是归并的后半部分
//        for (; i < mid && j < high; ++t)                         //把前半部分和后半部分合并排序
//        {
//            if (b[i] <= b[j])                              //当b[i](前半部分的)小于或等于b[j]后半部分的
//                a[t] = b[i++];                          //取较小者赋给a[t]
//            else
//                a[t] = b[j++];
//        }
//        while (i < mid)                                  //当归并排序完i<mid说明前半部分还有一些没有排完插入到a数组后面即可
//        {
//            a[t++] = a[i++];
//        }
//        while (j < high)                                 //当归并排序完j<high说明后半部分还有一些没有排完插入到a数组后面即可
//        {
//            a[t++] = a[j++];
//        }
//    }
//
//    //插入排序
////稳定 时间复杂度O(n^2)空间复杂度O(1)
//    void insertsort(int a[], int length) {
//        for (int i = 2; i < length; ++i)                  //这里从第二个数开始排序把第i个数插入最前面的i-1个数的最合适的位置
//        {
//            int k = a[i];                              //记录第i个元素或者记录待插入值
//            if (a[i] < a[i - 1])                          //若带插入值比前面的值小说明需要找到合适位置插入
//            {
//                for (int j = i - 1; j > 1 && a[j] > a[i - 1]; --j)  //循环找到需要插入的合适的位置把比带插入值大的数往后移动
//                {
//                    a[j + 1] = a[j];
//                }
//            }
//            a[j + 1] = k;                                //待插入值放在合适的位置
//        }
//    }
//
//    //选择排序
////不稳定  时间复杂度O(n^2)空间复杂度O(1)
//    void selectsort(int a[], int length) {
//        for (int i = 1; i <= length; ++i) {
//            int min = i;
//            for (int j = i; j <= length; ++j) {
//                if (a[j] < a[min])
//                    min = j;
//            }
//            if (min != i)
//                swap(a[min], a[i]);
//        }
//
//    }
//}
