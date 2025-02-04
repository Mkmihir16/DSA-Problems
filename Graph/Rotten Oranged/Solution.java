class Solution {
    public class Pair {
        int row;
        int col;
        int t;

        Pair(int row, int col, int t) {
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int tm = 0;
        int newrow[] = { -1, 0, 1, 0 };
        int newcol[] = { 0, -1, 0, 1 };
        int count = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().t;

            tm = Math.max(tm, t);
            Pair p = q.poll();
            for (int i = 0; i < newrow.length; i++) {
                int _nr = r + newrow[i];
                int _nc = c + newcol[i];
                if (_nr >= 0 && _nr < m && _nc >= 0 && _nc < n && vis[_nr][_nc] == 0 && grid[_nr][_nc] == 1) {
                        q.add(new Pair(_nr,_nc,tm+1));
                        count++;
                        vis[_nr][_nc]=2;
                }
            }
        }
        if(count!=countFresh) return -1;
        return tm;
    }
}