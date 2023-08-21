#include<stack>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
    string minRemoveToMakeValid(string s) {
        vector<int> stack;

        int adjust = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            int index = i - adjust;

            if (s[index] == '(') {
                stack.push_back(index);
                continue;
            }

            if (s[index] == ')') {
                if (stack.empty()) {
                    s.erase(index, 1);
                    adjust++;
                    continue;
                }

                stack.pop_back();
            }
        }

        adjust = 0;
        for (int index : stack) {
            s.erase(index-adjust,1);
            adjust++;
        }

        return s;
    }
};