#include <queue>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq(nums.begin(), nums.end());

        int answer;
        for (int i=0; i<k; i++) {
            answer = pq.top();
            pq.pop();
        }

        return answer;
    }
};

int main() {
    Solution solution;

    vector<int> nums = {3,2,1,5,6,4};
    cout << solution.findKthLargest(nums, 2) << endl;
}