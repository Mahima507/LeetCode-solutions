class Solution {
public:
    int m=(int)(1e9+7);
    int f(int ind,int num,int x,vector<vector<int>>&dp){
        if(ind<0)
        return 0;
        if(ind==0)
        return 1;
        
        if(pow(num,x)>ind)
        return 0;
        
        if(dp[ind][num]!=-1) return dp[ind][num];
        
        int temp=pow(num,x);
        
        int notTake=f(ind-temp,num+1,x,dp);
        int take=f(ind,num+1,x,dp);
        
        return dp[ind][num]=(notTake%m+take%m)%m;
    }
    int numberOfWays(int n, int x) {
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        return f(n,1,x,dp);
    }
};
