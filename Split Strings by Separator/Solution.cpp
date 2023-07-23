class Solution {
public:
        vector<string> splitWordsBySeparator(vector<string>& words, char separator) {
        vector<string> ans;
        int n = words.size();
        for(int i=0;i<n;i++){
            string temp;
            string temp2 = words[i];
            temp2 += separator;
            for(int j=0;j<temp2.size();j++){
                if(temp2[j]!=separator){
                        temp.push_back(temp2[j]);
                }
                else{
                    if(temp.size()>0)
                        ans.push_back(temp);
                    temp = "";
                }
            }
        }
        return ans;
    }
};
