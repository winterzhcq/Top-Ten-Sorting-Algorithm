package cn.winter.quicksort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2019/1/16 15:23
 */
public class QuickSort04<E extends Comparable<E>> {
    public void sort(E[] arry){
        sort(arry,0,arry.length-1);
    }

    private void sort(E[] arry, int left, int right) {
        if (left>right)
            return;
        E temp = arry[left];
        int i = left,j = right;
        while (i != j){
            while (arry[j].compareTo(temp)>=0 && i<j)
                j--;
            while (arry[i].compareTo(temp)<=0 && i<j)
                i++;
            if (i < j) {
                swap(arry, i, j);
                i++;
                j--;
            }
        }
        arry[left] = arry[i];
        arry[i] = temp;
        sort(arry,left,i-1);
        sort(arry,i+1,right);
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
        QuickSort04<Integer> integerQuickSort = new QuickSort04<>();
        integerQuickSort.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
