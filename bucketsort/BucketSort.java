package cn.winter.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 解决计数排序只能对整数排序
 * @author winter
 * @date 2019/1/22 15:40
 */
public class BucketSort {

    public void sort(double[] arr,int bucketCount){
        if (arr == null || arr.length == 0)
            return;
        double max = findMax(arr);
        double min = findMin(arr);

        double range = (max - min+1) / bucketCount;
        ArrayList<Double> [] buckets = new ArrayList[bucketCount];
        //将元素插入桶中
        buckets = insertBucket(buckets,arr,min,max,range);
        //合并桶
        megerBuckets(buckets,bucketCount,arr);
    }
    //查找最大值
    public double findMax(double[] arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    // 查找最小值
    public double findMin(double[] arr){
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = min < arr[i] ? min : arr[i];
        }
        return min;
    }

    // 将元素放入桶中
    public ArrayList<Double>[] insertBucket(ArrayList<Double>[] buckets,double[] arr,double min,double max,double range){
        //把数组中的元素分布在各个桶上
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - min) / range);
            if (buckets[index] == null){//如果当前的桶为空
                buckets[index] = new ArrayList<>();
                buckets[index].add(arr[i]);
            }else {//当前桶不为空，那么就当前桶进行插入排序
                buckets[index].add(arr[i]);
                int k = buckets[index].size() - 1;
                while (k > 0 && buckets[index].get(k-1) > arr[i]){
                    buckets[index].set(k,buckets[index].get(k-1));
                    k--;
                }
                buckets[index].set(k,arr[i]);
            }
        }
        return buckets;
    }
    //合并桶
    public void megerBuckets(ArrayList<Double>[] buckets,int bucketCount,double[] arr){
        //合并各个桶
        int count = 0;
        for (int i = 0; i < bucketCount ; i++) {
            if (buckets[i] != null && buckets[i].size() > 0){
                Iterator<Double> iterator = buckets[i].iterator();
                while (iterator.hasNext()){
                    double d = iterator.next();
                    arr[count] = d;
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) {
        double[] arr = {100,9.87,8,77.66,6,5,4,3,2,1,99,9,8,7,6,5,4,3,2,1};
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
