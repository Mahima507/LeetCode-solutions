class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[n - k + 1];
    Deque<Integer> dq = new ArrayDeque<>(); // max queue

    for (int i = 0; i < n; ++i) {
      // Remove elements that are out of the current window
      while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
        dq.pollFirst();
      }

      // Remove elements smaller than the current element
      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }

      dq.offerLast(i);

      if (i >= k - 1) {
        ans[i - k + 1] = nums[dq.peekFirst()];
      }
    }

    return ans;
  }
}
