package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[] nums1 = { 2, 0, 2 };
        int[][] queries1 = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(zeroArrayTransformationII(nums1, queries1));

        int[] nums2 = { 4, 3, 2, 1 };
        int[][] queries2 = { { 1, 3, 2 }, { 0 ,2, 1 } };
        System.out.println(zeroArrayTransformationII(nums2, queries2));

    }

    public static int zeroArrayTransformationII(int[] nums, int[][] queries) {

        int k = 0;

        for (int i = 0; i < queries.length; i++) {

            int x = queries[i][0];
            int y = queries[i][1];
            int value = queries[i][2];

            for (int j = x; j <= y; j++) {

                if (nums[j] >= value) {
                    nums[j] = nums[j] - value;
                } else if (nums[j] > 0) {
                    nums[j] = 0;
                }

            }

            k++;

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] > 0) { break; }
                if (j == nums.length - 1 && nums[j] == 0) { return k; }

            }

        }

        return -1;

    }

}
