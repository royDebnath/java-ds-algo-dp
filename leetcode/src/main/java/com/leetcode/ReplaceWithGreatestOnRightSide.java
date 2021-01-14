package com.leetcode;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
class ReplaceWithGreatestOnRightSide {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        if (length==1){
            arr[0]=-1;
            return arr; 
        }
        int max_from_right = arr[length-1];
        arr[length-1] = -1;
        for (int i = length-2; i>=0; i--){
            int temp = arr[i];
            arr[i] = max_from_right;
            if (temp> max_from_right){
                max_from_right=temp;
            }
        }
        return arr;
    }
}