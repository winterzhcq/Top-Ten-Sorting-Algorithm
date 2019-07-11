

/**
 * @author winter
 * @date 2019/7/11 23:17
 */
public class KthLargest {
    /**
     * 采用归并的思想，和快排的的思想比较相像
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0,right = nums.length-1;
        k = nums.length -k;
        while (left < right){
            int j = pattern(nums,left,right);
            if ( j < k)
                left = j + 1;
            else if ( j > k)
                right = j - 1;
            else
                break;
        }
        return nums[k];
    }

    private int pattern(int[] nums, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        //swap(nums,l,(int)(Math.random()*(l-r+1))+l);
        int e = nums[l];
        int lt = l; //arr[l+1...lt] < v
        int gt = r+1; //arr[gt...r] > v
        int i = l+1; //arr[lt+1...i] == v
        while ( i < gt){
            if (nums[i] < e){
                swap(nums,i,lt+1);
                i++;
                lt++;
            }
            else if ( nums[i] > e){
                swap(nums,i,gt-1);
                gt--;
            }
            else {
                i++;
            }
        }
        swap(nums,l,lt);
        return lt;
    }
    //交换两个元素的值
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
