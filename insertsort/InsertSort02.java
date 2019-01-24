package cn.winter.insertsort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/15 10:54
 */
public class InsertSort02<E extends Comparable<E>> {
    public  void insertSort(E[] arr){
        for (int i = 0; i <arr.length ; i++) {
            E e = arr[i];
            int j = i;
            for (; j >0 && arr[j-1].compareTo(e)>0; j--)
               arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        InsertSort02<Integer> integerInsertSort02 = new InsertSort02<>();
        integerInsertSort02.insertSort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
