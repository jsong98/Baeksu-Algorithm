#include <iostream>

using namespace std;

// The API isBadVersion is defined for you.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int lBound = 1;
        int uBound = n;
        int firstBad = n;
        
        while (lBound <= uBound) {
            int mid = lBound + (uBound - lBound) / 2;

            if (isBadVersion(mid)) {
                firstBad = min(firstBad, mid);
                uBound = mid-1;
            } else {
                lBound = mid+1;
            }
        }

        return firstBad;
    }
};