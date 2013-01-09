public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{9,2,4,6,1,7,5,8,6,12,11,80};
        sort(array, 0, array.length-1);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]+",");
        }
    }

    public static void sort(int[] a, int start, int end) {
        if(start == end) {
            return;
        }
        int i = start;
        int j = end;
        int mid = (i + j)/2;
        int pv = a[mid];
        int p = j;
        a[mid] = a[j];
        a[j] = pv;
        j--;
        int swap = 0;

        for(;;) {
            while(i<p && a[i]<a[p]) {
                i++;
            }
            while(j>0 && a[j]>a[p]) {
                j--;
            }
            if(i>=j) {
                break;
            } else {
                swap = a[j];
                a[j] = a[i];
                a[i] = swap;
            }
        }
        a[p] = a[i];
        a[i] = pv;
        p = i;

        if(p-1>=start) {
            sort(a, start, p-1);
        }
        if(p+1<=end) {
            sort(a, p+1, end);
        }
    }
}