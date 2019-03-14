package cn.winter.insertsort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2019/3/14 19:13
 */
public class InsertSort03<E extends Comparable<E>> {
    /**
     * 对插入排序的另外一个优化，二分（折半）插入排序
     * 寻找要插入的位置，主要是减少比较次数，如果数据量较小，二分插入排序可能耗时更高
     * 该写法很经典，很多场景都在用该写法，二分查找，适用于快速查找有序数组
     *  for (; j >0 && arr[j-1].compareTo(e)>0; j--)
     *                             arr[j] = arr[j-1];
     *              如果比较比较多，比较耗时
     * @param arr
     */
    public void insertSort(E[] arr){
        for (int i = 1; i < arr.length ; i++) {
            int left = 0;
            int right = i-1;
            E temp = arr[i];
            while (left <= right){
                int mid = left + (right-left)/2;
                if(arr[mid].compareTo(temp)>0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i-1; j >=left ; j--) {
                arr[j+1] = arr[j];
            }
            arr[left] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        InsertSort03<Integer> integerInsertSort03 = new InsertSort03<>();
        integerInsertSort03.insertSort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
