import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {
    public static void main(String[] args) {
        double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};

        System.out.println("Raw array : :");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        bucketSort(arr);

        System.out.println("\n\nBucketSorted array :");
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bucketSort(double[] arr) {
        int n = arr.length;

        ArrayList<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
