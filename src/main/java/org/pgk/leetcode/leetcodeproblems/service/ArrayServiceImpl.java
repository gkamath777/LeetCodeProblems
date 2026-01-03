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
}
