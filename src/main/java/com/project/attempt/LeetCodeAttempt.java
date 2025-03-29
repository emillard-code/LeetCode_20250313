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

    // This method returns the minimum number of operations needed to turn int[] nums into a zero array.
    public static int zeroArrayTransformationII(int[] nums, int[][] queries) {

        // We will store our answer in int k.
        int k = 0;

        // We will loop through int[][] queries, which has the list of possible operations we
        // can perform on int[] nums to potentially get it to become a zero array.
        for (int i = 0; i < queries.length; i++) {

            // As per challenge specifications, int l and int r represent the range of indexes
            // in int[] nums that we can perform the current query on. And int value represents
            // the maximum value that we can subtract from each of those indexes, although we
            // can also subtract any value below the maximum including 0.
            int l = queries[i][0];
            int r = queries[i][1];
            int value = queries[i][2];

            // We then loop through int[] nums, starting from index int l, and going until
            // index int r (inclusive). For each query, we subtract the maximum possible
            // value that we can (meaning int value) unless the value at that index is less
            // than int value, in which case we simply subtract until it becomes 0. Since the
            // challenge specifications clarified that we must perform our queries sequentially
            // according to their order in int[][] queries, and we can always choose not to
            // subtract a certain index in later queries, the most optimal way to attain a zero
            // array would be to subtract as much as we can for each query. As per challenge
            // specifications, the value we subtract from each index is independent of each other,
            // and we can subtract varying values at our discretion here.
            for (int j = l; j <= r; j++) {

                if (nums[j] >= value) {
                    nums[j] = nums[j] - value;
                } else if (nums[j] > 0) {
                    nums[j] = 0;
                }

            }

            // We increment int k to signify an operation has been completed.
            k++;

            // We then perform a short loop to check if int[] nums has become a zero array
            // yet or not. We break from the loop if at any point a non-zero value is detected,
            // and if we reach the end of the loop and all values are zero, we return the current
            // value of k as it is.
            for (int j = 0; j < nums.length; j++) {

                if (nums[j] > 0) { break; }
                if (j == nums.length - 1 && nums[j] == 0) { return k; }

            }

        }

        // If all logic has been performed, and we reach this point, it means that a zero
        // array could not be completed, and we return -1 to signify this as per challenge
        // specifications.
        return -1;

    }

}
