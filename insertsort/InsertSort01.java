package cn.winter.insertsort;


import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/15 10:09
 */
/*
* 插入排序第一版
* */
public class InsertSort01<E extends Comparable<E>> {
    public  void insertSort(E[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j >0; j--) {
                if (arr[j].compareTo(arr[j-1])<0)
                    swap(arr,j,j-1);
                else
                    break;
            }
        }
    }
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
        InsertSort01<Integer> integerInsertSort01 = new InsertSort01<>();
        integerInsertSort01.insertSort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
