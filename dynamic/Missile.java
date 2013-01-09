public class Missile {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("need input.");
            return;
        }
        String[] inputseqs = args[0].split(",");
        int hn = inputseqs.length;
        int[] h = new int[hn+1];
        h[0]=Integer.MAX_VALUE;
        for(int i=1;i<=hn;i++) {
            h[i]=Integer.parseInt(inputseqs[i-1]);
        }
        
        for(int i=0;i<h.length;i++) {
            System.out.print(h[i]+",");
        }

        System.out.println();
        int max = 0;
        int maxind = 0;
        int[] c = new int[h.length];
        for(int i=1;i<=hn;i++) {
            for(int j=0;j<=i-1;j++) {
                if(h[i]<h[j] && c[i]<c[j]+1) {
                    c[i]=c[j] + 1;
                    if(c[i] > max) {
                        max = c[i];
                        maxind = i;
                    }
                }
            }
        }

        System.out.println();
        for(int i=0;i<c.length;i++) {
            System.out.print(c[i]+",");
        }

        System.out.print("path:"+h[maxind]+",");
        for(int i=maxind;i>=1;) {
            for(int j=i-1;j>=1;j--) {
                if(h[i]<h[j] && c[i]==c[j]+1) {
                    i=j;
                    System.out.print(h[j]+",");
                }
            }
            if(i==1) {
                break;
            }
        }
        
    }
}