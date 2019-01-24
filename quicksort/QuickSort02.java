package cn.winter.quicksort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/19 14:49
 */
/*
* 快速排序第二版
* */
public class QuickSort02<E extends Comparable<E>> {

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
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr,l,(int)Math.random()*(r-l+1)+l);
       E v = arr[l];
       // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1,j = r;
        while (true){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 这是因为对于连续出现相等的情况，a方式会交换i和j的值；而b方式则会将连续出现的这些值归为其中一方，使得两棵子树不平衡
            while (i <= r && arr[i].compareTo(v)<0)
                i++;
            while (j >= l+1&& arr[j].compareTo(v)>0)
                j--;
            if (i>j)
                break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }

    //插入排序
    private void insertSort(E[] arr,int l,int r){
        for (int i = l; i <=r ; i++) {
            E e = arr[i];
            int j = i;
            for (; j >l && arr[j-1].compareTo(e)>0 ; j--)
                    arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    //交换两个元素的值
    private void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        QuickSort02<Integer> integerQuickSort = new QuickSort02<>();
        integerQuickSort.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
