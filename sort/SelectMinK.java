public class SelectMinK {
    public static void main(String[] args) {
        int[] array = new int[]{9,4,6,5,8,6,12,11,80};
        int[] array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        int k = 5;
        int start = 0;
        int end = array.length-1;        
        int dist = k;
        int result = 0;

        while(true) {
            int i = partMin(array, start, end);
            int c = i - start +1;
            if(dist == c) {
                result = i;
                break;
            } else if(dist > c) {
                dist = dist -c;
                start = i+1;
            } else {
                end = i;
            }
        }
        System.out.println(array[result]);

        System.out.println("sort by quicksort");
        QuickSort.sort(array2, 0, array2.length-1);
        for(int i=0;i<array2.length;i++) {
            System.out.print(array2[i]+",");
        }
    }

    public static int partMin(int[] a, int start, int end) {
        int index;
        int mid = (start+end)/2;
        int pv = a[mid];
        a[mid] = a[end];
        a[end] = pv;
        int right = end;
        int left = start;
        index = left;
        int swap;
        for(int i=left;i<=right;i++) {
            if(a[i]<=pv) {
                swap=a[index];
                a[index]=a[i];
                a[i]=swap;
                index++;
            }
        }
        
        return index-1;
    }
    
}