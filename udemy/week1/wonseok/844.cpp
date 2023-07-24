/*
    Title: Backspace String Compare
    Link: https://leetcode.com/problems/backspace-string-compare/description/
    Approach:
        - Use two pointers: each pointer for each string input
        - Start iterating from the end, applying backspace string #
        - If both pointers reach negative index, both strings are the same.
*/

#include <string>

using namespace std;

class Solution {
public:
    bool backspaceCompare(string s, string t) {
        int sPointer, tPointer;
        sPointer = s.length();
        tPointer = t.length();

        while (sPointer-- >=0 && tPointer-- >= 0) {
            int numSkip = 0;
            while (sPointer >= 0) {
                if (s.at(sPointer) == '#') {
                    numSkip++;
                    sPointer--;
                    continue;
                }
                if (numSkip > 0) {
                    numSkip--;
                    sPointer--;
                    continue;
                }
                break;
            };

            numSkip = 0;
            while (tPointer >= 0) {
                if (t.at(tPointer) == '#') {
                    numSkip++;
                    tPointer--;
                    continue;
                }
                if (numSkip > 0) {
                    numSkip--;
                    tPointer--;
                    continue;
                }
                break;
            };

            if (sPointer < 0 || tPointer < 0) break;
            if (s.at(sPointer) != t.at(tPointer)) return false;
        }

        return (sPointer < 0) && (tPointer < 0);
    }
};