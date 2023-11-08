class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        int xDiff = Math.abs(sx-fx);
        int yDiff = Math.abs(sy-fy);
        int diagonalDistance = Math.min(xDiff,yDiff);
        xDiff -= diagonalDistance;
        yDiff -= diagonalDistance;
        
        diagonalDistance += xDiff + yDiff;
        if(diagonalDistance == 0){
            return t!=1;
        }
        return (diagonalDistance<=t );
    }
}