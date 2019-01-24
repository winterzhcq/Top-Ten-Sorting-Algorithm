package cn.winter.heapsort;


import java.util.ArrayList;

/**
 * @author winter
 * @date 2019/1/21 15:49
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(ArrayList<E> data) {
        this.data = data;
        for (int i = parent(data.size() -1); i >=0 ; i--)
            shitDown(i);
    }

    // 返回堆中的元素个数
    public int size(){
        return data.size();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 向堆中添加元素
    public void add(E e){
        data.add(e);
        shiftUp(data.size() -1);
    }

    // 查找堆中最大的元素
    public E findMax(){
        if (data.isEmpty())
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大的元素
    public E extractMax(){
        E e = findMax();
        swap(0,data.size()-1);
        data.remove(data.size() -1);
        shitDown(0);
        return e;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index-1)/2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index*2+1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index*2+2;
    }

    // 上浮操作
    private void shiftUp(int k){
        while (k >0 && data.get(k).compareTo(data.get(parent(k)))>0){
            swap(k,parent(k));
            k = parent(k);
        }
    }

    // 下沉操作
    private void shitDown(int k){
        while (leftChild(k) < data.size()){
            int j = leftChild(k);
            if (j+1 < data.size() && data.get(j).compareTo(data.get(j+1)) < 0)
                j++;
            if (data.get(k).compareTo(data.get(j)) > 0)
                break;
            swap(k,j);
            k = j;
        }
    }

    //交换两个元素
    public void swap(int i, int j){

        if(i < 0 || i >= data.size() || j < 0 || j >= data.size())
            throw new IllegalArgumentException("Index is illegal.");

        E e = data.get(j);
        data.set(j,data.get(i));
        data.set(i,e);
    }

}
