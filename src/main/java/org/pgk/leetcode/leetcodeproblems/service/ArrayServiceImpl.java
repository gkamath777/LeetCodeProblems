package org.pgk.leetcode.leetcodeproblems.service;

import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * Calculates the maximum profit achievable from a series of stock prices
     * by performing at most one buy and one sell transaction.
     * The method ensures you must buy the stock before selling.
     *
     * @param prices an array of integers representing the stock prices on different days
     * @return the maximum profit that can be achieved, or 0 if no profitable transaction is possible
     */
    public int maxProfit2(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        int profit = 0;
        int i = 0;
        for(i = 1; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else {
                if(prices[i] - buy >= profit) {
                    sell = prices[i];
                    profit = sell - buy;
                }
            }
        }
        if(profit <= 0) {
            return 0;
        }

        return profit;
    }

    /**
     * Rotates the elements of an array to the right by the specified number of steps.
     * If the number of steps is greater than the length of the array, it computes the effective rotation.
     *
     * @param nums the array of integers to be rotated
     * @param k the number of steps to rotate the array to the right
     * @return the rotated array
     */
    public int[] rotate(int[] nums, int k) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        if(k <= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if(i < k) {
                    nums[i] = copyNums[nums.length - k + i];
                } else {
                    nums[i] = copyNums[i-k];
                }

            }
        } else {
            rotate(nums, k % nums.length) ;
        }

        return nums;
    }

    /**
     * Determines if you can reach the last index of the array starting from the first index.
     * The array elements represent the maximum jump length at that position.
     *
     * @param nums the input array of integers where each element signifies the maximum jump length from that position
     * @return true if it is possible to reach the last index, false otherwise
     */
    public boolean canJumpType1(int[] nums) {
        int farthest = 0;
        for(int i =0; i< nums.length; i++) {
            if(i> farthest) {
                return false;
            }

            farthest = Math.max(farthest, i+ nums[i]);

            if(farthest > nums.length -1)
                return true;
        }
        return true;
    }

    /**
     * Finds the single number in the given array that appears only once, while all other numbers appear twice.
     * This implementation is not optimized for time or space complexity.
     *
     * @param nums the input array of integers, where all elements except one appear twice
     * @return the integer that appears only once in the array
     */
    public int singleNumberNotOptimized(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue()==1) {
                value = entry.getKey();
            }
        }
        return value;
    }


    public int singleNumberOptimized(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }


    public int[] arrayIntersect(int[] nums1, int[] nums2) {
        int[] smaller;
        int[] larger;
        if(nums1.length <= nums2.length) {
            smaller = nums1;
            larger = nums2;
        } else {
            smaller = nums2;
            larger = nums1;
        }

        List<Integer> res = getIntegers(smaller, larger);

        int[] output = new int[res.size()];
        for(int k=0; k< res.size();k++)
            output[k] = res.get(k);
        return output;

    }

    private static List<Integer> getIntegers(int[] smaller, int[] larger) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : smaller) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> res = new ArrayList<>();

        for (int j : larger) {
            if (map.containsKey(j)) {
                int count = map.get(j);
                if (count == 1) {
                    map.remove(j);
                } else {
                    map.put(j, count - 1);
                }
                res.add(j);
            }
        }
        return res;
    }

    public int[] plusOneForSmallInt(int[] digits) {
        int sum = 0;
        for(int i=0 ; i<digits.length; i++) {
            sum += digits[i] * ((int) Math.pow(10, digits.length-1-i));
        }

        sum = sum + 1;
        System.err.println(sum);
        int temp = sum;
        int len = 0;
        while(temp > 0) {
            len++;
            temp /= 10;
        }

        int[] newInt = new int[len];
        int index = len -1;
        while(sum >0) {
            newInt[index--] = sum % 10;

            sum = sum/10;
            System.err.println(index + " "+ sum);
        }

        return newInt;
    }


    public int[] plusOneNonOptimized(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry = 1;
        int length = digits.length -1;
        for(int i= length ; i>=0; i--) {
            int value = digits[i] + carry;
            if(value >= 10) {
                value = value%10;
                carry = 1;
            } else {
                carry = 0;
            }
            res.add(value);
        }
        if(carry == 1)
            res.add(carry);

        int[] output = new int[res.size()];
        for(int k=0; k< res.size();k++)
            output[k] = res.get(res.size()-k-1);
        return output;

    }

    public int[] plusOneOptimized(int[] digits) {
        for(int i=digits.length -1 ; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] out = new int[digits.length + 1];
        out[0] = 1;
        return out;
    }

    public void moveZeroes(int[] nums) {
        int temp = 0;
        for(int num: nums) {
            if(num != 0 ) {
                nums[temp++] = num;
            }
        }

        while(temp < nums.length)
            nums[temp++] = 0;
    }
}

}
