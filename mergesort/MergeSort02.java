package cn.winter.mergesort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2018/8/18 16:07
 */
public class MergeSort02<E extends Comparable<E>> {

    //函数调用得接口,使用至底向上的合并
    public void sort(E[] arr){
        int n = arr.length;
        for (int sz = 1; sz < n ; sz *= 2) {
            for (int i = 0; i < n-sz ; i+=sz+sz) {
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }

    private void merge(E[] arr,int l,int mid,int r){
        E[] aux = Arrays.copyOfRange(arr,l,r+1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l,j = mid + 1;
        for (int k = l; k <= r; k++) {
            if ( i > mid ) {// 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            }
            else if(j > r){ //如果右半部分已经完全处理完毕
                arr[k] = aux[i - l];
                i++;
            }
            else if( aux[i-l].compareTo(aux[j-l])<0){    //左边的元素值比右边的元素值小
                arr[k] = aux[i-l];
                i++;
            }
            else {//左边所指的元素>=右边的元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
    //插入排序
    private void insertSort(E[] arr,int l,int r){
        for (int i = l; i < r+1; i++) {
            for (int j = i; j  >l ; j--) {
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
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        MergeSort02<Integer> integerMergeSort = new MergeSort02<>();
        integerMergeSort.sort(integer);
        System.out.println(Arrays.toString(integer));
    }
}
