/**
 * LeetCode 76: Minimum Window Substring
 * 
 * Problem: Given two strings s and t, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the window.
 * 
 * Approach: Sliding Window with Two Pointers
 * 1. Use frequency map to track characters needed from string t
 * 2. Expand window by moving right pointer until all chars are covered
 * 3. Contract window by moving left pointer while maintaining validity
 * 4. Track minimum window found during the process
 * 
 * Time Complexity: O(|s| + |t|) where |s| and |t| are string lengths
 * Space Complexity: O(1) since we use fixed-size array for ASCII characters
 */

class Solution {
    public String minWindow(String s, String t) {
        // Edge case validation
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        
        // Frequency map for characters (ASCII table size)
        int[] map = new int[128];
        int count = t.length(); // Number of characters still needed
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        
        // Build frequency map for target string t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        // Sliding window approach
        while (end < chS.length) {
            // Expand window: if current char is needed, decrease count
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            
            // Contract window: when all chars are covered
            while (count == 0) {
                // Update minimum window if current is smaller
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // Move left pointer: if removing needed char, increase count
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
}
