package com.project.solution;

public class LeetCodeSolution {

    public static void main(String[] args) {

        int[] nums1 = { 2, 0, 2 };
        int[][] queries1 = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(minZeroArray(nums1, queries1));

        int[] nums2 = { 4, 3, 2, 1 };
        int[][] queries2 = { { 1, 3, 2 }, { 0 ,2, 1 } };
        System.out.println(minZeroArray(nums2, queries2));

    }

    public static int minZeroArray(int[] nums, int[][] queries) {

        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        // Return earliest query that zero array can be formed
        return left;

    }

    private static boolean currentIndexZero(int[] nums, int[][] queries, int k) {

        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {

            int left = queries[queryIndex][0], right = queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;

        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {

            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;

        }

        return true;

    }

}
