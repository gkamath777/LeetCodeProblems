package org.pgk.leetcode.leetcodeproblems.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArrayServiceImpl {

    /**
     * Concatenates the given integer array with itself.
     *
     * @param nums the input array of integers to be concatenated
     * @return a new array containing two consecutive copies of the input array
     */
    public int[] getConcatenation(int[] nums) {

        int [] result = Arrays.copyOf(nums,nums.length*2);
        System.arraycopy(nums, 0, result, nums.length, nums.length);

        System.out.println(Arrays.toString(result));

        return result;
    }

    /**
     * Merges two integer arrays into a single sorted array.
     * The method combines elements from two arrays, sorts the resulting array in ascending order, and returns it.
     *
     * @param nums1 the first integer array
     * @param m the number of valid elements in the first array
     * @param nums2 the second integer array
     * @param n the number of valid elements in the second array
     * @return a new integer array containing all elements from both input arrays, sorted in ascending order
     */
    public int[] getOrderedMerge(int[] nums1, int m, int[] nums2, int n) {
        int [] result = Arrays.copyOf(nums1,nums1.length + nums2.length);
        System.arraycopy(nums2, 0, result, m, n);
        Arrays.sort(result);

        return result;
    }

    /**
     * Removes all occurrences of the specified value from the given array and
     * returns the count of remaining elements.
     * The method modifies the input array in place to exclude the values equal to
     * the specified integer and returns the number of elements that are not removed.
     *
     * @param nums the input array of integers to process
     * @param value the integer value to be removed from the array
     * @return the count of remaining elements in the array after removal
     */
    public int[] removeValue(int[] nums, int value) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[k++] = nums[i];
            }
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    /**
     * Removes duplicate values from the given ordered integer array. This method modifies the input array
     * to retain only the first occurrence of each unique element, assuming the input array is sorted
     * in non-decreasing order.
     *
     * @param nums the input array of integers, sorted in non-decreasing order
     * @return a new array containing only the unique elements from the input array
     */
    public int[] removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k++] = nums[i];
            }
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, remove some
     * duplicates in-place such that each unique element appears at most twice.
     * The relative order of the elements should be kept the same.
     *
     * Since it is impossible to change the length of the array in some languages,
     * you must instead have the result be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates,
     * then the first k elements of nums should hold the final result.
     * It does not matter what you leave beyond the first k elements.
     *
     * Return k after placing the final result in the first k slots of nums.
     */
    public int[] removeDuplicates2(int[] nums) {
        int k = 2;
        for(int i=2; i<nums.length; i++) {
            if(nums[i] != nums[k-2]) {
                nums[k++] = nums[i];
            }
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    /**
     * Calculates the maximum profit achievable from a series of stock prices,
     * assuming you can execute multiple buy and sell transactions.
     * The condition is that you must sell the stock before you buy it again.
     *
     * @param prices an array of integers representing the stock prices on different days
     * @return the maximum possible profit from the stock transactions
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        int profit = 0;
        int i = 0;
        for(i = 1; i < prices.length; i++) {
            if(prices[i]< prices[i-1]) {

                buy = prices[i];
            } else {
                sell = prices[i];
                if(sell > buy) {
                    profit += (sell - buy);
                }
                buy = prices[i];
            }
        }

        if(profit == 0 && buy == prices[i-1]) {
            return 0;
        }
        if(profit == 0) {
            return (sell - buy);
        }
        return profit;
    }


}
