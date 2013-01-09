public class House {
    public static final int N = 4;
    public static void main(String[] args) {
        printPath(0,0);
    }

    public static void printPath(int x, int y) {
        int[][] grid = new int[N][N];
        findPath(x,y,grid,1);

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
    }

    public static void findPath(int x, int y, int[][] grid, int count) {
        if(x<0 || x>N-1) {
            return;
        }
        if(y<0 || y>N-1) {
            return;
        }
        if(count>N*N) {
            return;
        }
        if(grid[x][y]>0) {
            return;
        }
        grid[x][y] = count;
        for(int i=0;i<N;i++) {
            
            findPath(x-1, y, grid, count+1);
            findPath(x-1, y+1, grid, count+1);
            findPath(x-1, y-1, grid, count+1);
            findPath(x+1, y, grid, count+1);
            findPath(x+1, y+1, grid, count+1);
            findPath(x+1, y-1, grid, count+1);
            findPath(x, y, grid, count+1);
            findPath(x, y+1, grid, count+1);
            findPath(x, y-1, grid, count+1);
        }
        grid[x][y] = 0;
    }
}