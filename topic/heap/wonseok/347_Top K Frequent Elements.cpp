
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class FrequencyPair {
public:
    FrequencyPair(int key, int value): key(key), value(value) {};
    int key, value;
};

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> count;
        vector<FrequencyPair> frequency;

        for (int num : nums) {
            count[num] += 1;
        }

        for (auto pair: count) {
            FrequencyPair f = FrequencyPair(pair.first, pair.second);
            frequency.push_back(f);
        }

        sort(
            frequency.begin(), 
            frequency.end(), 
            [](FrequencyPair a, FrequencyPair b)  {
                return a.value > b.value;
            }
        );

        vector<int> result;

        for (int i=0; i<k; i++) {
            result.push_back(frequency[i].key);
        }

        return result;
    }
};