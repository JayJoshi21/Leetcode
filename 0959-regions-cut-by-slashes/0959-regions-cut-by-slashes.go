func regionsBySlashes(grid []string) int {
    n := len(grid)
    parent := make([]int, 4*n*n)
    size := make([]int, 4*n*n)
    
    // Union-Find with Path Compression and Union by Size
    var find func(x int) int
    find = func(x int) int {
        if parent[x] != x {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    
    union := func(x, y int) {
        rootX := find(x)
        rootY := find(y)
        if rootX != rootY {
            if size[rootX] > size[rootY] {
                parent[rootY] = rootX
                size[rootX] += size[rootY]
            } else {
                parent[rootX] = rootY
                size[rootY] += size[rootX]
            }
        }
    }
    
    // Initialize the Union-Find structure
    for i := range parent {
        parent[i] = i
        size[i] = 1
    }
    
    for i := 0; i < n; i++ {
        for j := 0; j < n; j++ {
            baseIndex := 4 * (i*n + j)
            char := grid[i][j]
            
            // Connect internal triangles based on character
            if char == '/' {
                union(baseIndex+0, baseIndex+3) // connect top-left to bottom-right
                union(baseIndex+1, baseIndex+2) // connect top-right to bottom-left
            } else if char == '\\' {
                union(baseIndex+0, baseIndex+1) // connect top-left to top-right
                union(baseIndex+2, baseIndex+3) // connect bottom-left to bottom-right
            } else {
                union(baseIndex+0, baseIndex+1)
                union(baseIndex+1, baseIndex+2)
                union(baseIndex+2, baseIndex+3)
            }
            
            // Connect adjacent squares
            if i+1 < n {
                union(baseIndex+2, baseIndex+4*n+0) // connect bottom of current square to top of square below
            }
            if j+1 < n {
                union(baseIndex+1, baseIndex+4+3) // connect right of current square to left of square on the right
            }
        }
    }
    
    // Count unique regions
    uniqueRegions := 0
    for i := range parent {
        if find(i) == i {
            uniqueRegions++
        }
    }
    
    return uniqueRegions
}
