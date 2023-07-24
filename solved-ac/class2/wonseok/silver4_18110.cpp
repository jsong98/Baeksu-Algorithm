/*
    Title: solved.ac
    Link: https://www.acmicpc.net/problem/18110
    Note: 입력 범위를 잘 확인해야 한다! 입력값이 0일 수 있으므로 에러 처리를 해주어야 한다.
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

vector<int> GetDifficulties(int len) {
    vector<int> difficulties;
    int difficulty;
    for (int i=0; i<len; i++) {
        cin >> difficulty;
        difficulties.push_back(difficulty);
    }

    return difficulties;
}


vector<int> CutVector(vector<int> &vec, float percent) {
    vector<int> result;
    int cutSize = round(vec.size() * percent);

    for (int i=cutSize; i<vec.size()-cutSize; i++) {
        result.push_back(vec[i]);
    }

    return result;
}

int GetAverage(vector<int> &vec) {
    float sum = 0;
    for (auto value : vec) {
        sum += value;
    }

    return round(sum / vec.size());
}

int main () {
    int len;
    cin >> len;

    if (len == 0) {
        cout << "0" << endl;
        return 0;
    }

    vector<int> difficulties = GetDifficulties(len);
    sort(difficulties.begin(), difficulties.end());

    difficulties = CutVector(difficulties, 0.15);

    cout << GetAverage(difficulties) << endl;
}