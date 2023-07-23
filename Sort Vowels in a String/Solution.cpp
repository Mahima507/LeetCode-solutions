class Solution {
public:
    string sortVowels(string s) {
        string t = s;
        unordered_map<char, int> mpp;
        mpp['a'] = 1;
        mpp['e'] = 1;
        mpp['i'] = 1;
        mpp['o'] = 1;
        mpp['u'] = 1;
        mpp['A'] = 1;
        mpp['E'] = 1;
        mpp['I'] = 1;
        mpp['O'] = 1;
        mpp['U'] = 1;
        
        int n = s.size();
        string temp;
        for (int i = 0; i < n; i++){
            if (mpp.find(s[i]) != mpp.end()){
                // means vowel
                temp.push_back(s[i]);
            }
        }
        
        sort(temp.begin(), temp.end());
        cout << temp;
        
        int j = 0;
        for (int i = 0; i < n; i++){
            if (mpp.find(s[i]) != mpp.end()){
                // means consonant
                t[i] = temp[j];
                j++;
            }
        }
        
        return t;
    }
};
