class Solution {
public:
    long long maxArrayValue(vector<int>& nums) {
        long long sum = 0;

        vector<long long> vvv;

        int nn = nums.size();

        for (int i = 0; i < nn; i++)
        {
            vvv.push_back(nums[i]);
        }

        for (int i = nn - 1; i > 0; i--)
        {
            if (vvv[i - 1] <= vvv[i])
            {
                vvv[i - 1] = vvv[i] + vvv[i - 1];
            }
        }
        sort(vvv.begin(), vvv.end());
        return vvv[nn - 1];
        
    }
};
