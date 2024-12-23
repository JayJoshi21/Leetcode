/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minimumOperations(TreeNode* root) {
        // Helper function to calculate the minimum number of swaps to sort an array
        auto minSwaps = [](vector<int>& arr) -> int {
            int n = arr.size();
            vector<pair<int, int>> sortedArr(n);
            for (int i = 0; i < n; ++i) {
                sortedArr[i] = {arr[i], i};
            }
            sort(sortedArr.begin(), sortedArr.end()); // Sort by value
            
            vector<bool> visited(n, false);
            int swaps = 0;
            
            for (int i = 0; i < n; ++i) {
                if (visited[i] || sortedArr[i].second == i) {
                    continue; // Already visited or in the correct position
                }
                
                // Count the size of the cycle
                int cycleSize = 0;
                int x = i;
                while (!visited[x]) {
                    visited[x] = true;
                    x = sortedArr[x].second;
                    cycleSize++;
                }
                
                if (cycleSize > 1) {
                    swaps += cycleSize - 1;
                }
            }
            
            return swaps;
        };
        
        queue<TreeNode*> q;
        q.push(root);
        int totalSwaps = 0;
        
        while (!q.empty()) {
            int size = q.size();
            vector<int> levelValues;
            
            // Collect all node values at the current level
            for (int i = 0; i < size; ++i) {
                TreeNode* node = q.front();
                q.pop();
                levelValues.push_back(node->val);
                
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
            
            // Calculate the minimum number of swaps needed to sort this level
            totalSwaps += minSwaps(levelValues);
        }
        
        return totalSwaps;
    }
};
