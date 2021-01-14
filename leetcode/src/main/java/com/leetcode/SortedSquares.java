/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * **/

package com.leetcode;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        if (nums[length - 1] < 0) {
            for (int i = 0; i < length; i++) {
                output[i] = nums[length - i - 1] * nums[length - i - 1];
            }
            return output;
        } else {
            int positive_counter = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] < 0) {
                    positive_counter++;
                }
            }
            if (positive_counter == 0) {
                for (int i = 0; i < length; i++) {
                    output[i] = nums[i] * nums[i];
                }
                return output;
            }
            int negative_counter = positive_counter - 1;
            int output_counter = 0;
            while (negative_counter >= 0 && positive_counter < length) {
                if (Math.abs(nums[negative_counter]) > Math.abs(nums[positive_counter])) {
                    output[output_counter] = nums[positive_counter] * nums[positive_counter];
                    positive_counter++;
                    output_counter++;
                } else {
                    output[output_counter] = nums[negative_counter] * nums[negative_counter];
                    negative_counter--;
                    output_counter++;
                }
            }
            while (negative_counter >= 0) {
                output[output_counter] = nums[negative_counter] * nums[negative_counter];
                negative_counter--;
                output_counter++;
            }
            while (positive_counter < length) {
                output[output_counter] = nums[positive_counter] * nums[positive_counter];
                positive_counter++;
                output_counter++;
            }
            return output;
        }
    }
}
