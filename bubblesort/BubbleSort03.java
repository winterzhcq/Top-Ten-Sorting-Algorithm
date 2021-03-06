package cn.winter.bubblesort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/15 9:49
 */

/*
* 冒泡排序第三版，解决循环次数过多的问题
* 时间复杂度O(n*n)
* 稳定排序
* */
public class BubbleSort03<E extends Comparable<E>> {

    public void bubbleSort(E[] arry){
        int k = arry.length -1;
        int n = 0;
        for (int i = 0; i < arry.length; i++) {
            boolean flag = true;
            for (int j = 1;j<=k;j++) {
                if (arry[j].compareTo(arry[j-1])<0) {
                    swap(arry, j, j - 1);
                    flag = false; //有比较就变为false
                    n = j; //记录最后一次置换的位置
                }
            }
            if (flag)//如果已经排好序，直接退出循环
                break;
            k = n;
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
        BubbleSort03<Integer> bubbleSort01 = new BubbleSort03<>();
        bubbleSort01.bubbleSort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
