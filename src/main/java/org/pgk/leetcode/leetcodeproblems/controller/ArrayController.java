package org.pgk.leetcode.leetcodeproblems.controller;

import org.pgk.leetcode.leetcodeproblems.service.ArrayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("/array")
public class ArrayController {

    private final ArrayServiceImpl arrayService;

    public ArrayController(ArrayServiceImpl arrayService) {
        this.arrayService = arrayService;
    }

    /**
     * Concatenates the provided integer array with itself.
     *
     * @param nums an array of integers to be concatenated
     * @return a new integer array that contains two copies of the input array
     *
     * Sample Request: GET http://localhost:8080/array/concat?nums=1,2
     *
     */
    @GetMapping("/concat")
    public int[] getConcate(@RequestParam int[] nums) {
        System.out.println(nums);
        return arrayService.getConcatenation(nums);
    }

    /**
     * Merges two integer arrays into a single sorted array.
     *
     * @param nums1 the first integer array to be merged
     * @param nums2 the second integer array to be merged
     * @return a new array containing all elements from both input arrays, sorted in ascending order
     *
     * Sample Request: GET http://localhost:8080/array/merge?nums1=1,4,5&nums2=2,3
     *
     */
    @GetMapping("/merge")
    public int[] getMerge(@RequestParam int[] nums1, @RequestParam int[] nums2) {
        return arrayService.getOrderedMerge(nums1, nums1.length, nums2, nums2.length);
    }

    /**
     * Removes all occurrences of a specified integer value from the given array.
     *
     * @param nums the input array of integers to process
     * @param value the integer value to be removed from the array
     * @return a new integer array containing the elements from the input array excluding
     *         all occurrences of the specified value
     *
     * Sample Request: GET http://localhost:8080/array/remove?nums=1,4,2,3,2,5&value=2
     *
     */
    @GetMapping("/remove")
    public int[] removeValue(@RequestParam int[] nums, @RequestParam int value) {
        return arrayService.removeValue(nums, value);
    }

    /**
     * Removes duplicate values from the given ordered integer array. The method retains only the first
     * occurrence of each unique element and removes subsequent duplicates. The input array is
     * expected to be sorted for proper functionality.
     *
     * @param nums the input array of integers, which must be sorted in non-decreasing order
     * @return a new array containing only the unique elements from the input array
     *
     * Sample Request: GET http://localhost:8080/array/removeDup?nums=1,2,2,3,4,4,5
     *
     */
    @GetMapping("/removeDup")
    public int[] removeDuplicateValue(@RequestParam int[] nums) {
        return arrayService.removeDuplicates(nums);
    }

    /**
     * Calculates the maximum profit that can be achieved by buying and selling stocks
     * given the daily prices. Multiple transactions (buy-sell pairs) are allowed as long
     * as a new purchase can only be made after selling the previously held stock.
     *
     * @param prices an array of integers representing the prices of a stock on different days
     * @return the maximum profit that can be achieved from the given price array
     *
     * Sample Request: GET http://localhost:8080/array/maxProfit?prices=6,1,3,2,4,7
     *
     */
    @GetMapping("/maxProfit")
    public int maxProfit(@RequestParam int[] prices) {
        return arrayService.maxProfit(prices);
    }
}
