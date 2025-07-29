/**
 * LeetCode 1463: Cherry Pickup II
 * 
 * Problem: Two robots start at (0, 0) and (0, cols-1) and move down the grid.
 * At each step, they can move down-left, down, or down-right.
 * Return the maximum cherries both robots can collect.
 * 
 * Approach: 3D Dynamic Programming with Memoization
 * - State: (row, robot1_col, robot2_col)
 * - If robots are at same position, count cherries only once
 * - Try all 9 combinations of moves for both robots
 * - Use memoization to avoid recalculating subproblems
 * 
 * Time Complexity: O(m * n^2 * 9) = O(m * n^2)
 * Space Complexity: O(m * n^2) for memoization
 */

import java.util.Arrays;

class Solution {
    // Movement directions: stay, left, right
    int[] dy = {0, -1, 1};
    // Memoization array: memo[row][col1][col2]
    int[][][] memo = new int[71][71][71];

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        
        // Initialize memoization array with -1 (unvisited)
        for (int[][] arr2D : memo) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        
        // Start DFS from row 0, robot1 at col 0, robot2 at col n-1
        return dfs(grid, 0, 0, n - 1, m, n);
    }

    private int dfs(int[][] grid, int i, int c1, int c2, int m, int n) {
        // Base case: reached bottom of grid
        if (i == m) return 0;
        
        // Out of bounds check
        if (c1 < 0 || c2 < 0 || c1 >= n || c2 >= n) return Integer.MIN_VALUE;
        
        // Return memoized result if already calculated
        if (memo[i][c1][c2] != -1) return memo[i][c1][c2];

        int ans = 0;
        // Try all 9 combinations of moves (3 for each robot)
        for (int k = 0; k < 3; k++) {
            for (int r = 0; r < 3; r++) {
                ans = Math.max(ans, dfs(grid, i + 1, c1 + dy[k], c2 + dy[r], m, n));
            }
        }

        // Add cherries from current positions
        // If robots are at same position, count cherries only once
        ans += (c1 == c2) ? grid[i][c1] : grid[i][c1] + grid[i][c2];
        
        // Memoize and return result
        return memo[i][c1][c2] = ans;
    }
}

