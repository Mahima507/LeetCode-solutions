
/**
 * LeetCode 1043: Partition Array for Maximum Sum
 * 
 * Problem: Given an integer array arr, partition it into sub-arrays of at most k elements.
 * Replace each element in a sub-array with the maximum element of that sub-array.
 * Return the largest sum of the given array after partitioning.
 * 
 * Approach: Dynamic Programming
 * - Use a rolling DP array to optimize space complexity
 * - For each position, try all possible partition sizes (1 to k)
 * - Track the maximum element in current partition and calculate the sum
 * 
 * Time Complexity: O(n * k) where n is array length
 * Space Complexity: O(k) using rolling array optimization
 */

import java.util.Arrays;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int K = k + 1;

        // Rolling DP array to save space
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);

        // Process array from right to left
        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            // Try all possible partition sizes from current position
            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                // Calculate sum for current partition + optimal sum for remaining
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}
