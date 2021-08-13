#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;


int tribonacci(int n) {

    if(n == 0){
        return 0;
    }else if(n == 1){
        return 1;
    }else if(n == 2){
        return 1;
    }


    int a = 1;
    int b = 1;
    int c = 0;

    for (int i = 3; i <= n; ++i) {

        int tmpA = a;
        a = a + b + c;

        c = b;
        b = tmpA;
    }

    return a;

}


void Leetcode1137_Main(){


    int n = 25 ;

    cout << tribonacci(n) << endl;


}
