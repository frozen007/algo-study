public class DigitTower {
    public static void main(String[] args) {
        int[][] d = new int[][]{
                {7,0,0,0,0},
                {3,8,0,0,0},
                {8,1,0,0,0},
                {2,7,4,4,0},
                {4,5,2,6,5}
            };
        printResult(d, 5);
    }

    public static void printResult(int[][] d, int n) {
        int[][] c = new int[n+1][n+1];
        Node[][] nodeArray = new Node[n+1][n+1];
        Node maxNode = null;
        int maxV = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                int v = d[i-1][j-1];
                if(i==1 && j==1) {
                    c[i][j]=v;
                    break;
                }

                if(i==j) {
                    c[i][j]=c[i-1][j-1] + v;
                    nodeArray[i][j] = new Node(i-1,j-1);
                } else {
                    if(c[i-1][j-1]>c[i-1][j]) {
                        c[i][j]=c[i-1][j-1] + v;
                        nodeArray[i][j] = new Node(i-1,j-1);
                    } else {
                        c[i][j]=c[i-1][j] + v;
                        nodeArray[i][j] = new Node(i-1,j);
                    }
                }
                if(c[i][j]>maxV) {
                    maxV = c[i][j];
                    maxNode = new Node(i,j);
                }
            }
        }

        System.out.println();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                System.out.print(c[i][j]+",");
            }
            System.out.println();
        }

        System.out.println();
        Node p = maxNode;
        while(p!=null) {
            System.out.print(d[p.x-1][p.y-1]+",");
            p = nodeArray[p.x][p.y];
        }
    }

    public static class Node {
        int x=0;
        int y=0;
        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}