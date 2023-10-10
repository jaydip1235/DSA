

public class MedianOfTwoSorted  {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        // Se n1 for maior, troque os arrays:
        if (n1 > n2) return findMedianSortedArrays(b, a);

        int n = n1 + n2; // comprimento total
        int left = (n1 + n2 + 1) / 2; // comprimento da metade esquerda
        // Aplicar busca binária:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) >>> 1;
            int mid2 = left - mid1;
            // Calcular l1, l2, r1 e r2;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = a[mid1];
            if (mid2 < n2) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }

            // Elimine as metades:
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // declaração fictícia
    }

    public static void main(String[] args) {
        MedianOfTwoSorted solution = new MedianOfTwoSorted();
        int[] a = {1, 3};
        int[] b = {2};
        double result = solution.findMedianSortedArrays(a, b);
        System.out.println("Median: " + result);
    }
}
