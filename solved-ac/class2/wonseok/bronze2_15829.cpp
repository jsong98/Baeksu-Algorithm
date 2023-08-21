/*
    Title: Hashing
    Link: https://www.acmicpc.net/problem/15829
    Note: 
        - pow를 사용할 경우 절반만 정답
        - 제곱을 계산할 때 `[x] * [x] = [x^]`인 mod 연산의 성질을 이용해야 오버플로우를 피할 수 있다.
*/

#include <string>
#include <iostream>

using namespace std;

const int M = 1234567891;
const int r = 31;

unsigned long GetPower(int base, int exp) {
    unsigned long power = 1;

    for (int i=0; i<exp; i++) {
        power *= base;
        power %= M;
    }

    return power;
}

int GetAlphabetNumber(char alphabet) {
    return alphabet - 'a' + 1;
}

unsigned long GetHash(string input) {
    unsigned long sum = 0;
    for (int i=0; i<input.length(); i++) {
        int a = GetAlphabetNumber(input.at(i));
        sum += a * GetPower(r, i);
    }

    return sum % M;
}

int main() {
    int len;
    string input;

    cin >> len >> input;

    cout << GetHash(input) << endl;
}