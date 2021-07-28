#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <queue>
using namespace std;

typedef struct TreeNode863 {
    int val;
    TreeNode863 *left;
    TreeNode863 *right;
    TreeNode863(int x) : val(x), left(NULL), right(NULL) {}
}TreeNode863;

static const int N = 1010 , M =  N *2;
static int* he , *edge , *ne;
static int idx;

static void add(int a , int b){
    edge[idx] = b;
    ne[idx] = he[a];
    he[a] = idx++;
}

static void dfs(TreeNode863& root){

    if(root.left != NULL){
        add(root.val , root.left->val);
        add(root.left->val , root.val);
        dfs( * root.left);
    }

    if(root.right != NULL){
        add(root.val , root.right->val);
        add(root.right->val , root.val);
        dfs(* root.right);
    }
}

// 树 转 图
vector<int> distanceK(TreeNode863* root, TreeNode863* target, int k) {

    he = new int[N];
    edge = new int[M];
    ne = new int[M];
    idx = 0;
    for(int i = 0 ; i < N ;i++){
        he[i] = -1;
    }

    vector<int> res;

    // 通过dfs将二叉树转换成图
    dfs(*root);

    // 通过bfs做搜索
    queue<int> deque;
    deque.push(target->val);
    bool* vis = new bool[N];
    for(int i = 0 ; i < N;  i++){
        vis[i] = false;
    }
    vis[target->val] = true;

    while(!deque.empty() && k >= 0){
        int size = deque.size();

        while(size-- > 0){

            int pollVal = deque.front();
            deque.pop();
            if(k == 0){
                res.push_back(pollVal);
                continue;
            }

            for(int i = he[pollVal] ; i != -1; i = ne[i]){
                int j = edge[i];
                if(vis[j] == false){
                    deque.push(j);
                    vis[j] = true;
                }
            }
        }

        k--;


    }

    return res;
}

void Leetcode863_Main(){

//    root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
    TreeNode863* root = new TreeNode863(3);
    TreeNode863* node01 = new TreeNode863(5); root->left = node01;
    TreeNode863* node02 = new TreeNode863(1); root->right = node02;
    TreeNode863* node03 = new TreeNode863(6); node01->left = node03;
    TreeNode863* node04 = new TreeNode863(2); node01->right = node04;
    TreeNode863* node05 = new TreeNode863(0); node02->left = node05;
    TreeNode863* node06 = new TreeNode863(8); node02->right = node06;
    TreeNode863* node07 = new TreeNode863(7); node04->left = node07;
    TreeNode863* node08 = new TreeNode863(4); node04->right = node08;


    vector<int> res = distanceK(root , node01 , 2);

    for (auto num  : res ) {
        cout << num << " ";
    }
    cout << endl;


}





