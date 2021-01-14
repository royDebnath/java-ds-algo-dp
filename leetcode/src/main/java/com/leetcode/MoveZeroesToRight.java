package com.leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
class MoveZeroesToRight {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length==0 || length==1){
            return;
        }
        for (int i=0,j=i+1;i<j && j<=length-1;){
            if(nums[i]==0 && nums[j]!=0){
                swap(nums, i, j);
                i++;
                j++;
            }
            else if(nums[i]==0 && nums[j]==0){
                j++;
            }
            else {
                i++;j++;
            }
        }

    }
    
    private void swap(int[] nums, int source, int target){
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}