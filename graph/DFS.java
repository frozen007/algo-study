import java.util.*;

public class DFS {
    public static void main(String[] args) throws Exception {
        ArrayList<Node>[] adjtab = Dijkstra.readGraph(args[0], false);
        Dijkstra.printGraphAdj(adjtab);

        int startnode = Integer.parseInt(args[1]);
        int vcount = adjtab.length - 1;

        int[][] record = new int[vcount+1][4]; //0:Num 1:Low 2:Visited 3:Parent
        assignNum(1,1,adjtab,record);

        System.out.println("record num:");
        for(int i=1;i<=vcount;i++) {
            for(int j=0;j<4;j++) {
                System.out.print(record[i][j]+",");
            }
            System.out.println();
        }

        System.out.println();
        assignLow(1,adjtab,record);
        System.out.println();

        System.out.println("record low:");
        for(int i=1;i<=vcount;i++) {
            for(int j=0;j<4;j++) {
                System.out.print(record[i][j]+",");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static int assignNum(int v, int count, ArrayList<Node>[] adjtab, int[][] record) {
        int tmpCount = count;
        record[v][0] = count;
        record[v][2] = 1;
        ArrayList<Node> adjnodes = adjtab[v];
        if(adjnodes!=null) {
            for(Node n : adjnodes) {
                if(record[n.v][2] == 0) {
                    record[n.v][3] = v;
                    tmpCount = assignNum(n.v, tmpCount+1, adjtab, record);
                }
            }
        }
        return tmpCount;
    }

    public static void assignLow(int v, ArrayList<Node>[] adjtab, int[][] record) {
        record[v][1] = record[v][0];
        ArrayList<Node> adjnodes = adjtab[v];
        if(adjnodes!=null) {
            for(Node n : adjnodes) {
                if(record[n.v][0]>record[v][0]) {
                    assignLow(n.v, adjtab, record);
                    //output articulator
                    if(record[n.v][1]>=record[v][0]) {
                        System.out.print(v+"|");
                    }
                    if(record[v][1]>record[n.v][1]) {
                        record[v][1] = record[n.v][1];
                    }
                } else {
                    if(record[n.v][3]!=v) {
                        if(record[v][1]>record[n.v][0]) {
                            record[v][1] = record[n.v][0];
                        }
                    }
                }
            }
        }
        
    }
}