class Solution {
    public long maxScore(int[] nums, int x) {
        long[] maxScore = new long[] {0, 0};
        long ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int parity = nums[i] % 2;
            ans = Math.max(0, Math.max(maxScore[parity], maxScore[1 - parity] - x) + nums[i]);
            maxScore[parity] = Math.max(maxScore[parity], ans);
        }
        return ans;
    }
}
