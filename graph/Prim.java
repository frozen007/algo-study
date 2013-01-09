import java.util.*;

public class Prim {
    public static void main(String[] args) throws Exception {
        ArrayList<Node>[] adjtab = Dijkstra.readGraph(args[0], false);
        Dijkstra.printGraphAdj(adjtab);

        int startnode = Integer.parseInt(args[1]);
        int vcount = adjtab.length - 1;
        int[][] record = new int[vcount+1][3];//0-known? 1-dist 2-path
        for(int i=0;i<vcount+1;i++) {
            record[i][1] = Integer.MAX_VALUE;
        }
        record[startnode][1] = 0;
        record[startnode][2] = startnode;

        int minNode = startnode;
        while(minNode>0) {
            
            record[minNode][0] = 1;
            ArrayList<Node> adjNodes = adjtab[minNode];
            if(adjNodes!=null) {
                for(Node node : adjNodes) {
                    if(record[node.v][1]>node.dist && record[node.v][0]==0) {
                        record[node.v][1] = node.dist;
                        record[node.v][2] = minNode;
                    }
                }
            }

            minNode = getMinNode(record, vcount);
        }

        System.out.println();
        System.out.println("record:");
        for(int i=1;i<vcount+1;i++) {
            System.out.print(i+", dist:"+record[i][1]+",path:"+record[i][2]);
            
            System.out.println();
        }
        System.out.println();
    }

    public static int getMinNode(int[][] record, int vcount) {
        int minV = Integer.MAX_VALUE;
        int minNode = 0;
        for(int i=1;i<=vcount;i++) {
            if(record[i][0]==0) {
                if(record[i][1]<minV) {
                    minV = record[i][1];
                    minNode = i;
                }
            }
        }
        return minNode;
    }
}