package cn.winter.quicksort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/19 14:49
 */
/*
* 快速排序第二版
* */
public class QuickSort03<E extends Comparable<E>> {

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
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr,l,(int)(Math.random()*(l-r+1))+l);

        E v = arr[l];

        int lt = l; //arr[l+1...lt] < v
        int gt = r+1; //arr[gt...r] > v
        int i = l+1; //arr[lt+1...i] == v
        while (i<gt){
            if (arr[i].compareTo(v)<0){
                swap(arr,i,lt+1);
                i++;
                lt++;
            }
            else if (arr[i].compareTo(v)>0){
                swap(arr,i,gt-1);
                gt--;
            }
            else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort(arr,l,lt-1);
        sort(arr,gt,r);
    }
    //插入排序
    private void insertSort(E[] arr,int l,int r){
        for (int i = l; i <=r ; i++) {
            E e = arr[i];
            int j = i;
            for (; j >l&&arr[j-1].compareTo(e)>0 ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j]=e;
        }
    }
    //交换两个元素的值
    private void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        QuickSort03<Integer> integerQuickSort = new QuickSort03<>();
        integerQuickSort.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
