import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int c = 0; c < n1; c++) {
            L[c] = arr[left + c];
        }
        for (int a = 0; a < n2; a++) {
            R[a] = arr[mid + 1 + a];
        }

        int c = 0, j = 0, k = left;
        while (c < n1 && j < n2) {
            if (L[c] <= R[j]) {
                arr[k] = L[c];
                c++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (c < n1) {
            arr[k] = L[c];
            c++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Unsorted array: " + Arrays.toString(arr));

        MergeSort(arr, 0, size - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
