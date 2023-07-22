/*
    Title: Two Sum
    Link: https://leetcode.com/problems/two-sum/
    Note:
        - Use hashmap to optimize its time complexity
        - Fill the hashmap when it's not found, since numbers can be duplicated.
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = -1;

        for (int i=0; i<height.size(); i++) {
            for (int j=height.size()-1; j>i; j--) {
                int x = j-i;
                int y = (height[i] > height[j]) ? height[j] : height[i];
                int area = x * y;

                if (area < max) continue;
                max = area;
            }
        }

        return max;
    }
};