package org.pgk.leetcode.leetcodeproblems.controller;

import org.pgk.leetcode.leetcodeproblems.service.ArrayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/array")
public class ArrayController {

    private final ArrayServiceImpl arrayService;

    public ArrayController(ArrayServiceImpl arrayService) {
        this.arrayService = arrayService;
    }

    @GetMapping("/concat")
    public int[] getConcate(@RequestParam int[] nums) {
        System.out.println(nums);
        return arrayService.getConcatenation(nums);
    }

    @GetMapping("/merge")
    public int[] getMerge(@RequestParam int[] nums1, @RequestParam int[] nums2) {
        return arrayService.getOrderedMerge(nums1, nums1.length, nums2, nums2.length);
    }

}
