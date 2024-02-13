import java.util.Arrays;

public class Lab5 {

    static int findMax(int a[], int left, int right) {
        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            int maxLeft = findMax(a, left, mid);
            int maxRight = findMax(a, mid + 1, right);
            if (a[maxLeft] >= a[maxRight]) {
                return maxLeft;
            } else {
                return maxRight;
            }
        }
    }

    static int[] mergeSort(int[] A) {
        if (A.length > 1) {
            int mid = A.length / 2;
            int[] leftArray = Arrays.copyOfRange(A, 0, mid);
            int[] rightArray = Arrays.copyOfRange(A, mid, A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(leftArray, rightArray, A);
        }
        return A;
    }

    static void merge(int[] B, int[] C, int[] A) {
        int i = 0, j = 0, x = 0;

        while (i < B.length && j < C.length) {
            if (B[i] <= C[j]) {
                A[x] = B[i];
                i++;
            } else {
                A[x] = C[j];
                j++;
            }
            x++;
        }

        while (i < B.length) {
            A[x] = B[i];
            i++;
            x++;
        }

        while (j < C.length) {
            A[x] = C[j];
            j++;
            x++;
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 5, 8, 3, 6, 9, 1, 6, 5};
        int b[] = {3, 2, 7, 6, 8};
        System.out.printf("Q1) findMax\nMaximum element: position %d\n", findMax(a, 0, a.length - 1) + 1);

        System.out.print("Q2) mergeSort\n");
        System.out.println("Before sort:");

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");

        mergeSort(b);

        System.out.println("\nAfter sort:");

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + ", ");
    }

}
