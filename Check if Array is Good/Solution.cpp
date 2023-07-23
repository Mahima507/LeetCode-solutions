class Solution {
public:
    bool isGood(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        for(int i=0; i<n-1; i++){
            if(nums[i]!=i+1) return 0;
        }
        if(n-1!=nums[n-1]) return 0;
       return 1;
    }
};
