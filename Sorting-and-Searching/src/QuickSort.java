import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] inputArr = new int[]{38, 27, 43, 3, 9, 82, 10};
//        int[] inputArr = new int[]{5, 4, 3, 2, 1};
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
//        System.out.println("Starting with array: ");
//        printArray(inputArr);

        quickSort(inputArr, 0, inputArr.length - 1);
        printArray(inputArr);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // the sublist has more than one element
            int partIndex = partition(arr, low, high);

            quickSort(arr, low, partIndex - 1); // left side of partIndex
            quickSort(arr, partIndex + 1, high); // right side of partIndex
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // take the last element as pivot
        int i = low - 1; // index of smaller element than pivot, would be 0 element if smaller than pivot is not found

        for (int j = low; j <= high; j++) { // looking for smaller than pivot and will swap if found
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
//                printArray(arr);
            }
        }

        swap(arr, i + 1, high); // pivot is the smallest number, swap with index of smallest number
//        printArray(arr);
        return i + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
