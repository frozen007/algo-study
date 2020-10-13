public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        calculateLcs(s1, s2);
    }

    public static int calculateLcs(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int maxlen = 0;
        int[][] arr = new int[c1.length+1][c2.length+1];
        for(int i=1;i<=c1.length;i++) {
            for(int j=1;j<=c2.length;j++) {
                if(c1[i-1]==c2[j-1]) {
                    arr[i][j]=arr[i-1][j-1] + 1;
                } else if(arr[i-1][j]>arr[i][j-1]) {
                    arr[i][j]=arr[i-1][j];
                } else {
                    arr[i][j]=arr[i][j-1];
                }
            }
        }

        for(int i=1;i<=c2.length;i++) {
            System.out.print(c2[i-1]+",");
        }
        System.out.println();
        for(int i=1;i<=c1.length;i++) {
            System.out.print(c1[i-1]+":");
            for(int j=1;j<=c2.length;j++) {
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }

        return maxlen;
    }
}