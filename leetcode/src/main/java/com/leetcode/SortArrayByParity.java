package com.leetcode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int start =0;
        int end = length-1;
        if (length==0||length==1){
            return A;
        }
        while (start<end){
            if (A[start]%2==0){
                start++;
            }
            else {
                if (A[end]%2==0){
                    swap(A, start, end);
                }
                end--;
            }
        }
        return A;
    }
    
    private void swap(int[] nums, int source, int target){
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}