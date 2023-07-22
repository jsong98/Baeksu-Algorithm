/*
    Title: Container With Most Water
    Link: https://leetcode.com/problems/container-with-most-water/
    Note:
        - Use two pointers: one from the left, the other from the right
        - Move the pointer with the smaller value
*/
#include <vector>

using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int pLeft = 0;
        int pRight = height.size()-1;

        int max = -1;
        while (pLeft < pRight) {
            int x = pRight - pLeft;
            int y = (height[pLeft] > height[pRight]) ? height[pRight] : height[pLeft];
            int area = x * y;

            if (area > max) max = area;
            
            if (height[pLeft] > height[pRight]) pRight--;
            else pLeft++;
        }

        return max;
    }
};