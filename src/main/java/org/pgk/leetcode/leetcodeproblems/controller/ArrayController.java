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

}
