package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void countOfSubstringsContainingEveryVowelAndKConsonantsIITest() {

        int[] nums1 = { 2, 0, 2 };
        int[][] queries1 = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        assertEquals(2, LeetCodeAttempt.zeroArrayTransformationII(nums1, queries1));

        int[] nums2 = { 4, 3, 2, 1 };
        int[][] queries2 = { { 1, 3, 2 }, { 0 ,2, 1 } };
        assertEquals(-1, LeetCodeAttempt.zeroArrayTransformationII(nums2, queries2));

    }

}
