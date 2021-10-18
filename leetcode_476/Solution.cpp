#include <iostream>
#include <vector>
#include <math.h>
using namespace std;


#define PRINT_INT(n) printf("%d\n",n)


int findComplement_leetcode(int num){
    int s = -1;
    for (int i = 31; i >= 0; i--) {
        if (((num >> i) & 1) != 0) {
            s = i;
            break;
        }
    }

    int ans = 0;
    for (int i = 0; i < s; i++) {
        if (((num >> i) & 1) == 0) ans |= (1 << i);
    }
    return ans;
}


int findComplement(int num){

    int nums[32] = {0};

    for (int i = 0; i < 32; ++i) {
        nums[i] = num & (1 << i);
        nums[i] = nums[i] >= 1 ? 0 : 1;
    }


    int end = 32;
    for (int l = 31; l >= 0 ; --l) {
        if(nums[l] == 0){
            end = l + 1;
            break;
        }
    }
    
    int res = 0;
    for (int j = 0; j < end; ++j) {
        res += nums[j] * pow(2,j) ;
    }

    return res;

}

void leetcode_476(){
    cout << findComplement(5) << endl;
}
