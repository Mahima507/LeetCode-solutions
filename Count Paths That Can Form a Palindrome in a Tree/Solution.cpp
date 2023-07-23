int cnt[1 << 26];
class Solution {
public:
    long long countPalindromePaths(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> adj(n);
        for(int i = 1 ; i < n ; i++) {
            adj[parent[i]].push_back(i);
        }
        long long res = 0;
        vector<int> er;
        function<void(int, int)> dfs = [&](int i, int v) {
            er.push_back(v);
            res += cnt[v];
            for(int bit = 0 ; bit < 26 ; bit++) {
                  res += cnt[v ^ (1 << bit)];
            }
            cnt[v]++;
            // cout << i << " " << v << " " << res << '\n';
            for(auto &u: adj[i]) {
                dfs(u, v ^ (1 << int(s[u] - 'a')));
            }
        };
        dfs(0, 0);
        for(auto &i: er)    cnt[i] = 0;
        return res;
        return 0;
    }
};
