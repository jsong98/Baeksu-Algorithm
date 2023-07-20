#include <string>
#include <iostream>

/*
    Title: 팰린드롬수
    Link: https://www.acmicpc.net/problem/1259
*/

using namespace std;

bool IsPalindrome(
    const string input, 
    const int start, 
    const int end
) {
    // 탈출조건: 길이가 0 이하
    if ((end-start) <= 0) return true;

    char left = input.at(start);
    char right = input.at(end);
    if (left != right) return false;

    return IsPalindrome(input, start+1, end-1);
}

int main() {
    string input;
    cin >> input;

    while (input != "0") {
        bool isPalindrome = IsPalindrome(input, 0, input.length()-1);
        string result = isPalindrome ? "yes" : "no";

        cout << result << endl;
        cin >> input;
    }
}