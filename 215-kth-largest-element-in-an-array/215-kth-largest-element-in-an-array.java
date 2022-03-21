

import java.util.Random;

class Solution {
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickSelect(0, size - 1, size - k);
    }

    private int quickSelect(int left, int right, int kSmallest) {
        if(left == right) return this.nums[left];
        Random randomNum = new Random();
        int pivotIndex = left + randomNum.nextInt(right - left);
        pivotIndex = partition(left, right, pivotIndex);
        if(kSmallest == pivotIndex) return this.nums[kSmallest];
        else if(kSmallest < pivotIndex) return quickSelect(left, pivotIndex - 1, kSmallest);
        else return quickSelect(pivotIndex + 1, right, kSmallest);
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivot = this.nums[pivotIndex];
        swap(pivotIndex, right);
        int storeIndex = left;

        for(int i = left; i <= right; i++) {
            if(this.nums[i] < pivot) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }

        swap(storeIndex, right);
        return storeIndex;
    }

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }
}