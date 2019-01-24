package cn.winter.bubblesort;

import cn.winter.selectsort.SelectSort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/15 9:49
 */

/*
* 冒泡排序第一版
* 时间复杂度O(n*n)
* 稳定排序
* */
public class BubbleSort01<E extends Comparable<E>> {

    public void bubbleSort(E[] arry){
        for (int i = 0; i < arry.length; i++) {
            for (int j = 1;j<=arry.length-1-i;j++) {
                if (arry[j].compareTo(arry[j-1])<0)
                    swap(arry,j,j-1);
            }
        }
    }
    //交换两个元素
    private void swap(E[] arry,int i,int j){
        E temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        BubbleSort01<Integer> bubbleSort01 = new BubbleSort01<>();
        bubbleSort01.bubbleSort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
