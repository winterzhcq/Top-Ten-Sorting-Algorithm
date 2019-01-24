package cn.winter.countsort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2019/1/22 11:11
 */
public class CountSort {
    //不使用泛型的原因是该排序只支持对整数且有边界的数排序
    public void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;
        int max = arr[0];
        int min = arr[0];
        int[] newArr = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        newArr = new int[ max - min+1];
        for (int i = 0; i < arr.length ; i++) {
            newArr[arr[i]- min]++;
        }
        int count = 0;
        for (int i = 0; i < newArr.length ; i++) {
            for (int j = 0; j < newArr[i] ; j++) {
                arr[count++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1};
        CountSort countSort = new CountSort();
        countSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
