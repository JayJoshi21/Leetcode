#include <vector>
#include <deque>
#include <utility> // for pair
using namespace std;

class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();

        // Direction vectors for moving up, down, left, right
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Min-heap-like behavior using deque for 0-1 BFS
        deque<pair<int, int>> dq;
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX)); // Distance matrix
        
        // Start BFS from the top-left corner
        dq.push_front({0, 0});
        dist[0][0] = 0;

        while (!dq.empty()) {
            auto [x, y] = dq.front();
            dq.pop_front();

            for (auto [dx, dy] : directions) {
                int nx = x + dx, ny = y + dy;
                // Check if the new cell is within bounds
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        // If it's a 0, prioritize it (add to the front)
                        if (grid[nx][ny] == 0) {
                            dq.push_front({nx, ny});
                        } 
                        // If it's a 1, add it to the back
                        else {
                            dq.push_back({nx, ny});
                        }
                    }
                }
            }
        }

        // Return the distance to the bottom-right corner
        return dist[m - 1][n - 1];
    }
};
