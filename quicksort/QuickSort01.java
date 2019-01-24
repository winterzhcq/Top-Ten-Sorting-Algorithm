package cn.winter.quicksort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/19 14:49
 */
/*
* 快速排序第一版
* */
public class QuickSort01<E extends Comparable<E>> {

    //快速排序的调用接口
    public void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }
    //快排的具体实现
    private void sort(E[] arr,int l,int r){
        if (l-r<=15){
            insertSort(arr,l,r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }
    //快速排序的处理逻辑
    private int partition(E[] arr,int l,int r){
        E v = arr[l];
        int j = l;
        for (int i = l; i <= r ; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    //插入排序
    private void insertSort(E[] arr,int l,int r){
        for (int i = l; i <=r ; i++) {
            for (int j = i; j >l ; j--) {
                if (arr[j].compareTo(arr[j-1])<0)
                    swap(arr,j,j-1);
                else
                    break;
            }
        }
    }
    //交换两个元素的值
    private void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        QuickSort01<Integer> integerQuickSort = new QuickSort01<>();
        integerQuickSort.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
