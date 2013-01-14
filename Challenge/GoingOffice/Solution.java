import java.util.*;

public class Solution {
    private HashMap<Integer, ArrayList<AdjNode>> adjtab = null;
    private int N;
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] input  = line.split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashMap<Integer, ArrayList<AdjNode>> adjtab = readGraph(scanner, M, false);
        
        input = scanner.nextLine().split(" ");
        int from = Integer.parseInt(input[0]);
        int to = Integer.parseInt(input[1]);

        Solution solution = new Solution(adjtab, N);
        line = scanner.nextLine();
        int Q = Integer.parseInt(line);

        line = scanner.nextLine();
        while(true) {
            input  = line.split(" ");
            int qu = Integer.parseInt(input[0]);
            int qv = Integer.parseInt(input[1]);
            int minDist = solution.calculateMinDist(from, to, qu, qv);
            if(Integer.MAX_VALUE == minDist) {
                System.out.println("Infinity");
            } else {
                System.out.println(minDist);
            }
            Q--;
            if(Q==0) {
                break;
            }
            line = scanner.nextLine();
        }
        
    }

    public Solution(HashMap<Integer, ArrayList<AdjNode>> adjtab, int N) {
        this.adjtab = adjtab;
        this.N = N;
    }

    public int calculateMinDist(int from, int to, int qu, int qv) throws Exception {
        Vertex[] record = new Vertex[N];
        //init record
        for(int i=0;i<N;i++) {
            record[i] = new Vertex();
            record[i].v = i;
        }

        Vertex vertex = record[from];
        QueueHeap pQueue = new QueueHeap(N, record);

        vertex.dist = 0;
        vertex.path = from;
        vertex.heappos = pQueue.add(from);

        
        while(pQueue.currentlen>0) {
            Vertex uVertex = pQueue.findMin();
            if(uVertex.known) {
                continue;
            }

            uVertex.known=true;

            ArrayList<AdjNode> adjNodes = adjtab.get(uVertex.v);
            for(AdjNode node : adjNodes) {
                //filtering blocked road(qu,qv)
                if(qu==uVertex.v && qv==node.v || qv==uVertex.v && qu==node.v) {
                    continue;
                }


                Vertex vVertex = record[node.v];
                if(vVertex.dist > uVertex.dist+node.w) {
                    //calibrate to uVertex
                    vVertex.dist = uVertex.dist+node.w;
                    vVertex.path = uVertex.v;
                    if(vVertex.heappos==-1) {
                        pQueue.add(vVertex.v);
                    } else {
                        pQueue.perloacteUp(vVertex.heappos);
                    }
                } else {
                    if(vVertex.heappos==-1) {
                        pQueue.add(vVertex.v);
                    }
                }
            }
        }

        vertex = record[to];
        if(vertex==null) {
            return Integer.MAX_VALUE;
        }
        return vertex.dist;
    }

    static class AdjNode {
        int v;
        int w;
    }

    static class Vertex {
        int v = -1;
        boolean known = false;
        int dist = Integer.MAX_VALUE;
        int path = -1;
        int heappos = -1;
    }

    //heap value is dist
    static class QueueHeap {
        int[] heaparray = null;
        int currentlen = 0;
        Vertex[] record = null;
        
        public QueueHeap(int heapsize, Vertex[] record) {
            this.heaparray = new int[heapsize+1];
            this.record = record;
        }

        public int add(int v) {
            currentlen++;
            heaparray[currentlen] = v;
            return perloacteUp(currentlen);
        }

        public int perloacteUp(int pos) {
            int origV = heaparray[pos];
            int tmp = record[origV].dist;
            int cur = pos;
            int hole = cur;
            for(;cur/2>0;hole=cur) {
                cur/=2;
                if(tmp<record[heaparray[cur]].dist) {
                    heaparray[hole] = heaparray[cur];
                    record[heaparray[cur]].heappos = hole;
                } else {
                    break;
                }
            }
            heaparray[hole] = origV;
            record[origV].heappos = hole;
            
            return hole;
        }

        public int perloacteDown(int pos) {
            int headV = heaparray[pos];
            int cur = pos;
            int hole = pos;
            for(;cur*2<=currentlen;hole=cur) {
                cur*=2;
                if(cur!=currentlen && record[cur].dist>record[cur+1].dist) {
                    cur++;
                }
                if(record[headV].dist < record[cur].dist) {
                    break;
                } else {
                    heaparray[hole] = heaparray[cur];
                    record[heaparray[cur]].heappos = hole;
                }
            }
            heaparray[hole] = headV;
            record[headV].heappos = hole;
            return hole;
        }

        public Vertex findMin() throws Exception {
            int min = heaparray[1];
            heaparray[1] = heaparray[currentlen];
            currentlen--;
            if(currentlen>0) {
                try{
                    perloacteDown(1);
                }catch(Exception e) {
                    throw new Exception("Exception occured:"+heaparray[1]);
                }
            }

            return record[min];
        }

    }
    
    public static HashMap<Integer, ArrayList<AdjNode>> readGraph(Scanner scanner, int M, boolean functional) throws Exception {
        HashMap<Integer, ArrayList<AdjNode>> adjtab = new HashMap<Integer, ArrayList<AdjNode>>();
        int counter = M;
        while(counter>0) {
            String line = scanner.nextLine();
            counter--;
            String[] input = line.split(" ");
            
            String w = "1";
            if(input.length>2) {
                w = input[2];
            }

            addFromToNode(input[0], input[1], w, adjtab);

            if(functional==false) {
                addFromToNode(input[1], input[0], w, adjtab);
            }
        }
        return adjtab;
    }

    private static void addFromToNode(String from, String to, String w, HashMap<Integer, ArrayList<AdjNode>> adjtab) {
        int u = Integer.parseInt(from);
        int v = Integer.parseInt(to);
        ArrayList<AdjNode> adjNodes = adjtab.get(u);
        if(adjNodes==null) {
            adjNodes = new ArrayList<AdjNode>();
            adjtab.put(u, adjNodes);
        }
        AdjNode adjN = new AdjNode();
        adjN.v = v;
        adjN.w = Integer.parseInt(w);
        adjNodes.add(adjN);
    }
}