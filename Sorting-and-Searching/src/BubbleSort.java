import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        int[] inputArr = new int[]{38, 27, 43, 3, 9, 82, 10};
        sort(inputArr);
        printArray(inputArr);
    }

    static void sort(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                swap(arr, i, i + 1);
            }
        }

        if (!isSorted) {
            sort(arr);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
    }
}
