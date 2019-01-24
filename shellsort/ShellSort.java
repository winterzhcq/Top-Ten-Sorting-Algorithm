package cn.winter.shellsort;

import java.util.Arrays;

/**
 * @author winter
 * @date 2019/1/21 23:15
 */
public class ShellSort<E extends Comparable<E>> {
    /**
     * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
     * 是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。该方法因D.L.Shell于1959年提出而得名。
     * 时间复杂度未知，不稳定，解决插入排序有大量无序数的时候，也反应了插入排序适合有序数的排序
     * @param arr
     */
    public void sort(E[] arr){
        if (arr == null || arr.length ==0)
            return;
        //注意这里不是对每一个分组进行单独排序，这里是对两个或则多个分组依次交叉进行插入排序
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            //看做插入排序只是步长发生了变化，也就是插入的选择是跳跃性的
            for (int i = gap; i <arr.length ; i++) {
                E e = arr[i];
                int j ;
                for (j=i-gap; j >=0 && e.compareTo(arr[j])<0  ; j-= gap) {
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = e;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> shellSort = new ShellSort<>();
        int[] arr = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2,69,99};
        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            integer[i] = arr[i];
        }
        shellSort.sort(integer);

        System.out.println("希尔排序后数组：");
        System.out.println(Arrays.toString(integer));

    }
}
