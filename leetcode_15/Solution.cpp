#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <set>
using namespace std;


vector<vector<int>> threeSum(vector<int>& nums){

    // 关键在于避免重复的答案
    vector<vector<int>> res;
    vector<int> willBeAdded(3);

    int len = nums.size();

    sort(nums.begin() , nums.end());

    for(int curIndex = 0 ; curIndex < len && nums.at(curIndex) <= 0; curIndex++){

        int leftIndex = curIndex + 1 , rightIndex = len-1;

        while(leftIndex < rightIndex){

            if(nums[curIndex] + nums[leftIndex] + nums[rightIndex] > 0){
                rightIndex --;
            }else if(nums[curIndex] + nums[leftIndex] + nums[rightIndex] < 0){
                leftIndex++;
            }else {


                // 添加
                res.push_back({nums[curIndex] , nums[leftIndex] , nums[rightIndex]});

                // 相同的left和right不应该再次出现
                while(leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex+1]){
                    leftIndex ++;
                }

                while(rightIndex > leftIndex && nums[rightIndex] == nums[leftIndex]){
                    rightIndex --;
                }

                leftIndex ++;
                rightIndex--;

            }
        }

        // 避免nums[i]作为第一个参数出现
        while(curIndex + 1 < len && nums[curIndex] == nums[curIndex+1]){
            curIndex++;
        }





    }




    return res;

}


void Leetcode15_Main(){

    int nums[] = {-1,0,1,2,-1,-4};

    vector<int> numVe ;
    for(int i = 0 ;i < sizeof(nums)/sizeof(int) ; i++){
        numVe.push_back(nums[i]);
    }

    vector<vector<int>> res = threeSum(numVe);

    for(int i = 0 ; i < res.size() ; i++){
        cout << res.at(i)[0] << " " << res.at(i)[1] << " " << res.at(i)[2] << endl;
    }

}
