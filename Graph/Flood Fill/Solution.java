class Solution {
    public void coloring(int[][] image, int sr, int sc, int color,int str) {
        if (sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 ||image[sr][sc] != str  || image[sr][sc]==color) {
            return;
        }
        image[sr][sc] = color;
        // top
        coloring(image, sr - 1, sc, color,str);
        // bottom
        coloring(image, sr + 1, sc, color,str);
        // left
        coloring(image, sr, sc - 1, color,str);
        // right
        coloring(image, sr, sc + 1, color,str);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int str=image[sr][sc];
        coloring(image, sr, sc, color,str);
        return image;
    }
}