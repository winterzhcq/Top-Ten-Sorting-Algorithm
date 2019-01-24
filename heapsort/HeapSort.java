package cn.winter.heapsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author winter
 * @date 2019/1/21 16:57
 */
public class HeapSort {
    public static void main(String[] args) {
        int n = 20;
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++)
            list.add( random.nextInt(50) );

        Integer arr[] = new Integer[n];
        MaxHeap<Integer> heap = new MaxHeap<>(list);
        for (int i = 0; i < n ; i++) {
            Integer e = heap.extractMax();
            arr[n-i-1] = e;
        }
        System.out.println(Arrays.toString(arr));
    }
}
