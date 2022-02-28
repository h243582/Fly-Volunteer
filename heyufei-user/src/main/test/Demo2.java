import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 4, 5, 2, 7, 8},b[];
        int temp = 0, val = 0, right = 0, max = 0, index = 0;
        int r;

        sort(arr, 0, arr.length-1,b);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 分
     * @param arr   待排序数组
     * @param left  左边索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void sort(int[] arr, int left, int right, int[] temp) {
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            //向左递归进行分解
            sort(arr, left, mid, temp);
            //向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //合并
            add(arr, left, mid, right, temp);
        }
    }

    /**
     * 合(排序)
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void add(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;      //左序列的起始位置
        int j = mid + 1;   //右序列的起始位置
        int t = 0;   //指向临时数组的当前索引

        //将两边的数组所有元素整按大小放入临时数组，直到一边全部存入
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将剩余数据的一边的数据依次全部放入临时数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //复制临时数组的数据到原始数组，但不是拷贝所有，只拷贝left到right之间的值
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
