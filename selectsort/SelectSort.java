package cn.winter.selectsort;

import java.util.Arrays;
//https://github.com/liuyubobobo/Play-with-Algorithms/blob/master/02-Sorting-Basic/Course%20Code%20(Java)/01-Selection-Sort/src/bobo/algo/SelectionSort.java
/*
* 选择排序
* */
public class SelectSort<E extends Comparable<E>> {
    public  void selectionSort(E[] arr,int n){
        for (int i = 0; i <n ; i++) {
            int minIndex = i; //默认最小值的下标为i
            for (int j = i; j < n ; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0 )
                    minIndex = j;
            }
            swap(arr,i,minIndex);
        }
    }
    //交换
    private void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        SelectSort<Integer> selectSort = new SelectSort<>();
        selectSort.selectionSort(integer,arr.length);
        System.out.println(Arrays.toString(integer));
    }
}
