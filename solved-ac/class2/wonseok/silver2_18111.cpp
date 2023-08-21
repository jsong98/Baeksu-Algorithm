/*
    Title: 마인크래프트
    Link: https://www.acmicpc.net/problem/18111
    Note: 
      - Placable, Diggable의 최대/최소 값을 잘 설정해야 한다. (0 초과 -> 0 이상 등)
      - 동일한 답일 경우 더 높은 블록을 출력해야 한다.
      - 총 걸리는 시간은 int의 범위를 벗어날 수 있다.
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

vector<int> Split(string input, string delim) {
    vector<int> result;
    string token = "";
    int pos = input.find(delim);

    while (pos != string::npos) {
        token = input.substr(0, pos);
        result.push_back(stoi(token));
        input.erase(0, pos+delim.length());
        pos = input.find(delim);
    }
    result.push_back(stoi(input));

    return result;
}

class Tile {
public:
    Tile(int row, int col, vector<string> &tiles) {
        blocks = vector<vector<int>>(row, vector<int>(col, 0));

        for (int r=0; r<row; r++) {
            vector<int> columns = Split(tiles[r], " ");

            for (int c=0; c<col; c++) {
                Set(columns[c], r, c);
            }
        }
    }
    Tile(const Tile &other):highest(other.highest), lowest(other.lowest) {
        copy(other.blocks.begin(), other.blocks.end(), back_inserter(blocks));
    }
    
    void Set(int height, int x, int y) {
        blocks[x][y] = height;

        if (highest < height) highest = height;
        if (lowest > height) lowest = height;
    }

    void Dig(int x, int y, int times=1) {
        blocks[x][y] -= times;
    }

    void Place(int x, int y, int times=1) {
        blocks[x][y] += times;
    }

    int Height(int x, int y) {
        return blocks[x][y];
    }

    bool IsDiggable(int x, int y, int times = 1) {
        return (Height(x, y) - times) >= 0;
    }

    bool IsPlacable(int x, int y, int times = 1) {
        return (Height(x, y) + times) <= 256;
    }

    int GetHighest() { return highest; }
    int GetLowest() { return lowest; }
    int GetRows() { return blocks.size(); }
    int GetCols() { return blocks[0].size(); }
private:
    vector<vector<int>> blocks;
    int highest = -1;
    int lowest = 257;
};

class Player {
public:
    Player(int blocks): blocks(blocks) {};
    Player(const Player &other): blocks(other.blocks) {};

    bool Dig(Tile &tile, int x, int y, int times = 1) {
        if (!tile.IsDiggable(x, y, times)) return false;
        
        tile.Dig(x, y, times);
        blocks += times;
        return true;
    }

    bool Place(Tile &tile, int x, int y, int times = 1) {
        if (!tile.IsPlacable(x, y, times)) return false;
        if (blocks < times) return false;

        tile.Place(x, y, times);
        blocks -= times;
        return true;
    }

    unsigned long long GetBlocks() { return blocks; }
private:
    unsigned long long blocks = 0;
};

class Flattener {
public:
    Flattener(Tile &tile, Player &player): tile(tile), player(player) {};

    long long Flatten(int height) {
        // 복사생성자 활용
        Tile copyTile = tile;
        Player copyPlayer = player;

        long long timeTaken = 0;

        // 1. 높은 곳을 파낸다.
        for (int r=0; r<copyTile.GetRows(); r++) {
            for (int c=0; c<copyTile.GetCols(); c++) {
                int numDig = copyTile.Height(r,c) - height;
                if (numDig <= 0) continue;

                copyPlayer.Dig(copyTile, r, c, numDig);
                timeTaken += (COST_DIG * numDig);
            }
        }

        // 2. 낮은 곳을 메운다. 
        for (int r=0; r<copyTile.GetRows(); r++) {
            for (int c=0; c<copyTile.GetCols(); c++) {
                int numPlace = height - copyTile.Height(r,c);
                if (numPlace == 0) continue;

                bool success = copyPlayer.Place(copyTile, r, c, numPlace);
                if (!success) return -1;

                timeTaken += (COST_PLACE * numPlace);
            }
        }

        return timeTaken;
    }

private:
    Tile &tile;
    Player &player;

    const int COST_DIG = 2;
    const int COST_PLACE = 1;
};

int main() {
    string input;
    getline(cin, input);
    vector<int> info = Split(input, " ");

    int row, col, blocks;
    row = info[0];
    col = info[1];
    blocks = info[2];

    vector<string> tiles;
    for (int r=0; r<row; r++) {
        getline(cin, input);
        tiles.push_back(input);
    }

    Tile tile(row, col, tiles);
    Player player(blocks);
    Flattener flattener(tile, player);
    
    long long bestTime = numeric_limits<long long>::max();
    int bestHeight = 0;
    for (int h=tile.GetLowest(); h<=tile.GetHighest(); h++) {
        long long timeTaken = flattener.Flatten(h);
        if (timeTaken == -1) continue;

        if (timeTaken <= bestTime) {
            bestTime = timeTaken;
            bestHeight = h;
        }
    }

    cout << bestTime << " " << bestHeight << endl;
}