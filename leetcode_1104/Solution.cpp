#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;


vector<int> pathInZigZagTree_leetcode(int label) {

    int level = 0;
    while (label >= pow(2, level)) {
        level++;
    };
    vector<int> ans;

    if (level % 2 != 0) {
        label -= pow(2, level - 1) - 1;
    } else {
        label = pow(2, level) - label;
    }

    while (level) {
        if (level % 2 != 0) {
            ans.push_back(pow(2, level - 1) + label - 1);
        } else {
            ans.push_back(pow(2, level) - label);
        }
        label = (label + 1) / 2;
        level--;
    }

    reverse(ans.begin(), ans.end());
    return ans;



}
static int getStart(int level){
    return (int )pow(2 , level-1);
}

static int getEnd(int level){
    int a = (int )getStart(level);
    return a + a - 1;
}

// Leetcode编译不通过
vector<int> pathInZigZagTree(int label) {

    int layer = 1;
    while(getEnd(layer) < label) layer ++;

    vector<int> ans(layer);

    int cur = label;
    int idx = layer - 1;

    while(idx >= 0){

        ans[idx--] = cur;
        int loc = ((1 << (layer)) - 1 - cur) >> 1;
        cur = ( 1 << (layer - 2)) + loc;
        layer--;

    }



    reverse(ans.begin(), ans.end());

    return ans;

}

void Leetcode1104_Main(){


    vector<int> res = pathInZigZagTree(14);

    for ( int tmp : res) {

        cout << tmp << " ";
    }
    cout << endl;



}

