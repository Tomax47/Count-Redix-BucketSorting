import java.util.Arrays;
import java.util.Random;

public class CountingSortAlgorithm {
    public static void main(String[] args) {
        int[] a = new int[10];
        fillArray(a, 0, 10);

        System.out.println(Arrays.toString(a));

        countSortArray(a);
        System.out.println(Arrays.toString(a));
    }

    public static void fillArray(int[] arr, int lowerBound, int upperBound) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(upperBound - lowerBound) + lowerBound;
        }
    }

    public static void countSortArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int[] count = new int[max + 1];
        for (int a : arr) {
            count[a]++;
        }
        int j = 0;
        for (int a = 0; a < count.length; a++) {
            for (int i = 0; i < count[a]; i++) {
                arr[j++] = a;
            }
        }
    }
}
