#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
#include <algorithm>
#include <set>
#include <math.h>
using namespace std;

#define PRINT_INT(n) printf("%d\n",n)


typedef struct ListNode2074 {
    int val;
    ListNode2074 *next;
    ListNode2074() : val(0), next(nullptr) {}
    ListNode2074(int x) : val(x), next(nullptr) {}
    ListNode2074(int x, ListNode2074 *next) : val(x), next(next) {}
}ListNode2074;

ListNode2074* reverseEvenLengthGroups(ListNode2074 *head) {

    if(head->next == nullptr || head->next->next == nullptr){
        return head;
    }

    int base = 1;
    ListNode2074 *leftNode = head;
    ListNode2074 *rightNode = head;

    while(rightNode != nullptr){

        int cnt = 1;

        rightNode = leftNode;

        // leftNode is in the first node
        while(cnt < base && rightNode != nullptr){

            rightNode = rightNode->next;
            cnt++;

        }

        if(rightNode == nullptr){
            cnt--;
        }

        cout << leftNode->val << "  " << "  cnt: " << cnt << endl;

        // reverse
        if(cnt % 2 == 0){

            vector<int> arr ;

            ListNode2074 *curNode = leftNode;

            for(int i = 0; i < cnt; i++){

                arr.push_back(curNode->val);
                curNode = curNode->next;
            }

            curNode = leftNode;
            for(int i = cnt-1; i >= 0; i--){
                curNode->val = arr[i];
                curNode = curNode->next;
            }
        }

        if(rightNode == nullptr){
            break;
        }else{

            leftNode = rightNode->next;
            rightNode = leftNode;

        }



        base += 1;

    }

    return head;



}

void leetcode_2074(void){

//输入：head = [5,2,6,3,9,1,7,3,8,4]
//输出：[5,6,2,3,9,1,4,8,3,7]
//

    ListNode2074 *head = new ListNode2074(5, nullptr);

    ListNode2074 *curNode = head;

    ListNode2074 *nextNode = new ListNode2074(2, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(6, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(3, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(9, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(1, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(7, nullptr);
    curNode->next = nextNode; curNode = nextNode;

    nextNode = new ListNode2074(3, nullptr);
    curNode->next = nextNode; curNode = nextNode;


    curNode = head;
    while(curNode != nullptr){

        cout << curNode->val << "  ";
        curNode = curNode->next;

    }

    cout << endl;

    curNode = reverseEvenLengthGroups(head);


    cout << "result  " ;
    while(curNode != nullptr){

        cout << curNode->val << "  ";
        curNode = curNode->next;

    }
    cout << endl;



}