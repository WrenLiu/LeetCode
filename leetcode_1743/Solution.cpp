#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <set>
using namespace std;



vector<int> restoreArray(vector<vector<int>>& adjacentPairs){

    int len = adjacentPairs.size()+1;
    unordered_map<int ,vector<int>> map;
    for(auto num : adjacentPairs){
        map[num[0]].push_back(num[1]);
        map[num[1]].push_back(num[0]);
    }

    vector<int> res;

    for(auto& x : map){
        if(x.second.size() == 1){
            res.push_back(x.first);
            break;
        }
    }

    res.push_back(map[res[0]][0]);



    for(int i = 2; i < len; i++ ){

        int tmp = map[res.at(i-1)][0] == res.at(i-2) ? map[res.at(i-1)][1] : map[res.at(i-1)][0] ;
        res.push_back(tmp);
    }




    return res;



}


vector<int> restoreArray_mine(vector<vector<int>>& adjacentPairs) {


    set<int> setArray;

    int beginNum , endNum , len;

    vector<int> res ;
    len =  adjacentPairs.size()+1;


    for(int i = 0; i < adjacentPairs.size(); i++){
        if(setArray.count(adjacentPairs.at(i).at(0)) == 0){
            setArray.insert(adjacentPairs.at(i).at(0));
        }else{
            setArray.erase(adjacentPairs.at(i).at(0));
        }

        if(setArray.count(adjacentPairs.at(i).at(1)) == 0){
            setArray.insert(adjacentPairs.at(i).at(1));
        }else {
            setArray.erase(adjacentPairs.at(i).at(1));
        }

    }

    vector<int> vv;
    for (int tmp  : setArray ) {
        vv.push_back(tmp);
    }

    beginNum = vv.at(0);
    endNum = vv.at(1);

    res.push_back(beginNum);




    for(int curIndex = 1; curIndex < len ;curIndex++){

        for(int i =0 ; i < adjacentPairs.size() ; i++){
            vector<int> vectorIter = adjacentPairs.at(i);

            if(vectorIter.at(0) == res.at(curIndex-1)){
                res.push_back(vectorIter.at(1));
                adjacentPairs.erase(adjacentPairs.begin() + i);

                break;
            }else if(vectorIter.at(1) == res.at(curIndex-1)){
                res.push_back(vectorIter.at(0));
                adjacentPairs.erase(adjacentPairs.begin() + i);

                break;
            }


        }

    }

    return res;

}


void Leetcode1743_Main(){

    int adjacentPairs[][2] = {{2,1},{3,4},{3,2}};

    vector<vector<int>> adjacentPairsVector;

    for(int i = 0 ; i < sizeof(adjacentPairs) / sizeof(adjacentPairs[0]) ; i++){
        vector<int> veTmp ;
        for(int j = 0 ; j < sizeof(adjacentPairs[0]) ; j++){
            veTmp.push_back(adjacentPairs[i][j]);
        }
        adjacentPairsVector.push_back(veTmp);
    }

    vector<int> res = restoreArray(adjacentPairsVector);

    for (int tmp  : res) {
        cout << tmp << " ";
    }
    cout << endl;






}
