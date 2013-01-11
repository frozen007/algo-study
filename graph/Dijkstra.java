import java.util.*;
import java.io.*;

public class Dijkstra {
    public static void main(String[] args) throws Exception{
        ArrayList<Node>[] adjtab = readGraph(args[0], true);
        printGraphAdj(adjtab);

        int startnode = Integer.parseInt(args[1]);
        int vcount = adjtab.length - 1;
        int[][] result = new int[vcount + 1][4];//4: 0-known? 1-dist 2-path 3-in heap pos
        for(int i=0;i<vcount+1;i++) {
            result[i][1] = Integer.MAX_VALUE;
        }
        result[startnode][1] = 0;
        result[startnode][2] = startnode;
        QueueHeap queue = new QueueHeap(vcount, result);
        queue.add(startnode);
        
        while(queue.currentlen>0) {
            int curnode = queue.findMin();
            if(result[curnode][0]==1) {
                continue;
            }
            result[curnode][0] =1;
            ArrayList<Node> adjnodes = (ArrayList<Node>)adjtab[curnode];
            if(adjnodes!=null) {
                for(Node n : adjnodes) {
                    int newdist = result[curnode][1]+n.dist;
                    if(newdist<result[n.v][1]) {
                        result[n.v][1]=newdist;
                        result[n.v][2]=curnode;
                        if(result[n.v][3]==0) {
                            queue.add(n.v);
                        } else {
                            queue.perloacteUp(result[n.v][3]);
                        }
                    }
                }
            }
        }
        
        System.out.println();
        System.out.println("result:");
        for(int i=1;i<vcount+1;i++) {
            System.out.print(i+", dist:"+result[i][1]+",path:"+result[i][2]);
            
            System.out.println();
        }
    }

    static class QueueHeap {
        int[][] record = null;
        int[] heaparray = null;
        int currentlen = 0;
        
        public QueueHeap(int heapsize, int[][] record) {
            heaparray = new int[heapsize+1];
            this.record=record;
        }

        public void add(int v) {
            currentlen++;
            heaparray[currentlen] = v;
            perloacteUp(currentlen);
        }

        public int perloacteUp(int pos) {
            int tmp = heaparray[pos];
            int cur = pos;
            int hole = cur;
            for(;cur/2>0;hole=cur) {
                cur/=2;
                if(tmp<heaparray[cur]) {
                    heaparray[hole] = heaparray[cur];
                    record[heaparray[cur]][3] = hole;
                } else {
                    break;
                }
            }
            heaparray[hole] = tmp;
            record[tmp][3] = hole;
            return hole;
        }

        public int perloacteDown(int pos) {
            int head = heaparray[pos];
            int cur = pos;
            int hole = pos;
            for(;cur*2<=currentlen;hole=cur) {
                cur*=2;
                if(cur!=currentlen && record[cur][1]>record[cur+1][1]) {
                    cur++;
                }
                if(record[head][1] < record[cur][1]) {
                    break;
                } else {
                    heaparray[hole] = heaparray[cur];
                    record[heaparray[cur]][3] = hole;
                }
            }
            heaparray[hole] = head;
            record[head][3] = hole;
            return hole;
        }

        public int findMin() {
            int min = heaparray[1];
            heaparray[1] = heaparray[currentlen];
            currentlen--;
            perloacteDown(1);
            return min;
        }

    }
    

    public static ArrayList<Node>[] readGraph(String file, boolean functional) throws Exception {
        HashMap<String, ArrayList<Node>> adjtab = new HashMap<String, ArrayList<Node>>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        int vcount = Integer.parseInt(line);
        line = reader.readLine();
        while(line!=null&&!"".equals(line)) {
            String[] input = line.split(",");
            String dist = "1";
            if(input.length>2) {
                dist = input[2];
            }

            addFromToNode(input[0], input[1], dist, adjtab);

            if(functional==false) {
                addFromToNode(input[1], input[0], dist, adjtab);
            }

            line = reader.readLine();
        }
        ArrayList<Node>[] adjArray = new ArrayList[vcount+1];
        for(String key : adjtab.keySet()) {
            adjArray[Integer.parseInt(key)] = adjtab.get(key);
        }
        return adjArray;
    }

    private static void addFromToNode(String from, String to, String dist, HashMap<String, ArrayList<Node>> adjtab) {
        ArrayList<Node> adjNodes = adjtab.get(from);
        if(adjNodes==null) {
            adjNodes = new ArrayList<Node>();
            adjtab.put(from, adjNodes);
        }
        Node adjN = new Node();
        adjN.v = Integer.parseInt(to);
        adjN.dist = Integer.parseInt(dist);
        adjNodes.add(adjN);
    }

    public static void printGraphAdj(ArrayList<Node>[] adjtab) {
        System.out.println();
        for(int i=1;i<adjtab.length;i++) {
            System.out.print(i+" : ");
            ArrayList<Node> adjNodes = adjtab[i];
            if(adjNodes!=null) {
                for(Node adjN : adjNodes) {
                    System.out.print("(" + i + "->" + adjN.v + "," + adjN.dist + "),");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}