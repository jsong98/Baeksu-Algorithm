#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

enum QueueCommand {
    PUSH,
    POP,
    FRONT,
    BACK,
    SIZE,
    EMPTY,
    INVALID,
};

const map<string, QueueCommand> StringToCommand = {
    {"push", PUSH},
    {"pop", POP},
    {"front", FRONT},
    {"back", BACK},
    {"size", SIZE},
    {"empty", EMPTY},
};

const string WHITESPACE = " \t\n\r\f\v";

string ltrim(const string &s) {
    size_t start = s.find_first_not_of(WHITESPACE);
    return (start == string::npos) ? "" : s.substr(start);
}

string rtrim(const string &s) {
    size_t end = s.find_last_not_of(WHITESPACE);
    return (end == string::npos) ? "" : s.substr(0, end+1);
}

string Trim(const string &s) {
    return rtrim(ltrim(s));
}

string ToLower(string s) {
    string result(s.length(), ' ');
    transform(s.begin(), s.end(), result.begin(), ::tolower);
    
    return result;
}

QueueCommand GetQueueCommand(string rawCommand) {
    rawCommand = ToLower(Trim(rawCommand));
    auto found = StringToCommand.find(rawCommand);

    if (found == StringToCommand.end()) {
        return INVALID;
    }
    return found->second;
}

vector<string> Split(string s, string delim) {
    vector<string> result;
    string token;

    int pos = s.find(delim);

    while (pos != string::npos) {
        token = s.substr(0, pos);
        result.push_back(token);

        s.erase(0, pos+delim.length());
        pos = s.find(delim);
    }
    result.push_back(s);

    return result;
}

class Queue {
public:
    Queue() {};
    void Push(int x) {
        queue.push_back(x);
    }
    int Pop() {
        if (Empty()) return -1;

        return queue[front++];
    }
    int Size() {
        return queue.size() - front;
    }
    bool Empty() {
        return Size() == 0;
    }
    int Front() {
        if (Empty()) return -1;
        return queue[front];
    }
    int Back() {
        if (Empty()) return -1;
        return queue.back();
    }

private:
    vector<int> queue;
    int front = 0;
};

int main() {
    int len;
    cin >> len;
    cin.ignore(256, '\n');

    string input;
    Queue queue;
    for (int i=0; i<len; i++) {
        getline(cin, input);
        auto splitted = Split(input, " ");

        QueueCommand command = GetQueueCommand(splitted[0]);
        switch (command) {
            case PUSH: {
                int num = stoi(splitted[1]);
                queue.Push(num);
                break;
            }
            case POP:
                cout << queue.Pop() << endl;
                break;
            case FRONT:
                cout << queue.Front() << endl;
                break;
            case BACK:
                cout << queue.Back() << endl;
                break;
            case EMPTY:
                cout << queue.Empty() << endl;
                break;
            case SIZE:
                cout << queue.Size() << endl;
                break;
            default:
                break;
        }
    }
}