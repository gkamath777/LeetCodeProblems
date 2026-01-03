package org.pgk.leetcode.leetcodeproblems;

import org.junit.jupiter.api.Test;
import org.pgk.leetcode.leetcodeproblems.service.ArrayServiceImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayServiceImplTest {

    private final ArrayServiceImpl arrayService = new ArrayServiceImpl();

    @Test
    void getConcatenation_shouldDuplicateArray() {
        int[] input = {1, 2};
        int[] output = arrayService.getConcatenation(input);

        assertArrayEquals(new int[]{1, 2, 1, 2}, output);
    }

    @Test
    void getConcatenation_shouldHandleSingleElement() {
        int[] input = {7};
        int[] output = arrayService.getConcatenation(input);

        assertArrayEquals(new int[]{7, 7}, output);
    }

    @Test
    void getOrderedMerge_shouldMergeArrays() {
        int[] nums1 = {1, 4};
        int[] nums2 = {3, 2};
        int[] output = arrayService.getOrderedMerge(nums1, nums1.length, nums2, nums2.length);
    }
}
