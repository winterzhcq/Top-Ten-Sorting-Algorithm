

import cn.winter.leetcode.q125.Solution;

/**
 * 利用快排的思想寻找第K小的元素
 * @author winter
 * @date 2019/7/11 22:48
 */
public class KthSmallest<E extends Comparable<E>> {
    public  E findKthSmallest(E[] arry,int k){
        if (arry == null || arry.length == 0)
            return null;
        return arry[findKthSmallest(arry,k,0,arry.length - 1)];
    }

    private int findKthSmallest(E[] arry, int k, int left, int right) {
        E temp = arry[left];
        int i = left,j = right;
        while (i != j) {
            while (arry[j].compareTo(temp) >= 0 && i < j)
                j--;
            while (arry[i].compareTo(temp) <= 0 && i < j)
                i++;
            if (i < j) {
                swap(arry, i, j);
                i++;
                j--;
            }
        }
        arry[left] = arry[i];
        arry[i] = temp;
        while (i + 1 != k) {
            if (i + 1 < k) {
                i = findKthSmallest(arry, k,i + 1, arry.length - 1);
            } else {
                i = findKthSmallest(arry, k,0, i - 1);
            }
        }

        return i;
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
        KthSmallest<Integer> kthSmallest = new KthSmallest<>();
        System.out.println(kthSmallest.findKthSmallest(integer,10).toString());

    }
}
