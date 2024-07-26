package main

import (
    "math"
)

func findTheCity(n int, edges [][]int, distanceThreshold int) int {
    // Initialize distance matrix
    const INF = math.MaxInt32
    dist := make([][]int, n)
    for i := 0; i < n; i++ {
        dist[i] = make([]int, n)
        for j := 0; j < n; j++ {
            if i == j {
                dist[i][j] = 0
            } else {
                dist[i][j] = INF
            }
        }
    }

    // Populate the initial distances based on edges
    for _, edge := range edges {
        u, v, w := edge[0], edge[1], edge[2]
        dist[u][v] = w
        dist[v][u] = w
    }

    // Floyd-Warshall algorithm to compute shortest paths
    for k := 0; k < n; k++ {
        for i := 0; i < n; i++ {
            for j := 0; j < n; j++ {
                if dist[i][j] > dist[i][k] + dist[k][j] {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    // Determine the city with the smallest number of reachable cities
    minReachable := n
    cityWithMinReachable := -1

    for i := 0; i < n; i++ {
        reachableCount := 0
        for j := 0; j < n; j++ {
            if dist[i][j] <= distanceThreshold {
                reachableCount++
            }
        }
        if reachableCount < minReachable || (reachableCount == minReachable && i > cityWithMinReachable) {
            minReachable = reachableCount
            cityWithMinReachable = i
        }
    }

    return cityWithMinReachable
}
