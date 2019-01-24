package cn.winter.radixsort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2019/1/24 14:57
 * 参考：https://www.cnblogs.com/skywang12345/p/3603669.html
 */
public class RadixSort {

    // 基数排序
    public void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;
        int max = getMax(arr);

        // 从最低位开始对数组进行排序
        for (int i = 1; max / i > 0 ; i *= 10) {
            sort(arr,i);
        }
    }

    // 对数组不同的位排序，比如分别对个位、十位、百位排序
    private void sort(int[] arr, int exp) {
        // 存储临时的排序数组
        int[] temp = new int[arr.length];
        int[] buckets = new int[10];
        
        // 将各个位出现的次数存放在桶中
        for (int i = 0; i < arr.length; i++) {
            buckets[(arr[i]/exp)%10]++;
        }

        //找到桶与临时temp的关系
       for (int i = 1; i < 10 ; i++) {
            buckets[i] += buckets[i-1];
        }

        // 将数据存储到临时数组temp[]中
        for (int i = arr.length - 1; i >= 0; i--)
        {
            temp[buckets[ (arr[i]/exp)%10 ] - 1] = arr[i];
            buckets[ (arr[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给arr[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

    }

    // 求数组的最大值，方便基数排序是确定最多有几位
    private int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={53, 3, 542, 748, 14, 214, 154, 63, 616};
        RadixSort sort = new RadixSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
