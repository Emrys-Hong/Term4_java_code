package com.example.pset2a;


import java.util.ArrayList;
public class GetPath {
    public static boolean getPath(int r, int c, ArrayList<Point> path, final int[][] grid) {

        if (path.size() == 0) {
            // there is no point in the path yet
            path.add(new Point(0, 0));
            return GetPath.getPath(r, c, path, grid);
        }

        else {
            // main code
            Point lastP = path.get(path.size()-1);
            if (lastP.x == r && lastP.y == c-1 && grid[r][c] == 0) {
                // one more step towards the end
                path.add(new Point(r, c));
                return true;
            } else if (lastP.x == r-1 && lastP.y == c && grid[r][c] == 0) {
                // one more step towards the end
                path.add(new Point(r, c));
                return true;
            } else if (lastP.x <= r && lastP.y < c && (grid[lastP.x][lastP.y+1] == 0)) {
                // can move horizontal this step
                path.add(new Point(lastP.x, lastP.y+1));
                if (GetPath.getPath(r, c, path, grid)) {
                    return true;
                } else {
                    // the later step said cannot move horizontal
                    path.remove(path.size() - 1);
                    int[][] newGrid = grid.clone();
                    newGrid[lastP.x][lastP.y+1] = 1;
                    return GetPath.getPath(r, c, path, newGrid);
                }
            } else if (lastP.x < r && lastP.y <= c && grid[lastP.x+1][lastP.y] == 0) {
                // must move vertical
                path.add(new Point(lastP.x + 1, lastP.y));
                if (GetPath.getPath(r, c, path, grid)) {
                    return true;
                } else {
                    // the later step said cannot move vertical, there is no choice
                    path.remove(path.size()-1);
                    return false;
                }
            } else {
                // other cases
                return false;
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

