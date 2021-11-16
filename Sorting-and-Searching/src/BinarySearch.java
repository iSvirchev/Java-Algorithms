import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int indexToFind = Integer.parseInt(scanner.nextLine());
        search(indexToFind, inputArr, 0, inputArr.length);
    }

    static void search(int locate, int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (locate < arr[mid]) {
            if (mid - 1 < 0) {
                System.out.println("-1");
                return;
            }
            search(locate, arr, low, mid - 1);
        } else if (locate > arr[mid]) {
            if (mid + 1 >= arr.length) {
                System.out.println("-1");
                return;
            }
            search(locate, arr, mid + 1, high);
        } else if (locate == arr[mid]) { // number found
            System.out.println(mid);
        }

    }
}
