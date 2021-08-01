#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <queue>
#include <cmath>

using namespace std;


vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {

    int rows = mat.size();
    int cols = mat.at(0).size();

//    战斗值*100 + 行号，然后排序，排完序后再对100取余
    vector<int> arr ;

    for(int i =0 ;i < rows ; i++){

        vector<int> veTmp = mat.at(i);
        int tmpInt = 0;

        for(int j = 0; j < cols; j++){
            if(veTmp.at(j) == 1){
                tmpInt++;
            }else {
                break;
            }
        }

        arr.push_back(tmpInt*100+i);


    }

    sort(arr.begin() , arr.end());

    vector<int> res;

    for(int i = 0 ; i < k ;i++){
        res.push_back(  arr.at(i) % 100 );

    }

    return res;

}



void Leetcode1337_Main(){

    vector<vector<int>> mat;
    int nums[][4] = {{1,0,0,0},
                     {1,1,1,1},
                     {1,0,0,0},
                     {1,0,0,0}};
    int k = 2;
    for(int i = 0; i < sizeof(nums) / sizeof(nums[0]) ;i ++){

        vector<int> willbeadd;
        for(int j =0 ; j < sizeof(nums[0]) ; j++){
            willbeadd.push_back(nums[i][j]);
        }
        mat.push_back(willbeadd);
    }

    vector<int> res = kWeakestRows(mat , k);

    for ( int tmp : res) {
        cout << tmp << " " ;
    }

    cout << endl;


