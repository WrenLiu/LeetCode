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



int triangleNumber(vector<int>& nums) {

    int len = nums.size();

    int res = 0;
    sort(nums.begin() ,nums.end());

    for(int i = 0; i < len ;i++){

        for(int right = i-1 , left = 0; left < right; right--){

            while(left < right && nums[i] >= nums[left] + nums[right]){
                left++;
            }

            res += right - left;
        }
    }

    return res;

}

void Leetcode611_Main(){

    int nums[] = {2,2,3,4};
    vector<int> ve;

    for(int i =0 ; i < sizeof(nums)/sizeof(int) ; i++){
        ve.push_back(nums[i]);
    }

    cout << triangleNumber(ve) << endl;








}