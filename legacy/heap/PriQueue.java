public class PriQueue {
    public static void main(String[] args) {
        int[] array = new int[]{0,10,1,3,5,7,9,11};
        percolateDown(1, array, array.length-1);
        for(int i=1;i<array.length;i++) {
            System.out.print(array[i]+",");
        }

        System.out.println();
        int[] array2 = new int[]{0,9,4,3,1,4,11,12,20,2};
        int len = array2.length -1;
        for(int cur = len/2;cur>0;cur--) {
            percolateDown(cur, array2, len);
        }
        for(int i=1;i<array2.length;i++) {
            System.out.print(array2[i]+",");
        }

        System.out.println();
        array2[1] = array2[len];
        len--;
        percolateDown(1, array2, len);
        for(int i=1;i<=len;i++) {
            System.out.print(array2[i]+",");
        }

        System.out.println();
        for(int i=1;i<array2.length;i++) {
            System.out.print(array2[i]+",");
        }
        System.out.println();
        System.out.println("sort by min:");
        len = array2.length-1;
        while(len>0) {
            int min = findMin(array2, len);
            len--;
            System.out.print(min+",");
        }
    }

    public static int findMin(int[] array, int len) {
        int min = array[1];
        array[1] = array[len];
        percolateDown(1, array, len-1);
        return min;
    }

    public static void percolateDown(int pos, int[] array, int len) {
        int head = array[pos];
        int cur = pos;
        int hole = pos;
        for(;cur*2<=len;) {
            cur = hole * 2;
            if(cur!=len && array[cur+1]<array[cur]) {
                cur++;
            }
            if(array[cur]<head) {
                array[hole]=array[cur];
            } else {
                break;
            }
            hole = cur;
        }
        array[hole] = head;
    }
}