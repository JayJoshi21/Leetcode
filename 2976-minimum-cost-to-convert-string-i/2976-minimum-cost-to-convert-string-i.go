import (
    "math"
)

func minimumCost(source string, target string, original []byte, changed []byte, cost []int) int64 {
    // Initialize the cost matrix with infinite cost
    const inf = math.MaxInt64
    costMatrix := make([][]int, 26)
    for i := range costMatrix {
        costMatrix[i] = make([]int, 26)
        for j := range costMatrix[i] {
            if i == j {
                costMatrix[i][j] = 0
            } else {
                costMatrix[i][j] = inf
            }
        }
    }

    // Populate the cost matrix with given transformations
    for i := 0; i < len(original); i++ {
        u := original[i] - 'a'
        v := changed[i] - 'a'
        costMatrix[u][v] = min(costMatrix[u][v], cost[i])
    }

    // Apply the Floyd-Warshall algorithm to find the minimum cost between any two characters
    for k := 0; k < 26; k++ {
        for i := 0; i < 26; i++ {
            for j := 0; j < 26; j++ {
                if costMatrix[i][k] < inf && costMatrix[k][j] < inf {
                    costMatrix[i][j] = min(costMatrix[i][j], costMatrix[i][k] + costMatrix[k][j])
                }
            }
        }
    }

    // Calculate the total minimum cost to convert source to target
    totalCost := int64(0)
    for i := 0; i < len(source); i++ {
        if source[i] == target[i] {
            continue
        }
        u := source[i] - 'a'
        v := target[i] - 'a'
        if costMatrix[u][v] == inf {
            return -1
        }
        totalCost += int64(costMatrix[u][v])
    }

    return totalCost
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
