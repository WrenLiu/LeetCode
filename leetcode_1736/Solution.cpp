
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;



string maximumTime_leetcode(string time) {
    if(time[0]=='?'){
        if(time[1]!='?'&&time[1]>'3') time[0]='1';
        else time[0]='2';
    }
    if(time[1]=='?'){
        if(time[0]=='2') time[1]='3';
        else if(time[0]=='1') time[1]='9';
        else if(time[0]=='0') time[1]='9';
    }
    if(time[3]=='?') time[3]='5';
    if(time[4]=='?') time[4]='9';
    return time;
}


string maximumTime(string time) {


    string res = "";
    char& ch = time.at(0);
    // 处理第一位
    if(time.at(0) == '?'){

        if(time.at(1) >= '4' && time.at(1) <= '9'){
            res += "1";
        }else {
            res += "2";
        }



    }else {
        res = res + time.at(0);
    }

    // 处理第二位
    if(time.at(1) == '?'){

        if(time.at(0) == '0' || time.at(0) == '1'){
            res += "9";
        }else {
            res += "3";
        }
    }else{
        res += time.at(1);
    }

    res += ":";

    // 处理第三位
    if(time.at(3) == '?'){
        res += "5";
    }else {
        res += time.at(3);
    }

    // 处理第4位
    if(time.at(4) == '?'){
        res += "9";
    }else {
        res += time.at(4);
    }



    return res;





}


void Leetcode1736_Main(){

    string time = "?4:03";


    cout << maximumTime(time) << endl;


}







