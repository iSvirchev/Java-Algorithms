import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
//        int[] inputArr = new int[]{38, 27, 43, 3, 9, 82, 10};
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        System.out.println("Starting with array: ");
//        printArray(inputArr);

        sort(inputArr, 0, inputArr.length - 1);

//        System.out.println("Sorted array: ");
        printArray(inputArr);
    }

    static void sort(int[] arr, int left, int right) {
        if (left < right) { // else - means 1 element in the split array
            int mid = left + (right - left) / 2;
            sort(arr, left, mid); // Left array has been split io the middle - calling self ot split once again (if possible)
            sort(arr, mid + 1, right); // Right array split in the middle
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) { // copy left array
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArrSize; i++) { // copy right array
            rightArr[i] = arr[mid + 1 + i];
        }

        int leftArrIndex = 0;
        int rightArrIndex = 0;

        int mergeIndex = left;
        // compare first element from left array to first element from right array - take smallest and insert into sorted array
        // if taken from left - move +1 element and compare again to the first elem from right array and vice versa
        while (leftArrIndex < leftArrSize && rightArrIndex < rightArrSize) {
            if (leftArr[leftArrIndex] < rightArr[rightArrIndex]) {
                arr[mergeIndex] = leftArr[leftArrIndex++];
            } else {
                arr[mergeIndex] = rightArr[rightArrIndex++];
            }
            mergeIndex++;
        }

        while (leftArrIndex < leftArrSize) {
            arr[mergeIndex++] = leftArr[leftArrIndex++];
        }
        while (rightArrIndex < rightArrSize) {
            arr[mergeIndex++] = rightArr[rightArrIndex++];
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

}
