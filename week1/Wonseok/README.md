## Note
(27866)
C++에서 여러 줄 문자열을 한번에 입력하고자 할 때, 줄바꿈으로 구분한다.
```cpp
const string multiline = 
    "This is the first line\n"
    "This is the second line\n";
```

(15829) 제곱을 계산할 때 `[x] * [x] = [x^]`인 mod 연산의 성질을 이용해야 오버플로우를 피할 수 있다.

(10845) Enum을 정의하는 방법은 아래와 같다. 각 열거자는 쉼표로 구분한다.
```cpp
enum Command {
    PUSH,
    POP,
    ...
}
```

(10845) cin 이후 getline으로 받으려면 버퍼를 먼저 비워주어야 한다. 그렇지 않으면 남아 있는 개행 문자로 인해 공백만 받아진다.
```cpp
int length;
cin >> length;

string line;
getline(cin, line);
```

(10845) 문자열을 trim하고자 하는 경우, 양 옆의 모든 whitespace를 제거하는 함수를 구현해야 한다. `\t\n\r\f\v` 템플릿 이용.
- `\r`: Carriage Return, 행의 처음으로 커서 이동
- `\f`: Form Feed, 출력 시 현재 페이지 마침
- `\v`: Vertical Tab, 다음 줄로 이동 및 탭 한 칸 이동 (=`\n\t`)
```cpp
const string WHITESPACE = " \n\r\t\f\v";

string ltrim(const string &s) {
    size_t start = s.find_first_not_of(WHITESPACE);
    return (start == npos) ? "" : s.substr(start);
}
```
(10845) Switch문에서 새 변수를 할당하려면 범위를 정해주어야 한다. 그렇지 않을 경우 초기화 오류를 낸다.
```cpp
switch (num) {
    // {} 스코프가 없을 시 jump to case label 오류
    case 1: { 
        int x = 0;
        ...
    }
    case 2:
        ...
}
```

(18110) 입력 범위를 잘 확인해야 한다. 입력이 0인 경우 처리할 때 에러가 발생한다.
## Suggestion
- 파일명에 문제 난이도도 포함하기