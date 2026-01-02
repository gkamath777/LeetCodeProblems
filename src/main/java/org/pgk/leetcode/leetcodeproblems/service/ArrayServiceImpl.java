package org.pgk.leetcode.leetcodeproblems.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArrayServiceImpl {

    public int[] getConcatenation(int[] nums) {

        int [] result = Arrays.copyOf(nums,nums.length*2);
        System.arraycopy(nums, 0, result, nums.length, nums.length);

        System.out.println(Arrays.toString(result));

        return result;
    }
}
