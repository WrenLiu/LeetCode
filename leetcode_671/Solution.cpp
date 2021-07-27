#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <set>
using namespace std;

static set<int> numSet;

typedef struct TreeNode671 {
    int val;
    TreeNode671 *left;
    TreeNode671 *right;
    TreeNode671() : val(0), left(nullptr), right(nullptr) {}
    TreeNode671(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode671(int x, TreeNode671 *left, TreeNode671 *right) : val(x), left(left), right(right) {}
}TreeNode671;


static int ans = -1;
static int rootVal;

static void dfs(TreeNode671* curnode){

    if(curnode == NULL) return;

    if(curnode->val != rootVal){
        if(ans == -1) ans = curnode->val;
        else ans = min(ans , curnode->val);
        return;
    }

    dfs(curnode->left );
    dfs(curnode->right);

}

// 最小值会不断向上传递，最终的根节点一定是最小值
static int findSecondMinimumValue(TreeNode671* root) {

    rootVal = root->val;
    dfs(root);

    return ans;
}


// 中序遍历
static void midShow(TreeNode671* curNode){

    if(curNode == NULL){
        return;
    }

    midShow(curNode->left);
    numSet.insert(curNode->val);

    midShow(curNode->right);

}
static int findSecondMinimumValue_mine(TreeNode671* root) {

    midShow(root);
    if(numSet.size() <= 1){
        return -1;
    }

    numSet.erase(*numSet.begin());





    return *numSet.begin();


}

void Leetcode671_Main(){
    TreeNode671* root = new TreeNode671(2);

    TreeNode671* node01 = new TreeNode671(2);
    TreeNode671* node02 = new TreeNode671(5);
    TreeNode671* node03 = new TreeNode671(5);
    TreeNode671* node04 = new TreeNode671(7);

    root->left = node01;
    root->right = node02;
    node02->left = node03;
    node02->right = node04;


    int res = findSecondMinimumValue(root);

    cout << "res " << res << endl;



}



