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
     * Removes duplicate values from the given sorted integer array. This method retains only the first
     * occurrence of each unique element and removes subsequent duplicates. The input array is
     * expected to be sorted in non-decreasing order for accurate results.
     *
     * @param nums the input array of integers, sorted in non-decreasing order
     * @return a new array containing only the unique elements from the input array
     *
     * Sample Request: Sample Request: GET http://localhost:8080/array/removeDup2?nums=1,2,2,2,3,3,4,4,5
     *
     */
    @GetMapping("/removeDup2")
    public int[] removeDuplicateValue2(@RequestParam int[] nums) {
        System.out.println(nums.length);
        return arrayService.removeDuplicates2(nums);
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

    /**
     * Calculates the maximum profit that can be achieved by buying and selling stocks
     * given the daily prices. Unlike basic implementations, this method uses a different
     * approach to optimize profit calculation. Multiple transactions (buy-sell operations)
     * are allowed as long as a new purchase can only be made after the previous stock has been sold.
     *
     * @param prices an array of integers representing the prices of a stock on different days
     * @return the maximum profit that can be achieved from the given price array using the optimized method
     *
     * Sample Request: GET http://localhost:8080/array/maxProfit?prices=6,1,3,2,4,7
     *
     *
     */
    @GetMapping("/maxProfit2")
    public int maxProfit2(@RequestParam int[] prices) {
        return arrayService.maxProfit2(prices);
    }

    /**
     * Rotates the given array to the right by the specified number of steps.
     * The elements at the end of the array are moved to the beginning as part of the rotation process.
     *
     * @param nums the input array of integers to be rotated
     * @param k the number of steps to rotate the array to the right
     * @return a new array containing the rotated elements
     */
    @GetMapping("/rotate")
    public int[] rotate(@RequestParam int[] nums, @RequestParam int k) {
        return arrayService.rotate(nums, k);
    }

    /**
     * Determines if it is possible to reach the last index of the given array
     * starting from the first index. Each element in the array represents the
     * maximum jump length at that position.
     *
     * @param nums an array of non-negative integers where each element represents
     *             the maximum jump length at that position
     * @return true if it is possible to reach the last index, false otherwise
     */
    @GetMapping("/CanJump1")
    public boolean canJump1(@RequestParam int[] nums) {
        return arrayService.canJumpType1(nums);
    }

    /**
     * Finds the single number in the given integer array where every other number
     * appears exactly twice. The method returns the unique number that does not have
     * a duplicate in the array.
     *
     * @param nums an array of integers where every other element appears exactly twice
     *             except for one element which appears only once
     * @return the single integer that appears only once in the array
     */
    @GetMapping("/SingleNumber")
    public int singleNumber(@RequestParam int[] nums) {
        return arrayService.singleNumberNotOptimized(nums);
    }


    @GetMapping("/intersect")
    public int[] arrayIntersect(@RequestParam int[] nums1, @RequestParam int[] nums2) {
        return arrayService.arrayIntersect(nums1, nums2);
    }

    /**
     * Determines if a given Sudoku board is valid. A valid Sudoku board must meet the following conditions:
     * 1. Each row must contain the digits 1-9 without repetition.
     * 2. Each column must contain the digits 1-9 without repetition.
     * 3. Each of the 9 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * @param board a 2D character array representing a Sudoku board, where empty cells are represented by '.'
     * @return true if the given Sudoku board is valid, false otherwise
     */
    @GetMapping("/isValidSudoku")
    public boolean isValidSudoku(@RequestParam char[][] board) {
        return arrayService.isValidSudoku(board);
    }
}
