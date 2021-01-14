package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SolutionTest {
    @Test
    void test() {
        int input1 =-2147483648;
        isPalindrome("__p)09&m;:asdfhf%af6%");
        //assertArrayEquals(output, new int[]{4,2,1,3});

    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = s.length();
        for (int i = 0; i< length /2; i++){
            if (s.charAt(i) != s.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length() || s==null || t==null){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        int count[] = new int[26];
        System.out.println((int)'z');
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)-'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        for (Character c : frequency.keySet()){
            if (frequency.get(c)==1){
                return s.indexOf(c);
            }
        }
        return -1;
    }


    public int reverse(int x) {
        /**
         * This code is performing integer division by 10, which truncates any decimal portion.
         * When dividing Integer.MAX_VALUE (2147483647) by 10, the code anticipates multiplying by 10 and adding the next digit.
         * That quotient is 214748364, and multiplying by 10 is 2147483640, with the possibility of adding another 7 without
         * overflowing. Similarly on the negative side, dividing Integer.MAX_VALUE (-2147483648) by 10 yields -214748364,
         * multiplying by 10 yields -2147483640, with the possibility of adding another -8 without overflowing.
         *
         * This code takes into account the last digit of the extremes of the range of Integer values and carefully avoids overflow.
         */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0; // rev*10+pop can never be > 2147483647
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0; // rev*10+pop can never be < 2147483648
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i=0;i<length/2;i++){
            swap(s, i, length-i-1);
        }
    }

    private void swap(char[] chars, int source, int target) {
        char temp = chars[source];
        chars[source] = chars[target];
        chars[target] = temp;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int row = 0; row <= 9; row++) {
            for (int col = 0; col <= 9; col++) {
                char current_value = board[row][col];
                if (current_value != '.') {
                    if (!seen.add(current_value + "is seen in row : " + row)
                            || !seen.add(current_value + "is seen in col : " + col)
                            || !seen.add(current_value + "is seen in cube : " + row / 3 + col / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        /**
         * Input Format
         * {
         * {1,2,3},
         * {4,5,6},
         * {7,8,9}
         * }
         */
        /**
         * Output Format
         * {
         * {7,4,1},
         * {8,5,2},
         * {9,6,3}
         * }
         */
        int length = matrix.length;
        System.out.println("Input Array" + "\n");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
        /**Step 1 : Make the rows into columns and vice versa by swapping matrix[i][j] with matrix [j][i]
         * {1,2,3},
         * {4,5,6},
         * {7,8,9}
         *
         * will become
         *
         * {1,4,7},
         * {2,5,8},
         * {3,6,9}
         *
         * */
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) { // initiate j with i not 0, else swap will happen twice making it the same
                swap2d(matrix, i, j);
            }
        }
        System.out.println("Intermediate Array" + "\n");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
        /**
         * Now reverse each row to get the final result:
         * {1,4,7},
         * {2,5,8},
         * {3,6,9}
         *
         * will become
         *
         * {7,4,1},
         * {8,5,2},
         * {9,6,3}
         */
        for (int[] row : matrix) {
            int row_length = row.length;
            for (int i = 0; i < row_length / 2; i++) {
                swap(row, i, length - i - 1);
            }
        }
        /** Print the final Output**/
        System.out.println("Output Array" + "\n");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private void swap2d(int[][] matrix, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int addendum = 1;
        int carry = 1;
        int lastDigit = digits[length - 1];
        int lastAfterAddition = lastDigit + addendum;
        if (lastAfterAddition <= 9) {
            digits[length - 1] = lastAfterAddition;
            return digits;
        } else {
            digits[length - 1] = lastAfterAddition % 10;
            for (int i = length - 2; i >= 0; i--) {
                int temp = digits[i] + carry;
                if (temp <= 9) {
                    digits[i] = temp;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] result = new int[length + 1];
            result[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
    }

    public int[] plusOne1(int[] digits) {
        StringBuilder digitsString = new StringBuilder();
        for (Integer i : digits) {
            digitsString.append(i.toString());
        }
        double result = Double.parseDouble(digitsString.toString()) + 1;
        char[] chars = String.valueOf(result).toCharArray();
        int[] resultArray = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            resultArray[i] = Character.getNumericValue(chars[i]);
        }
        return resultArray;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) {
            return new int[0];
        }
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1); // so that the map takes less space
        }
        if (nums1.length == 1) { // special case, one element
            for (int i : nums2) {
                if (nums1[0] == i) {
                    return nums1;
                }
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                queue.offer(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<>();
        for (int i : nums) {
            if (!check.add(i))
                return true;
        }
        return false;
    }

    /**
     * a) XOR of a number with itself is 0.
     * b) XOR of a number with 0 is number itself.
     * <p>
     * Let us consider the above example.
     * Let ^ be xor operator as in C and C++.
     * <p>
     * res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4
     * <p>
     * Since XOR is associative and commutative, above
     * expression can be written as:
     * res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)
     * = 7 ^ 0 ^ 0 ^ 0
     * = 7 ^ 0
     * = 7
     */
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int a : nums) {
            x = x ^ a;
        }
        return x;
    }

    public void rotateArray(int[] nums, int k) {
        int length = nums.length;
        int[] part1 = new int[k];
        int[] part2 = new int[length - k];
        int[] result = new int[length];
        for (int i = length - k, j = 0; i < length; i++, j++) {
            part1[j] = nums[i];
        }
        for (int i = 0; i < length - k; i++) {
            part2[i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            result[i] = part1[i];
        }
        for (int i = k, j = 0; i < length; i++, j++) {
            result[i] = part2[j];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = result[i];
        }
    }


    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length; // This takes care of the cases where array has one element or k>length.
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }


    public int maxProfit1(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > lowest) {
                profit += prices[i] - lowest;
                lowest = prices[i];
            } else {
                lowest = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int maxPrice = 0;
        if (length == 0 || length == 1) {
            return maxProfit;
        }
        for (int i = 0, j = 1; i < length && j < length; ) {
            if (prices[j] > prices[i] && prices[j] > maxPrice) {
                maxPrice = prices[j];
                //maxProfit+=prices[j]-prices[i];
                j++;
            }
        }
        //maxProfit += prices[j] - prices[i];

        return maxProfit;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;

        if (length == 0 || length == 1) {
            return length;
        }
        if (nums[0] == nums[length - 1]) {
            nums = Arrays.copyOfRange(nums, 0, 1);
            return 1;
        }
        while (i < length - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                nums[j] = nums[i];
                j++;
                i++;
            }
        }
        nums[j] = nums[length - 1];
        nums = Arrays.copyOfRange(nums, 0, j + 1);
        return j + 1;
    }


    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int start = 0;
        int end = length - 1;
        if (length == 0 || length == 1) {
            return A;
        }
        while (start < end) {
            if (A[start] % 2 == 0) {
                start++;
            } else {
                if (A[end] % 2 == 0) {
                    swap(A, start, end);
                }
                end--;
            }
        }
        return A;
    }

    private void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }
}