func maxDistance(arrays [][]int) int {
    // Initialize global min and max using the first array
    globalMin := arrays[0][0]
    globalMax := arrays[0][len(arrays[0])-1]
    
    // Initialize max distance
    maxDist := 0
    
    // Iterate over the remaining arrays
    for i := 1; i < len(arrays); i++ {
        currentMin := arrays[i][0]
        currentMax := arrays[i][len(arrays[i])-1]
        
        dist1 := abs(globalMax - currentMin)
        dist2 := abs(currentMax - globalMin)
        if dist1 > maxDist {
            maxDist = dist1
        }
        if dist2 > maxDist {
            maxDist = dist2
        }
        
        if currentMin < globalMin {
            globalMin = currentMin
        }
        if currentMax > globalMax {
            globalMax = currentMax
        }
    }
    
    return maxDist
}

// Helper function to calculate absolute value
func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}
