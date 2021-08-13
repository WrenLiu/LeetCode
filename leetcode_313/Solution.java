#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <queue>
#include <set>

using namespace std;

int nthSuperUglyNumber(int n, vector<int>& primes) {

    if(n == 1){
        return 1;
    }

    int pLen = primes.size();

    int* indexs = (int*)malloc(sizeof(int ) * pLen);

    for (int l = 0; l < pLen; ++l) {
        indexs[l] = 0;
    }
    int* dp = (int *)malloc(sizeof(int) * n);

    for (int m = 0; m < n; ++m) {
        dp[m] = 0;
    }

    dp[0] = 1;

    for (int i = 1; i < n; ++i) {

        // 因为选择最小值，所以选择一个最大值
        dp[i] = INT64_MAX;

        for (int j = 0; j < pLen; ++j) {
            dp[i] = min(dp[i] , dp[indexs[j]] * primes[j]);
        }

        // dp[i] 是之前的哪个丑数乘以对应的 primes[j] 选出来的，给它加 1
        for (int k = 0; k < pLen; ++k) {
            // 注意：这里不止执行一次，例如选出 14 的时候，2 和 7 对应的最小丑数下标都要加 1
            if(dp[i] == dp[indexs[k]] * primes[k]){
                indexs[k]++;
            }
        }

    }

    int res = dp[n-1];


    return res;


}

// 超时
int nthSuperUglyNumber_heap(int n, vector<int>& primes) {


    if(n == 1){
        return 1;
    }
    set<long> set ;
    priority_queue<long,vector<long>,greater<long> > small_heap;

    small_heap.push(1L);
    set.insert(1L);

    long x = 0;
    for (int i = 0; i < n-1; ++i) {

        long x = small_heap.top();

        small_heap.pop();

        for(int tmp : primes){

            if(set.count(x * tmp) == 0){
                set.insert(x * tmp);
                small_heap.push(x*tmp);

            }
        }

    }


    return (int) small_heap.top();





}


void Leetcode313_Main(){

    int n = 12;
    vector<int> nums = {2,7,13,19};


    cout << nthSuperUglyNumber(n , nums) << endl;


}
